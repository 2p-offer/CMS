package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 生境指标下水文指标
 * Created by 2P on 19-3-14.
 */
public class HydrologyArgs {

    //流速
    @JSONField(name="currentspeed")
    private String currentspeed ;
    //流向
    @JSONField(name="flowto")
    private String flowto ;
    //水位
    @JSONField(name="waterlevel")
    private String waterlevel ;
    //扩展
    private String ext;


    public String getCurrentspeed() {
        return currentspeed;
    }

    public void setCurrentspeed(String currentspeed) {
        this.currentspeed = currentspeed;
    }

    public String getFlowto() {
        return flowto;
    }

    public void setFlowto(String flowto) {
        this.flowto = flowto;
    }

    public String getWaterlevel() {
        return waterlevel;
    }

    public void setWaterlevel(String waterlevel) {
        this.waterlevel = waterlevel;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }



}
