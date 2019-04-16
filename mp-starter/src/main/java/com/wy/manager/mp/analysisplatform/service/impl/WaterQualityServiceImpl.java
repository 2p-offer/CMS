package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.WaterQualityArgs;
import com.wy.manager.mp.analysisplatform.dao.WaterQualityDao;
import com.wy.manager.mp.analysisplatform.service.WaterQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
@Service
public class WaterQualityServiceImpl implements WaterQualityService {

    @Autowired
    WaterQualityDao waterQualityDao;
    @Override
    public List<WaterQualityArgs> list(Map<String, Object> map) {
        return waterQualityDao.getWaterQuality(map);
    }

    @Override
    public List<WaterQualityArgs> listAll() {
        return waterQualityDao.getWaterQualityAll();
    }

    @Override
    public WaterQualityArgs get(Long id) {
        return waterQualityDao.getWaterQualityById(id.toString());
    }

    @Override
    public int count(Map<String, Object> map) {
        return waterQualityDao.getCount(map);
    }

    @Override
    public int save(WaterQualityArgs bio) {
        waterQualityDao.insertWaterQuality(bio);
        return 1;
    }

    @Override
    public int update(WaterQualityArgs bio) {
        return 0;
    }

    @Override
    public int remove(String id) {
        return waterQualityDao.remove(id);
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
