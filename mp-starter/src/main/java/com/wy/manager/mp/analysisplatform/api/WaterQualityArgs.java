package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 生境指标下的水质指标
 * Created by 2P on 19-3-14.
 */
public class WaterQualityArgs {

    @JSONField(name="id")
    private String id;

    //ph
    @JSONField(name="ph")
    private String ph;
    //溶解氧
    @JSONField(name="dissolvedoxygen")
    private String dissolvedoxygen;
    //电导率
    @JSONField(name="conductivity")
    private String conductivity;
    //浊度
    @JSONField(name="turbidity")
    private String turbidity;
    //温度
    @JSONField(name="temperature")
    private String temperature;
    //盐度
    @JSONField(name="salinity")
    private String salinity;
    //氨氮
    @JSONField(name="ammonianitrogen")
    private String ammonianitrogen;
    //总磷
    @JSONField(name="totalphosphorus")
    private String totalphosphorus;
    //总氮
    @JSONField(name="totalnitrogen")
    private String totalnitrogen;
    //高锰酸钾指数
    @JSONField(name="kmno4")
    private String kmno4;

    @JSONField(name="uptime")
    private String uptime;
    //扩展
    private String ext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getDissolvedoxygen() {
        return dissolvedoxygen;
    }

    public void setDissolvedoxygen(String dissolvedoxygen) {
        this.dissolvedoxygen = dissolvedoxygen;
    }

    public String getConductivity() {
        return conductivity;
    }

    public void setConductivity(String conductivity) {
        this.conductivity = conductivity;
    }

    public String getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(String turbidity) {
        this.turbidity = turbidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSalinity() {
        return salinity;
    }

    public void setSalinity(String salinity) {
        this.salinity = salinity;
    }

    public String getAmmonianitrogen() {
        return ammonianitrogen;
    }

    public void setAmmonianitrogen(String ammonianitrogen) {
        this.ammonianitrogen = ammonianitrogen;
    }

    public String getTotalphosphorus() {
        return totalphosphorus;
    }

    public void setTotalphosphorus(String totalphosphorus) {
        this.totalphosphorus = totalphosphorus;
    }

    public String getTotalnitrogen() {
        return totalnitrogen;
    }

    public void setTotalnitrogen(String totalnitrogen) {
        this.totalnitrogen = totalnitrogen;
    }

    public String getKmno4() {
        return kmno4;
    }

    public void setKmno4(String kmno4) {
        this.kmno4 = kmno4;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
}
