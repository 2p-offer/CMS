package com.wy.manager.mp.analysisplatform.api.utils;

import com.wy.manager.mp.analysisplatform.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2P on 19-3-21.
 */
public class DataParseUtils {

    public static List<BiologicalArgs> parstToBiological(List<String[]> lists) {
        List<BiologicalArgs> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return null;
        }
        for (String[] strings : lists) {
            BiologicalArgs tmp = new BiologicalArgs();
            tmp.setWetlandplants(strings[0]);
            tmp.setPhytoplankton(strings[1]);
            tmp.setZooplankton(strings[2]);
            tmp.setBenthos(strings[3]);
            tmp.setFish(strings[4]);
            tmp.setUptime(strings[5]);
            res.add(tmp);
        }
        return res;
    }

    public static List<HydrologyArgs> parstToHydrology(List<String[]> lists) {
        List<HydrologyArgs> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return null;
        }
        for (String[] strings : lists) {
            HydrologyArgs tmp = new HydrologyArgs();
            tmp.setCurrentspeed(strings[0]);
            tmp.setFlowto(strings[1]);
            tmp.setWaterlevel(strings[2]);
            tmp.setUptime(strings[3]);
            res.add(tmp);
        }
        return res;
    }

    public static List<MeteorologicalArgs> parstToMeteorological(List<String[]> lists) {
        List<MeteorologicalArgs> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return null;
        }
        for (String[] strings : lists) {
            MeteorologicalArgs tmp = new MeteorologicalArgs();
            tmp.setWindspeed(strings[0]);
            tmp.setAirtemperature(strings[1]);
            tmp.setPrecipitation(strings[2]);
            tmp.setEvaporation(strings[3]);
            tmp.setRadiation(strings[4]);
            tmp.setUptime(strings[5]);
            res.add(tmp);
        }
        return res;
    }

    public static List<SoilArgs> parstToSoil(List<String[]> lists) {
        List<SoilArgs> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return null;
        }
        for (String[] strings : lists) {
            SoilArgs tmp = new SoilArgs();
            tmp.setCnps(strings[0]);
            tmp.setHeavymetal(strings[1]);
            tmp.setPh(strings[2]);
            tmp.setSaltion(strings[3]);
            tmp.setWatercontent(strings[4]);
            tmp.setUptime(strings[5]);
            res.add(tmp);
        }
        return res;
    }

    public static List<WaterQualityArgs> parstToWaterQuality(List<String[]> lists) {
        List<WaterQualityArgs> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return null;
        }
        for (String[] strings : lists) {
            WaterQualityArgs tmp = new WaterQualityArgs();
            tmp.setPh(strings[0]);
            tmp.setDissolvedoxygen(strings[1]);
            tmp.setConductivity(strings[2]);
            tmp.setTurbidity(strings[3]);
            tmp.setTemperature(strings[4]);
            tmp.setSalinity(strings[5]);
            tmp.setAmmonianitrogen(strings[6]);
            tmp.setTotalnitrogen(strings[7]);
            tmp.setTotalphosphorus(strings[8]);
            tmp.setKmno4(strings[9]);
            tmp.setUptime(strings[10]);
            res.add(tmp);
        }
        return res;
    }

}
