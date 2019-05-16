package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: wangyan
 * @Date: 2019/5/16
 */
public class PointArgs {
    @JSONField(name="id")
    private String id;
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
