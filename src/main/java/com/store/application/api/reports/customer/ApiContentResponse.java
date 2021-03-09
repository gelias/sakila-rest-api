package com.store.application.api.reports.customer;

import com.store.application.api.ApiResponse;
import com.store.application.api.ApiEntity;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

// TODO
public class ApiContentResponse<T extends ApiEntity> extends ApiResponse {

    private Long records;
    private List<T> content;

    public ApiContentResponse(Long total) {
        super(OK.value());
        this.records = total;
        this.content = Arrays.asList();
    }

    public ApiContentResponse(List<T> content) {
        super(OK.value());
        this.records = Long.valueOf(content.size());
        this.content = content;
    }

    public Long getRecords() {
        return records;
    }

    public List<T> getContent() {
        return content;
    }
}
