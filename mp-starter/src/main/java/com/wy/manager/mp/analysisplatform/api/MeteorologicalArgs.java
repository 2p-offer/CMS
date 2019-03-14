package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 气象数据
 * Created by 2P on 19-3-14.
 */
public class MeteorologicalArgs {
    //风速
    @JSONField(name="windspeed")
    private String windspeed;
    //气温
    @JSONField(name="airtemperature")
    private String airtemperature;
    //降水
    @JSONField(name="precipitation")
    private String precipitation;
    //蒸发
    @JSONField(name="evaporation")
    private String evaporation;
    //辐射
    @JSONField(name="radiation")
    private String radiation;
    //扩展字段
    private String ext;

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getAirtemperature() {
        return airtemperature;
    }

    public void setAirtemperature(String airtemperature) {
        this.airtemperature = airtemperature;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getEvaporation() {
        return evaporation;
    }

    public void setEvaporation(String evaporation) {
        this.evaporation = evaporation;
    }

    public String getRadiation() {
        return radiation;
    }

    public void setRadiation(String radiation) {
        this.radiation = radiation;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
