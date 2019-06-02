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
    //PH
    @JSONField(name="ph")
    private String ph;
    //含水量
    @JSONField(name="watercontent")
    private String watercontent;
    @JSONField(name="deep")
    private String deep;
    @JSONField(name="k")
    private String k;
    @JSONField(name="ca")
    private String ca;
    @JSONField(name="na")
    private String na;
    @JSONField(name="mg")
    private String mg;
    @JSONField(name="cl")
    private String cl;
    @JSONField(name="so4")
    private String so4;
    @JSONField(name="no3")
    private String no3;
    @JSONField(name="co3")
    private String co3;
    @JSONField(name="conductivity")
    private String conductivity;
    @JSONField(name="som")
    private String som;
    @JSONField(name="doc")
    private String doc;
    @JSONField(name="pom")
    private String pom;
    @JSONField(name="shen")
    private String shen;
    @JSONField(name="ge2")
    private String ge2;
    @JSONField(name="tong")
    private String tong;
    @JSONField(name="qian")
    private String qian;
    @JSONField(name="xin")
    private String xin;
    @JSONField(name="nie")
    private String nie;
    @JSONField(name="ge4")
    private String ge4;
    @JSONField(name="gai")
    private String gai;
    @JSONField(name="mei")
    private String mei;
    @JSONField(name="tie")
    private String tie;
    @JSONField(name="lv")
    private String lv;
    @JSONField(name="quandan")
    private String quandan;
    @JSONField(name="quanlin")
    private String quanlin;
    @JSONField(name="quanliu")
    private String quanliu;

    @JSONField(name="warning")
    private String warning;
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

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
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

    public String getDeep() {
        return deep;
    }

    public void setDeep(String deep) {
        this.deep = deep;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getSo4() {
        return so4;
    }

    public void setSo4(String so4) {
        this.so4 = so4;
    }

    public String getNo3() {
        return no3;
    }

    public void setNo3(String no3) {
        this.no3 = no3;
    }

    public String getCo3() {
        return co3;
    }

    public void setCo3(String co3) {
        this.co3 = co3;
    }

    public String getConductivity() {
        return conductivity;
    }

    public void setConductivity(String conductivity) {
        this.conductivity = conductivity;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getPom() {
        return pom;
    }

    public void setPom(String pom) {
        this.pom = pom;
    }

    public String getShen() {
        return shen;
    }

    public void setShen(String shen) {
        this.shen = shen;
    }

    public String getGe2() {
        return ge2;
    }

    public void setGe2(String ge2) {
        this.ge2 = ge2;
    }

    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }

    public String getQian() {
        return qian;
    }

    public void setQian(String qian) {
        this.qian = qian;
    }

    public String getXin() {
        return xin;
    }

    public void setXin(String xin) {
        this.xin = xin;
    }

    public String getNie() {
        return nie;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public String getGe4() {
        return ge4;
    }

    public void setGe4(String ge4) {
        this.ge4 = ge4;
    }

    public String getGai() {
        return gai;
    }

    public void setGai(String gai) {
        this.gai = gai;
    }

    public String getMei() {
        return mei;
    }

    public void setMei(String mei) {
        this.mei = mei;
    }

    public String getTie() {
        return tie;
    }

    public void setTie(String tie) {
        this.tie = tie;
    }

    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }

    public String getQuandan() {
        return quandan;
    }

    public void setQuandan(String quandan) {
        this.quandan = quandan;
    }

    public String getQuanlin() {
        return quanlin;
    }

    public void setQuanlin(String quanlin) {
        this.quanlin = quanlin;
    }

    public String getQuanliu() {
        return quanliu;
    }

    public void setQuanliu(String quanliu) {
        this.quanliu = quanliu;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }
}
