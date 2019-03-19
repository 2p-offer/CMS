package com.wy.manager.mp.analysisplatform.controller;

import com.wy.manager.mp.analysisplatform.config.AnalysisCommonConfig;
import com.wy.manager.mp.common.utils.R;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 2P on 19-3-18.
 */
@RequestMapping("/analysis/test")
@Controller
public class TestController {
    String prefix = "analysis";

    @Autowired
    AnalysisCommonConfig analysisConfig;

    @GetMapping()
    String test() {
        return prefix + "/test";
    }

    @PostMapping("/uploadExcel")
    R uploadExcel(@RequestParam(value = "uploadFile", required = false) MultipartFile file, HttpServletRequest request) {
        try {
//            ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
//            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//
//            MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());
//            MultipartFile f = multipartRequest.getFile("uploadFile");


//            String path=request.getSession().getServletContext().getRealPath("excels");
//            path= ResourceUtils.getURL("classpath:").getPath();
            String path=analysisConfig.getFilepath();
            String fileName = file.getName();
            File f=new File(path,fileName);
            if(!f.exists()){
                f.createNewFile();
            }
            file.transferTo(f);
            System.out.println("comming.");
        } catch (Exception e) {
            e.printStackTrace();
            return  R.error(500,e.getMessage());
        }
        return R.ok();
    }
}
