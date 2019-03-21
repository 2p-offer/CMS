package com.wy.manager.mp.analysisplatform.api.utils;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;

import java.util.List;

/**
 * Created by 2P on 19-3-21.
 */
public class DataParseUtils {
    public static BiologicalArgs parstToBiological(List<String[]> lists){
        BiologicalArgs res=new BiologicalArgs();
        if(lists==null || lists.size()==0){
            return null;
        }
        for(String[] strings:lists){
//            for(int i=0;i<strings.length;i++){
//
//            }
            try {
                res.setWetlandplants(strings[0]);
                res.setPhytoplankton(strings[1]);
                res.setZooplankton(strings[2]);
                res.setBenthos(strings[3]);
                res.setFish(strings[4]);
            }catch (Exception e){

            }
        }
        return res;
    }
}
