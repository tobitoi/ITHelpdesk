package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.util.CommonUtil;
import com.backend.util.constant.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Tobitoi on 1/18/18.
 */
@RestController("/uploadImage")
@ResponseBody
public class UploadImageController {

    private static final Logger log =  LoggerFactory.getLogger(UploadImageController.class);

    @PostMapping("/upload")
    @ResponseBody
    public JSONObject upload (@RequestParam("file")MultipartFile multipartFile, @RequestParam(value = "folder", required = false) String folder){
        InputStream inputStream;
        String fileName ="";

        try {
            inputStream = multipartFile.getInputStream();
        }catch (IOException ex){
            return CommonUtil.errorJson(ErrorEnum.E_10008);
        }
        try{
            fileName = multipartFile.getOriginalFilename();
            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("temp/"+fileName)));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();

        }catch (IOException ex){
            log.info("Cannot Accept The File"+fileName);
        }


        JSONObject result = new JSONObject();
        result.put("fileName", fileName);
        log.info("Cannot Accept The File"+fileName);
        return CommonUtil.successJson(result);
    }
}
