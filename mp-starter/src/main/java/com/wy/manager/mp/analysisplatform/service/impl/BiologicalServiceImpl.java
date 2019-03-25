package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.dao.BiologicalDao;
import com.wy.manager.mp.analysisplatform.service.BiologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
@Service
public class BiologicalServiceImpl implements BiologicalService {

    @Autowired
    public BiologicalDao biologicalDao;

    @Override
    public List<BiologicalArgs> list(Map<String, Object> map) {
        return biologicalDao.getBiological(map);
    }

    @Override
    public BiologicalArgs get(Long id) {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        return biologicalDao.getCount(map);
    }

    @Override
    public int save(BiologicalArgs bio) {
        return 0;
    }

    @Override
    public int update(BiologicalArgs bio) {
        return 0;
    }

    @Override
    public int remove(String id) {
        return biologicalDao.remove(id);
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
