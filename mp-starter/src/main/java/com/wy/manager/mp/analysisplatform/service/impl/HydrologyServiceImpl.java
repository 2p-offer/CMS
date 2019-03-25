package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.HydrologyArgs;
import com.wy.manager.mp.analysisplatform.service.HydrologyService;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
public class HydrologyServiceImpl implements HydrologyService {

    @Override
    public List<HydrologyArgs> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public HydrologyArgs get(Long id) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int save(HydrologyArgs bio) {
        return 0;
    }

    @Override
    public int update(HydrologyArgs bio) {
        return 0;
    }

    @Override
    public int remove(String id) {
        return 0;
    }

    @Override
    public int batchremove(String[] ids) {
        return 0;
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        return false;
    }
}
