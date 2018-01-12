package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.service.SparePartService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tobitoi on 1/10/18.
 */
@RestController
@RequestMapping("/sparepart")
public class SparePartController {

    @Autowired
    private SparePartService sparePartService;

    @RequiresPermissions("sparepart:list")
    @GetMapping("/listSparePart")
    public JSONObject listSparePart(HttpServletRequest request) {
        return sparePartService.listSparePart(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("sparepart:add")
    @PostMapping("/addSparePart")
    public JSONObject addSparePart(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "kode,name");
        return sparePartService.addSparePart(requestJson);
    }

    @RequiresPermissions("sparepart:update")
    @PostMapping("/updateSparePart")
    public JSONObject updateSparePart(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "kode,name");
        return sparePartService.updateSparePart(requestJson);
    }
}
