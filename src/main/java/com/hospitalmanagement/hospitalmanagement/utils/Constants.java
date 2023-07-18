package com.hospitalmanagement.hospitalmanagement.utils;

public enum Constants {
    SUCCESS_RESPONSE_CODE("200"),
    SUCCESS_RESPONSE_MESSAGE("SUCCESS"),
    FAIL_RESPONSE_CODE("401"),
    FAIL_RESPONSE_MESSAGE("SOMETHING WENT WRONG");

    public final String value;
    private Constants(String value){
        this.value = value;
    }
}
