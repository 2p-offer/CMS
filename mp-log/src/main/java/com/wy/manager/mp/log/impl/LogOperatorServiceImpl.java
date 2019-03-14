package com.wy.manager.mp.log.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Override
    public List<Object> getOperatorList(Map<String, Object> map) {

        return null;
    }

    @Override
    public Object getOperator(String key) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {


        return 0;
    }
}
