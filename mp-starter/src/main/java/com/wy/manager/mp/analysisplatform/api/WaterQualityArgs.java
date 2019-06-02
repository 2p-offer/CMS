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
    //扩展
//    private String ext;

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
