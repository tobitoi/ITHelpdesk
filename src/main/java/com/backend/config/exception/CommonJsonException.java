package com.backend.config.exception;

import com.alibaba.fastjson.JSONObject;
import com.backend.util.CommonUtil;
import com.backend.util.constant.ErrorEnum;

/**
 * Created by Tobitoi on 12/21/17.
 */
public class CommonJsonException extends RuntimeException {
    private JSONObject resultJson;

    public CommonJsonException(ErrorEnum errorEnum) {
        this.resultJson = CommonUtil.errorJson(errorEnum);
    }

    public CommonJsonException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }

    public JSONObject getResultJson() {
        return resultJson;
    }
}
