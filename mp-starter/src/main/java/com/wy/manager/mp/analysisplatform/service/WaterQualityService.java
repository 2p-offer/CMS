package com.wy.manager.mp.analysisplatform.service;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.WaterQualityArgs;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
public interface WaterQualityService {
    //分页查询
    public List<WaterQualityArgs> list(Map<String, Object> map);

    public List<WaterQualityArgs> listAll(Map<String, Object> map);

    WaterQualityArgs get(Long id);

    int count(Map<String, Object> map);

    int save(WaterQualityArgs bio);

    int update(WaterQualityArgs bio);

    int remove(String id);

    int batchremove(String[] ids);

    boolean exit(Map<String, Object> params);
}
