package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 生物指标 目前以数量为基准分析，可以使用堆积折线图展现（一个表内展现同一时间内不同生物的数量。）
 * Created by 2P on 19-3-14.
 */
public class BiologicalArgs {
    //TODO 每个字段应该包括数量/种类/生物量

    //湿地植物
    @JSONField(name="wetlandplants")
    private String wetlandplants;
    //浮游植物
    @JSONField(name="phytoplankton")
    private String phytoplankton;
    //浮游动物
    @JSONField(name="zooplankton")
    private String zooplankton;
    //底栖生物
    @JSONField(name="Benthos")
    private String benthos;
    //鱼类
    @JSONField(name="fish")
    private String fish;
    //扩展字段
    private String ext;

    public String getWetlandplants() {
        return wetlandplants;
    }

    public void setWetlandplants(String wetlandplants) {
        this.wetlandplants = wetlandplants;
    }

    public String getPhytoplankton() {
        return phytoplankton;
    }

    public void setPhytoplankton(String phytoplankton) {
        this.phytoplankton = phytoplankton;
    }

    public String getZooplankton() {
        return zooplankton;
    }

    public void setZooplankton(String zooplankton) {
        this.zooplankton = zooplankton;
    }

    public String getBenthos() {
        return benthos;
    }

    public void setBenthos(String benthos) {
        this.benthos = benthos;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
