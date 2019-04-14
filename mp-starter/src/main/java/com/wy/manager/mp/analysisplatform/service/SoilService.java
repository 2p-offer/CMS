package com.wy.manager.mp.analysisplatform.service;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.SoilArgs;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
public interface SoilService {
    //分页查询
    public List<SoilArgs> list(Map<String, Object> map);

    List<SoilArgs> listAll();

    SoilArgs get(Long id);

    int count(Map<String, Object> map);

    int save(SoilArgs bio);

    int update(SoilArgs bio);

    int remove(String id);

    int batchremove(String[] ids);

    boolean exit(Map<String, Object> params);
}
