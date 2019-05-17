package com.wy.manager.mp.analysisplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.analysisplatform.config.AnalysisCommonConfig;
import com.wy.manager.mp.analysisplatform.service.BiologicalService;
import com.wy.manager.mp.analysisplatform.service.FileReceiveService;
import com.wy.manager.mp.common.annotation.Log;
import com.wy.manager.mp.common.utils.PageUtils;
import com.wy.manager.mp.common.utils.Query;
import com.wy.manager.mp.common.utils.R;
import com.wy.manager.mp.common.utils.ShiroUtils;
import com.wy.manager.mp.system.domain.UserDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2P on 19-3-25.
 */
@RequestMapping("/analysis/biological")
@Controller
public class BiologicalController {

    String prefix = "analysis";
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AnalysisCommonConfig analysisConfig;

    @Autowired
    FileReceiveService fileReceiveService;

    @Autowired
    BiologicalService biologicalService;

    public List<BiologicalArgs> chartList;

    @GetMapping()
    String test() {
        return prefix + "/biological";
    }

    @ResponseBody
    @PostMapping("/uploadExcel/{type}")
    R uploadExcel(@RequestParam(value = "uploadFile", required = false) MultipartFile file, @PathVariable String type) {
        try {
            String path = analysisConfig.getFilepath();
            String fileName = file.getName();
            fileReceiveService.dealFile(file, type);
            File f = new File(path, fileName);
            if (!f.exists()) {
                f.createNewFile();
            }
            file.transferTo(f);
            LOGGER.info("upload file success");
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(500, e.getMessage());
        }
        return R.ok();
    }


    @GetMapping("/downLoadTmp")
    public HttpServletResponse download(HttpServletRequest request, HttpServletResponse response) {
        try {
            //TODO 文件地址
            String path = analysisConfig.getExcelspath() + "static/excels/SWZB.xlsx";
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @ResponseBody
    @GetMapping("/list")
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        String jingdu = analysisConfig.getJingdu();
        String weidu = analysisConfig.getWeidu();
        if ("0".equals(jingdu) || "0".equals(weidu))
        {
            return null;
        }
        params.put("jingdu", jingdu);
        params.put("weidu", weidu);
        Query query = new Query(params);
        List<BiologicalArgs> list = biologicalService.list(query);
        chartList = list;
        int total = biologicalService.count(query);
        PageUtils pageUtil = new PageUtils(list, total);
        return pageUtil;
    }

    @GetMapping("/showCharts")
    String showCharts() {
        return prefix + "/biologicalCharts";
    }

    @ResponseBody
    @GetMapping("/showChartsData")
    List<BiologicalArgs> showChartsData() {
        if (chartList == null) {
            String jingdu = analysisConfig.getJingdu();
            String weidu = analysisConfig.getWeidu();
            if ("000" == jingdu || "000" == weidu) {
                return null;
            }
            Map<String, Object> params=new HashMap<>();
            params.put("jingdu", jingdu);
            params.put("weidu", weidu);
            Query query = new Query(params);
            LOGGER.info("charList is null");
            chartList = biologicalService.listAll(query);
        }
        return chartList;
    }


    @PostMapping("/remove")
    @ResponseBody
    R remove(String id) {

        if (biologicalService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }
}
