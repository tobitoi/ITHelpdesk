package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ToolsDao;
import com.backend.service.ToolsService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobitoi on 1/2/18.
 */
@RestController
@RequestMapping("/tools")
public class ToolsController {

    @Autowired
    private ToolsService toolsService;

    @RequiresPermissions("tools:list")
    @GetMapping("/listTools")
    public JSONObject listTools(HttpServletRequest request) {
        return toolsService.listTools(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("tools:add")
    @PostMapping("/addTools")
    public JSONObject addTools(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "merk, hostName,ipAddress,status, serialNumber");
        return toolsService.addTools(requestJson);
    }

    @RequiresPermissions("tools:update")
    @PostMapping("/updateTools")
    public JSONObject updateTools(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "merk, hostName,ipAddress,status, serialNumber");
        return toolsService.updateTools(requestJson);
    }
    @PostMapping("/deleteTools")
    public JSONObject deleteTools(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        return toolsService.deleteTools(requestJson);
    }

    @GetMapping("/listToolsChart")
    public JSONObject listToolsChart(HttpServletRequest request) {
        List<ToolsDao> list = new ArrayList<>();
        return toolsService.listChart(CommonUtil.request2Json(request));
    }

    @GetMapping("/listToolsCategory")
    public JSONObject listToolsCategory() {
        return toolsService.listToolsCategory();
    }

    @GetMapping("/listStatus")
    public JSONObject listStatus() {
        return toolsService.listStatus();
    }
}
