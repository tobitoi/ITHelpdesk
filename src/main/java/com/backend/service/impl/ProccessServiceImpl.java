package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ProccesDao;
import com.backend.service.ProccesService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
@Service
public class ProccessServiceImpl implements ProccesService {

    @Autowired
    private ProccesDao proccesDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addProcces(JSONObject jsonObject) {
        proccesDao.addProccess(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listProcces(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = proccesDao.countProccess(jsonObject);
        List<JSONObject> list = proccesDao.listProccess(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateProcces(JSONObject jsonObject) {
        proccesDao.updateProccess(jsonObject);
        return CommonUtil.successJson();
    }
}
