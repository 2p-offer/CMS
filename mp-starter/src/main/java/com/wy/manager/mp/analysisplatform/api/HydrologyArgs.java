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
    @JSONField(name="flow")
    private String flow ;
    //流向
    @JSONField(name="flowto")
    private String flowto ;
    //水位
    @JSONField(name="uplevel")
    private String uplevel ;
    @JSONField(name="downlevel")
    private String downlevel ;


    @JSONField(name="warning")
    private String warning;
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

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getUplevel() {
        return uplevel;
    }

    public void setUplevel(String uplevel) {
        this.uplevel = uplevel;
    }

    public String getDownlevel() {
        return downlevel;
    }

    public void setDownlevel(String downlevel) {
        this.downlevel = downlevel;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
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
