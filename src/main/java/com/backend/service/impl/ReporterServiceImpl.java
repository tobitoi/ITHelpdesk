package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ReporterDao;
import com.backend.service.ReporterService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
@Service
public class ReporterServiceImpl implements ReporterService {

    @Autowired
    private ReporterDao reporterDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addReporter(JSONObject jsonObject) {
        reporterDao.addReporter(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listReporter(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = reporterDao.countReporter(jsonObject);
        List<JSONObject> list = reporterDao.listReporter(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateReporter(JSONObject jsonObject) {
        reporterDao.updateReporter(jsonObject);
        return CommonUtil.successJson();
    }
}
