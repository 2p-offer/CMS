package com.urcs.manager.mp.log.utils;//package com.feinno.urcs.im.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * apache官方http工具类
 *
 * Created by wuhao on 15-8-5.
 */
public class HttpApacheClientUtil {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    /**
     *发送HttpPost方法
     *
     * @param requestUrl
     * @param requestHeaderMap
     * @param requestBody
     * @return
     * @throws IOException
     */
    public static HttpResponse httpPost(String requestUrl, Map<String, String> requestHeaderMap, String requestBody) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(requestUrl);
        if (requestHeaderMap != null) {
            for (String key : requestHeaderMap.keySet()) {
                httpPost.setHeader(key, requestHeaderMap.get(key));
            }
        }
        if (requestBody != null && requestBody.length() > 0) {
            byte[] content = requestBody.getBytes("utf-8");
            ByteArrayEntity entity = new ByteArrayEntity(content);
            httpPost.setEntity(entity);
        }

        return httpClient.execute(httpPost);
    }
    /**
     *发送HttpPost方法
     *
     * @param requestUrl
     * @param requestHeaderMap
     * @param requestBody
     * @return
     * @throws IOException
     */
    public static HttpResponse httpPostAsyn(String requestUrl, Map<String, String> requestHeaderMap, String requestBody) throws IOException {
        CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.createDefault();
        HttpPost httpPost = new HttpPost(requestUrl);
        if (requestHeaderMap != null) {
            for (String key : requestHeaderMap.keySet()) {
                httpPost.setHeader(key, requestHeaderMap.get(key));
            }
        }
        if (requestBody != null && requestBody.length() > 0) {
            byte[] content = requestBody.getBytes("utf-8");
            ByteArrayEntity entity = new ByteArrayEntity(content);
            httpPost.setEntity(entity);
        }
        HttpResponse response = null;
        try {
            httpAsyncClient.start();
            Future<HttpResponse> future = httpAsyncClient.execute(httpPost, null);
            response = future.get();// 获取结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    /**
     *发送 httpPostMultiPartAsyn方法
     *
     * @return
     * @throws IOException
     */
    public static HttpResponse httpPostMultiPartAsyn(final String url, final Map<String, String> headerMap, final HttpEntity httpEntity) {
        new Thread(){
            @Override
            public void run() {
                httpPostMultiPart(url, headerMap, httpEntity);
            }
        }.start();
        return null;
    }
    /**
     *发送httpPostMultiPart方法
     *
     * @return
     * @throws IOException
     */
    public static HttpResponse httpPostMultiPart(String url, Map<String, String> headerMap, HttpEntity httpEntity) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse response = null;
        if (headerMap != null) {
            for (String key : headerMap.keySet()) {
                httpPost.setHeader(key, headerMap.get(key));
            }
        }
        httpPost.setEntity(httpEntity);
        try {
            httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 发送HttpPut方法
     *
     *
     * @param requestUrl
     * @param requestHeaderMap
     * @param requestBody
     * @return
     * @throws IOException
     */
    public static HttpResponse httpPut(String requestUrl, Map<String, String> requestHeaderMap, String requestBody) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(requestUrl);
        if (requestHeaderMap != null) {
            for (String key : requestHeaderMap.keySet()) {
                httpPut.setHeader(key, requestHeaderMap.get(key));
            }
        }
        if (requestBody != null && requestBody.length() > 0) {
            byte[] content = requestBody.getBytes("utf-8");
            ByteArrayEntity entity = new ByteArrayEntity(content);
            httpPut.setEntity(entity);
        }

        return httpClient.execute(httpPut);
    }

    /**
     * 发送HttpGet方法
     *
     * @param requestUrl
     * @param requestHeaderMap
     * @return
     * @throws IOException
     */
    public static HttpResponse httpGet(String requestUrl, Map<String, String> requestHeaderMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setConfig(createConfig(5000, false));
        if (requestHeaderMap != null) {
            for (String key : requestHeaderMap.keySet()) {
                httpGet.setHeader(key, requestHeaderMap.get(key));
            }
        }

        return httpClient.execute(httpGet);
    }

    private static RequestConfig createConfig(int timeout, boolean redirectsEnabled) {
        return  RequestConfig.custom()
            .setSocketTimeout(timeout)
            .setConnectTimeout(timeout)
            .setConnectionRequestTimeout(timeout)
            .setRedirectsEnabled(redirectsEnabled)
            .build();
    }

    /**
     * 发送HttpDelete方法
     *
     * @param requestUrl
     * @param requestHeaderMap
     * @return
     * @throws IOException
     */
    public static HttpResponse httpDelete(String requestUrl, Map<String, String> requestHeaderMap, String requestBody) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ImHttpDelete imHttpDelete = new ImHttpDelete(requestUrl);
        if (requestHeaderMap != null) {
            for (String key : requestHeaderMap.keySet()) {
                imHttpDelete.setHeader(key, requestHeaderMap.get(key));
            }
        }
        if (requestBody != null && requestBody.length() > 0) {
            byte[] content = requestBody.getBytes("utf-8");
            ByteArrayEntity entity = new ByteArrayEntity(content);
            imHttpDelete.setEntity(entity);
        }

        return httpClient.execute(imHttpDelete);
    }
    static class ImHttpDelete extends HttpEntityEnclosingRequestBase {
        public final static String METHOD_NAME = "DELETE";

        public ImHttpDelete() {
            super();
        }

        public ImHttpDelete(final URI uri) {
            super();
            setURI(uri);
        }

        /**
         * @throws IllegalArgumentException if the uri is invalid.
         */
        public ImHttpDelete(final String uri) {
            super();
            setURI(URI.create(uri));
        }

        @Override
        public String getMethod() {
            return METHOD_NAME;
        }
    }

}
