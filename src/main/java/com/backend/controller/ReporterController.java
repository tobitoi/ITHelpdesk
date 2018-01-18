package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.service.EmployeeService;
import com.backend.service.ReporterService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tobitoi on 1/10/18.
 */
@RestController
@RequestMapping("/reporter")
public class ReporterController {

    @Autowired
    private ReporterService reporterService;

    @RequiresPermissions("reporter:list")
    @GetMapping("/listReporter")
    public JSONObject listReporter(HttpServletRequest request) {
        return reporterService.listReporter(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("reporter:add")
    @PostMapping("/addReporter")
    public JSONObject addReporter(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,date");
        return reporterService.addReporter(requestJson);
    }

    @RequiresPermissions("reporter:update")
    @PostMapping("/updateReporter")
    public JSONObject updateReporter(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,date");
        return reporterService.updateReporter(requestJson);
    }

    @PostMapping("/uploadImage")
    public JSONObject uploadImage(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "imageUrl");
        return reporterService.uploadImage(requestJson);
    }
}
