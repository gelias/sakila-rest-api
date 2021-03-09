package com.store.application.api;

public class ApiResponse {

    private int status;

    public ApiResponse(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
