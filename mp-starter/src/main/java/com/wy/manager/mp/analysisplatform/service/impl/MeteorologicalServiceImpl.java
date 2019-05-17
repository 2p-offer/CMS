package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.MeteorologicalArgs;
import com.wy.manager.mp.analysisplatform.dao.MeteorologicalDao;
import com.wy.manager.mp.analysisplatform.service.MeteorologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
@Service
public class MeteorologicalServiceImpl implements MeteorologicalService {

    @Autowired
    MeteorologicalDao meteorologicalDao;

    @Override
    public List<MeteorologicalArgs> list(Map<String, Object> map) {
        return meteorologicalDao.getMeteorologicall(map);
    }

    @Override
    public List<MeteorologicalArgs> listAll(Map<String, Object> map) {
        return meteorologicalDao.getMeteorologicalAll(map);
    }

    @Override
    public MeteorologicalArgs get(Long id) {
        return meteorologicalDao.getMeteorologicalById(id.toString());
    }

    @Override
    public int count(Map<String, Object> map) {
        return meteorologicalDao.getCount(map);
    }

    @Override
    public int save(MeteorologicalArgs bio) {
        meteorologicalDao.insertMeteorological(bio);
        return 0;
    }

    @Override
    public int update(MeteorologicalArgs bio) {
        return 0;
    }

    @Override
    public int remove(String id) {
        return meteorologicalDao.remove(id);
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
