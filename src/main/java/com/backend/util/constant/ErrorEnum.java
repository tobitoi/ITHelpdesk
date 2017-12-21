package com.backend.util.constant;

/**
 * Created by Tobitoi on 12/21/17.
 */
public enum  ErrorEnum {
    E_400("400", "Request processing exception, please try again later"),
    E_500("500", "Wrong way to request, please check,请检查 GET/POST"),
    E_501("501", "The request path does not exist"),
    E_502("502", "Insufficient permissions"),
    E_10008("10008", "Role deletion failed, there are still users belong to this role"),

    E_20011("20011", "Login has expired, please login again"),

    E_90003("90003", "Missing required parameters");

    private String errorCode;

    private String errorMsg;

    ErrorEnum() {
    }

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
