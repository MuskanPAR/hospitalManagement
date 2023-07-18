package com.hospitalmanagement.hospitalmanagement.responsemodel;

public class ResponseModal {

    private String responseCode;
    private String responseMessage;
    private Object responseData;

    public ResponseModal() {
    }

    public ResponseModal(String responseCode, String responseMessage, Object responseData) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseData = responseData;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "ApiResponseData{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", responseData=" + responseData +
                '}';
    }
}
