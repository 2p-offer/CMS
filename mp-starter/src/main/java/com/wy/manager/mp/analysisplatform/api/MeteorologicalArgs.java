package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 气象数据
 * Created by 2P on 19-3-14.
 */
public class MeteorologicalArgs {

    @JSONField(name="id")
    private String id;

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

    @JSONField(name="uptime")
    private String uptime;

    @JSONField(name="jingdu")
    private String jingdu;

    @JSONField(name="weidu")
    private String weidu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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


    public String getUptime() {
        return uptime;
    }


    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }
}
