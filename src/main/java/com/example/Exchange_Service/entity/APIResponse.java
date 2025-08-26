package com.example.Exchange_Service.entity;

public class APIResponse {
    private Integer status;
    private String message;

    public APIResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

}
