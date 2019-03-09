package com.wy.manager.mp.log.api;

import java.util.List;
import java.util.Map;
/**
 * @Author: wangyan
 * @Date: 2019/2/10
 */
public interface LogOperatorService {
    List<Object> getOperatorList(Map<String, Object> map);
    Object getOperator(String key);
    int count(Map<String, Object> map);
}
