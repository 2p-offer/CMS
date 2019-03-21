package com.wy.manager.mp.analysisplatform.api.utils;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
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
            res.add(tmp);
        }
        return res;
    }

    public static BiologicalArgs parstToHydrology(List<String[]> lists) {
        return null;
    }

    public static BiologicalArgs parstToMeteorological(List<String[]> lists) {
        return null;
    }

    public static BiologicalArgs parstToSoil(List<String[]> lists) {
        return null;
    }

    public static BiologicalArgs parstToWaterQuality(List<String[]> lists) {
        return null;
    }

}
