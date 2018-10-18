package com.urcs.manager.mp.log.api;

import java.util.List;
import java.util.Map;

public interface LogOperatorService {
    List<Object> getOperatorList(Map<String, Object> map);
    Object getOperator(String key);
    int count(Map<String, Object> map);
}
