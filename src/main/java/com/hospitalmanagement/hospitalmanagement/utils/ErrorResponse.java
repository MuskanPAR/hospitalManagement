package com.hospitalmanagement.hospitalmanagement.utils;

import com.hospitalmanagement.hospitalmanagement.responsemodel.ResponseModal;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {
    public void setResponse(ResponseModal responseModal) {
        responseModal.setResponseCode(Constants.FAIL_RESPONSE_CODE.value);
        responseModal.setResponseMessage(Constants.FAIL_RESPONSE_MESSAGE.value);
        responseModal.setResponseData("{}");
    }
}
