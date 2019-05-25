package com.wy.manager.mp.analysisplatform.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.swing.internal.plaf.metal.resources.metal;

/**
 * 土壤数据（与生物指标类似，堆积折线表示）
 * Created by 2P on 19-3-14.
 */
public class SoilArgs {

    @JSONField(name="id")
    private String id;

    @JSONField(name="c")
    private String c;
    @JSONField(name="n")
    private String n;
    @JSONField(name="s")
    private String s;
    @JSONField(name="p")
    private String p;
    //重金属
    @JSONField(name="heavymetal")
    private String heavymetal;
    //PH
    @JSONField(name="ph")
    private String ph;
    //盐离子
    @JSONField(name="saltion")
    private String  saltion;
    //含水量
    @JSONField(name="watercontent")
    private String watercontent;

    @JSONField(name="uptime")
    private String uptime;

    @JSONField(name="jingdu")
    private String jingdu;

    @JSONField(name="weidu")
    private String weidu;
//    //扩展字段
//    private String ext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getHeavymetal() {
        return heavymetal;
    }

    public void setHeavymetal(String heavymetal) {
        this.heavymetal = heavymetal;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getSaltion() {
        return saltion;
    }

    public void setSaltion(String saltion) {
        this.saltion = saltion;
    }

    public String getWatercontent() {
        return watercontent;
    }

    public void setWatercontent(String watercontent) {
        this.watercontent = watercontent;
    }

//    public String getExt() {
//        return ext;
//    }
//
//    public void setExt(String ext) {
//        this.ext = ext;
//    }

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
