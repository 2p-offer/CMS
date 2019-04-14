package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.MeteorologicalArgs;
import com.wy.manager.mp.analysisplatform.service.MeteorologicalService;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
public class MeteorologicalServiceImpl implements MeteorologicalService {
    @Override
    public List<MeteorologicalArgs> list(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<MeteorologicalArgs> listAll() {
        return null;
    }

    @Override
    public MeteorologicalArgs get(Long id) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int save(MeteorologicalArgs bio) {
        return 0;
    }

    @Override
    public int update(MeteorologicalArgs bio) {
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
