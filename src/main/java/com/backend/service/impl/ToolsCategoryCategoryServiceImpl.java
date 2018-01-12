package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ToolsCategoryDao;
import com.backend.service.ToolsCategoryService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tobitoi on 12/30/17.
 */
@Service
public class ToolsCategoryCategoryServiceImpl implements ToolsCategoryService {

    @Autowired
    private ToolsCategoryDao toolsCategoryDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addToolsCategory(JSONObject jsonObject) {
        toolsCategoryDao.addToolsCategory(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listToolsCategory(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = toolsCategoryDao.countToolsCategory(jsonObject);
        List<JSONObject> toolsDaos = toolsCategoryDao.listToolsCategory(jsonObject);
        return CommonUtil.successPage(jsonObject,toolsDaos,count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateToolsCategory(JSONObject jsonObject) {
        toolsCategoryDao.updateToolsCategory(jsonObject);
        return CommonUtil.successJson();
    }
}
