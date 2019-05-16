package com.wy.manager.mp.analysisplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by 2P on 19-3-19.
 */
@Component
@ConfigurationProperties(prefix="biz.analysis")
public class AnalysisCommonConfig {

    private String filepath;

    private String excelspath;

    private String jingdu;

    private String weidu;

    public String getExcelspath() {
        return excelspath;
    }

    public void setExcelspath(String excelspath) {
        this.excelspath = excelspath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
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


