package com.wy.manager.mp.analysisplatform.service;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.HydrologyArgs;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
public interface HydrologyService {
    //分页查询
    public List<HydrologyArgs> list(Map<String, Object> map);

    public List<HydrologyArgs> listAll();


    HydrologyArgs get(Long id);

    int count(Map<String, Object> map);

    int save(HydrologyArgs bio);

    int update(HydrologyArgs bio);

    int remove(String id);

    int batchremove(String[] ids);

    boolean exit(Map<String, Object> params);
}
