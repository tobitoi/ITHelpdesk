package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ToolsDao;
import com.backend.service.QualityService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobitoi on 1/7/18.
 */
@RestController
@RequestMapping("/quality")
public class QualityController {

    @Autowired
    private QualityService qualityService;

    @RequiresPermissions("quality:list")
    @GetMapping("/listQuality")
    public JSONObject listQuality(HttpServletRequest request) {
        return qualityService.listQuality(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("quality:add")
    @PostMapping("/addQuality")
    public JSONObject addQuality(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "reporter, dateStart,problem");
        return qualityService.addQuality(requestJson);
    }

    @RequiresPermissions("quality:update")
    @PostMapping("/updateQuality")
    public JSONObject updateQuality(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "reporter, dateFinish,problem,repairDesc, verifyStatus");
        return qualityService.updateQuality(requestJson);
    }

    @PostMapping("/deleteQuality")
    public JSONObject deleteQuality(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        return qualityService.deletQuality(requestJson);
    }

    @GetMapping("/listEmployee")
    public JSONObject listEmployee() {
        return qualityService.listEmployee();
    }

    @GetMapping("/listTools")
    public JSONObject listTools() {
        return qualityService.listTools();
    }

    @GetMapping("/listQualityChart")
    public JSONObject listQualityChart(HttpServletRequest request) {
        List<ToolsDao> list = new ArrayList<>();
        return qualityService.listChart(CommonUtil.request2Json(request));
    }

}
