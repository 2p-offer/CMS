package com.wy.manager.mp.analysisplatform.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wy.manager.mp.analysisplatform.api.PointArgs;
import com.wy.manager.mp.analysisplatform.api.WaterQualityArgs;
import com.wy.manager.mp.analysisplatform.config.AnalysisCommonConfig;
import com.wy.manager.mp.analysisplatform.dao.PointDao;
import com.wy.manager.mp.common.utils.PageUtils;
import com.wy.manager.mp.common.utils.Query;
import com.wy.manager.mp.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyan
 * @Date: 2019/5/16
 */
@RequestMapping("/analysis/pointMap")
@Controller
public class PointController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    String prefix = "analysis";

    @Autowired
    AnalysisCommonConfig analysisConfig;

    @Autowired
    PointDao pointDao;

    @GetMapping("")
    String getMap() {
        return prefix + "/pointMap";
    }

    @GetMapping("/getSelect")
    String getSelectMap() {
        return prefix + "/selectMap";
    }

    @ResponseBody
    @GetMapping("/list")
    String list() {
        // 查询列表数据
        List<PointArgs> list = pointDao.getAll();
        String res = JSONArray.toJSONString(list);
        LOGGER.info("getALL list:"+res);
        return res;
    }

    @ResponseBody
    @PostMapping("/addPoint")
    String addPoint(@RequestBody PointArgs pointArgs){
//    String addPoint(String jingdu,String weidu){
//        if(StringUtils.isBlank(jingdu)|| org.apache.commons.lang3.StringUtils.isBlank(weidu)){
//            return "no";
//        }
//        PointArgs pointArgs=new PointArgs();
//        pointArgs.setJingdu(jingdu);
//        pointArgs.setWeidu(weidu);
        LOGGER.info("add Point :"+ JSONObject.toJSONString(pointArgs));
        pointDao.insertPoint(pointArgs);
        return "ok";
    }

    @ResponseBody
    @PostMapping("/beSurePoint")
    String beSurePoint(@RequestBody PointArgs pointArgs){

        analysisConfig.setJingdu(pointArgs.getJingdu());
        analysisConfig.setWeidu(pointArgs.getWeidu());
        LOGGER.info("besurePoint:"+JSONObject.toJSONString(pointArgs));
        return "ok";
    }

    @ResponseBody
    @PostMapping("/deletePoint")
    String deletePoint(@RequestBody PointArgs pointArgs){

        LOGGER.info("besurePoint:"+JSONObject.toJSONString(pointArgs));
        if(pointDao.remove(pointArgs)>0){
            LOGGER.info("delect point Success："+JSONObject.toJSONString(pointArgs));
            return "ok";
        }
        return "no";
    }
}
