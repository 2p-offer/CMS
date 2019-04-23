package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 生境指标下水文指标（以柱形图形式展示，每小时的三个特征数据值）
 * Created by 2P on 19-3-14.
 */
public class HydrologyArgs {

    @JSONField(name="id")
    private String id;
    //流速
    @JSONField(name="currentspeed")
    private String currentspeed ;
    //流向
    @JSONField(name="flowto")
    private String flowto ;
    //水位
    @JSONField(name="waterlevel")
    private String waterlevel ;

    @JSONField(name="uptime")
    private String uptime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
}
