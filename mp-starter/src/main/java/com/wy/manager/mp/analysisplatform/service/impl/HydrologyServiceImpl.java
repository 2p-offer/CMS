package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.HydrologyArgs;
import com.wy.manager.mp.analysisplatform.dao.HydrologyDao;
import com.wy.manager.mp.analysisplatform.service.HydrologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
@Service
public class HydrologyServiceImpl implements HydrologyService {

    @Autowired
    HydrologyDao hydrologyDao;

    @Override
    public List<HydrologyArgs> list(Map<String, Object> map) {
        return hydrologyDao.getHydrology(map);
    }

    @Override
    public List<HydrologyArgs> listAll() {
        return null;
    }

    @Override
    public HydrologyArgs get(Long id) {
        return hydrologyDao.getHydrologyById(id.toString());
    }

    @Override
    public int count(Map<String, Object> map) {
        return hydrologyDao.getCount(map);
    }

    @Override
    public int save(HydrologyArgs bio) {
         hydrologyDao.insertHydrology(bio);
         return 1;
    }

    @Override
    public int update(HydrologyArgs bio) {
        return 0;
    }

    @Override
    public int remove(String id) {
        return hydrologyDao.remove(id);
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
