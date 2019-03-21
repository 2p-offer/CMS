package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.api.FileToArgType;
import com.wy.manager.mp.analysisplatform.api.utils.DataParseUtils;
import com.wy.manager.mp.analysisplatform.api.utils.SheetUtils;
import com.wy.manager.mp.analysisplatform.dao.BiologicalDao;
import com.wy.manager.mp.analysisplatform.service.FileReceiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by 2P on 19-3-21.
 */
@Service
public class FileReceiveServiceImpl implements FileReceiveService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BiologicalDao biologicalDao;

    @Override
    public Object dealFile(MultipartFile file, String fileType) {

        Object o = null;
        switch (fileType) {
            case FileToArgType
                    .biological:
                List<String[]> strings = null;
                try {
                    strings = SheetUtils.readExcel(file);
                    List<BiologicalArgs> lists = DataParseUtils.parstToBiological(strings);
                    for (BiologicalArgs biologicalArgs : lists) {
                        biologicalDao.insertBiological(biologicalArgs);
                        LOGGER.info("insertBiological list success..");
                    }
                    o="OK";
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("deal biological error:"+e.getMessage());
                }
                break;
            case FileToArgType
                    .hydrology:
                break;
            case FileToArgType
                    .meteorological:
                break;
            case FileToArgType
                    .soil:
                break;
            case FileToArgType
                    .waterQuality:
                break;
            default:
                LOGGER.error("illegal fileType:"+fileType);

        }
        return o;
    }
}