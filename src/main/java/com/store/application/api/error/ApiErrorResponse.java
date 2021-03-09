package com.store.application.api.error;

import com.store.application.api.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiErrorResponse extends ApiResponse {

    @Getter
    private String error;

    public ApiErrorResponse(HttpStatus status, String error) {
        super(status.value());
        this.error = error;
    }
}
