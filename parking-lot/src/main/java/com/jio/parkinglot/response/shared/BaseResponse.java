package com.jio.parkinglot.response.shared;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private String responseMassage;
    private String responseCode;
    private boolean success;

    public BaseResponse( boolean success, String responseMassage, String responseCode) {
        this.responseMassage = responseMassage;
        this.responseCode = responseCode;
        this.success = success;
    }

    public String getResponseMassage() {
        return responseMassage;
    }

    public BaseResponse setResponseMassage(String responseMassage) {
        this.responseMassage = responseMassage;
        return this;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public BaseResponse setResponseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public BaseResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }
}
