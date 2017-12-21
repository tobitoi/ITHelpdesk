package com.backend.config.exception;

import com.alibaba.fastjson.JSONObject;
import com.backend.util.CommonUtil;
import com.backend.util.constant.ErrorEnum;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tobitoi on 12/21/17.
 */
@Controller
public class MainsiteErrorController implements ErrorController{

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public JSONObject handleError() {
        return CommonUtil.errorJson(ErrorEnum.E_501);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
