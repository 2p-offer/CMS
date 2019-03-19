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

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}

