package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.SoilArgs;
import com.wy.manager.mp.analysisplatform.dao.SoilDao;
import com.wy.manager.mp.analysisplatform.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
@Service
public class SoilServiceImpl implements SoilService {

    @Autowired
    SoilDao soilDao;
    @Override
    public List<SoilArgs> list(Map<String, Object> map) {
        return soilDao.getSoil(map);
    }

    @Override
    public List<SoilArgs> listAll() {

        return soilDao.getSoilAll();
    }

    @Override
    public SoilArgs get(Long id) {
        return soilDao.getSoilById(id.toString());
    }

    @Override
    public int count(Map<String, Object> map) {
        return soilDao.getCount(map);
    }

    @Override
    public int save(SoilArgs bio) {
        soilDao.insertSoil(bio);
        return 1;
    }

    @Override
    public int update(SoilArgs bio) {
        return 0;
    }

    @Override
    public int remove(String id) {
        return soilDao.remove(id);
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
