package com.wy.manager.mp.analysisplatform.service;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.MeteorologicalArgs;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
public interface MeteorologicalService {
    //分页查询
    public List<MeteorologicalArgs> list(Map<String, Object> map);

    public List<MeteorologicalArgs> listAll();


    MeteorologicalArgs get(Long id);

    int count(Map<String, Object> map);

    int save(MeteorologicalArgs bio);

    int update(MeteorologicalArgs bio);

    int remove(String id);

    int batchremove(String[] ids);

    boolean exit(Map<String, Object> params);
}
