package com.urcs.manager.mp.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="bootdo")
public class UrcsManagerConfig {
	//上传路径
	private String uploadPath;

	//上传路径
	private String logOperatorUrl;

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getLogOperatorUrl() {
		return logOperatorUrl;
	}

	public void setLogOperatorUrl(String logOperatorUrl) {
		this.logOperatorUrl = logOperatorUrl;
	}
}
