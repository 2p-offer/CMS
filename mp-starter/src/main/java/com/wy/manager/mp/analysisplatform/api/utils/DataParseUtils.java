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
            tmp.setFlow(strings[2]);
            tmp.setUplevel(strings[3]);
            tmp.setDownlevel(strings[4]);
            tmp.setUptime(strings[5]);
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
            tmp.setC(strings[0]);
            tmp.setN(strings[1]);
            tmp.setS(strings[2]);
            tmp.setP(strings[3]);
            tmp.setPh(strings[4]);
            tmp.setWatercontent(strings[5]);
            tmp.setDeep(strings[6]);
            tmp.setK(strings[7]);
            tmp.setCa(strings[8]);
            tmp.setNa(strings[9]);
            tmp.setMg(strings[10]);
            tmp.setCl(strings[11]);
            tmp.setSo4(strings[12]);
            tmp.setNo3(strings[13]);
            tmp.setCo3(strings[14]);
            tmp.setConductivity(strings[15]);
            tmp.setSom(strings[16]);
            tmp.setPom(strings[17]);
            tmp.setDoc(strings[18]);
            tmp.setShen(strings[19]);
            tmp.setGe2(strings[20]);
            tmp.setTong(strings[21]);
            tmp.setQian(strings[22]);
            tmp.setXin(strings[23]);
            tmp.setNie(strings[24]);
            tmp.setGe4(strings[25]);
            tmp.setGai(strings[26]);
            tmp.setMei(strings[27]);
            tmp.setTie(strings[28]);
            tmp.setLv(strings[29]);
            tmp.setQuandan(strings[30]);
            tmp.setQuanlin(strings[31]);
            tmp.setQuanliu(strings[32]);
//            tmp.setWarning(strings[33]);
            tmp.setUptime(strings[33]);
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
            tmp.setK(strings[10]);
            tmp.setCa(strings[11]);
            tmp.setNa(strings[12]);
            tmp.setMg(strings[13]);
            tmp.setCl(strings[14]);
            tmp.setSo4(strings[15]);
            tmp.setNo3(strings[16]);
            tmp.setCo3(strings[17]);
            tmp.setDoc(strings[18]);
            tmp.setShen(strings[19]);
            tmp.setGe2(strings[20]);
            tmp.setTong(strings[21]);
            tmp.setQian(strings[22]);
            tmp.setXin(strings[23]);
            tmp.setNie(strings[24]);
            tmp.setGe4(strings[25]);
            tmp.setGai(strings[26]);
            tmp.setMei(strings[27]);
            tmp.setTie(strings[28]);
            tmp.setLv(strings[29]);
            tmp.setQuandan(strings[30]);
            tmp.setQuanlin(strings[31]);
            tmp.setQuanliu(strings[32]);
            tmp.setUptime(strings[33]);
            res.add(tmp);
        }
        return res;
    }

}
