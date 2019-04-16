package com.wy.manager.mp.analysisplatform.service.impl;

import com.wy.manager.mp.analysisplatform.api.*;
import com.wy.manager.mp.analysisplatform.api.utils.DataParseUtils;
import com.wy.manager.mp.analysisplatform.api.utils.SheetUtils;
import com.wy.manager.mp.analysisplatform.dao.*;
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
    @Autowired
    HydrologyDao hydrologyDao;
    @Autowired
    MeteorologicalDao meteorologicalDao;
    @Autowired
    SoilDao soilDao;
    @Autowired
    WaterQualityDao waterQualityDao;

    @Override
    public Object dealFile(MultipartFile file, String fileType) {

        Object o = null;

        List<String[]> strings = null;
        switch (fileType) {
            case FileToArgType
                    .biological:
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
                try {
                    strings = SheetUtils.readExcel(file);
                    List<HydrologyArgs> lists = DataParseUtils.parstToHydrology(strings);
                    for (HydrologyArgs hydrologyArgs : lists) {
                        hydrologyDao.insertHydrology(hydrologyArgs);
                        LOGGER.info("inserthydrology list success..");
                    }
                    o="OK";
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("deal hydrology error:"+e.getMessage());
                }
                break;
            case FileToArgType
                    .meteorological:
                try{
                    strings=SheetUtils.readExcel(file);
                    List<MeteorologicalArgs> meteorologicalArgs = DataParseUtils.parstToMeteorological(strings);
                    for (MeteorologicalArgs meteorological : meteorologicalArgs){
                        meteorologicalDao.insertMeteorological(meteorological);
                    }
                }catch (Exception e){

                    e.printStackTrace();
                    LOGGER.error("deal meteorological error:"+e.getMessage());
                }
                break;
            case FileToArgType
                    .soil:
                try{
                    strings=SheetUtils.readExcel(file);
                    List<SoilArgs> soilArgs = DataParseUtils.parstToSoil(strings);
                    for(SoilArgs soil : soilArgs){
                        soilDao.insertSoil(soil);
                    }
                }catch (Exception e){

                    e.printStackTrace();
                    LOGGER.error("deal soil error:"+e.getMessage());
                }
                break;
            case FileToArgType
                    .waterQuality:
                try{
                    strings=SheetUtils.readExcel(file);
                    List<WaterQualityArgs> waterQualityArgs = DataParseUtils.parstToWaterQuality(strings);
                    for (WaterQualityArgs waterQuality :waterQualityArgs){
                        waterQualityDao.insertWaterQuality(waterQuality);
                    }
                }catch (Exception e){

                    e.printStackTrace();
                    LOGGER.error("deal waterQuality error:"+e.getMessage());
                }

                break;
            default:
                LOGGER.error("illegal fileType:"+fileType);

        }
        return o;
    }
}