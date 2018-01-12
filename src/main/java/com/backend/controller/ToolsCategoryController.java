package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.service.ToolsCategoryService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tobitoi on 12/30/17.
 */
@RestController
@RequestMapping("/toolsCategory")
public class ToolsCategoryController {

    @Autowired
    private ToolsCategoryService toolsCategoryService;

    @RequiresPermissions("toolsCategory:list")
    @GetMapping("/listToolsCategory")
    public JSONObject listToolsCategory(HttpServletRequest request) {
        return toolsCategoryService.listToolsCategory(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("toolsCategory:add")
    @PostMapping("/addToolsCategory")
    public JSONObject addToolsCategory(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "category");
        return toolsCategoryService.addToolsCategory(requestJson);
    }

    @RequiresPermissions("toolsCategory:update")
    @PostMapping("/updateToolsCategory")
    public JSONObject updateToolsCategory(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id,category");
        return toolsCategoryService.updateToolsCategory(requestJson);
    }
}
