package com.wy.manager.mp.log.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wy.manager.mp.common.config.UrcsManagerConfig;
import com.wy.manager.mp.log.api.LogOperatorService;
import com.wy.manager.mp.log.utils.HttpApacheClientUtil;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogOperatorServiceImpl implements LogOperatorService {

    @Autowired
    private UrcsManagerConfig urcsManagerConfig;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Override
    public List<Object> getOperatorList(Map<String, Object> map) {
        String listUrl= "list?startTime=%s&endTime=%s&start=%s&limit=%s";
        String formatListUrl = String.format(listUrl, map.get("startTime"), map.get("endTime"),
                map.get("start"), map.get("limit"));
        String doUrl = urcsManagerConfig.getLogOperatorUrl() + formatListUrl;
        List<Object> objectList = new ArrayList<>();
        try {
            HttpResponse httpResponse = HttpApacheClientUtil.httpGet(doUrl, new HashMap<>());
            InputStream content = httpResponse.getEntity().getContent();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int readNum  = 0;
            byte[] tmp = new byte[1024];
            while ((readNum = content.read(tmp)) > 0){
                outputStream.write(tmp, 0, readNum);
            }
            String contentStr = new String(outputStream.toByteArray());
            JSONArray jsonArray = JSONObject.parseArray(contentStr);
            for (Object object:jsonArray.toArray()) {
                JSONObject jsonObject = JSON.parseObject(object.toString());
                objectList.add(jsonObject);
            }

        } catch (Exception e){
            LOGGER.error("getOperatorList", e);
        }

        return objectList;
    }

    @Override
    public Object getOperator(String key) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        String countUrl= "count?startTime=%s&endTime=%s";
        String formatCountUrl = String.format(countUrl, map.get("startTime"), map.get("endTime"));
        String doUrl = urcsManagerConfig.getLogOperatorUrl() + formatCountUrl;
        try {
            HttpResponse httpResponse = HttpApacheClientUtil.httpGet(doUrl, new HashMap<>());
            InputStream content = httpResponse.getEntity().getContent();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int readNum  = 0;
            byte[] tmp = new byte[1024];
            while ((readNum = content.read(tmp)) > 0){
                outputStream.write(tmp, 0, readNum);
            }
            String contentStr = new String(outputStream.toByteArray());
            JSONObject jsonObject = JSON.parseObject(contentStr);
            if (jsonObject.get("count") != null){
                return jsonObject.getInteger("count");
            }
        } catch (Exception e){
            LOGGER.error("getOperatorList", e);
        }

        return 0;
    }
}
