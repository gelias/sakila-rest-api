package com.store.application.status;

import com.store.application.status.model.AppStatusResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = { "", "/status"})
@Tag(name = "status")
public class AppStatusController {

    @Value("${version}")
    private String version;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping(produces = "application/json")
    public AppStatusResponse status() {
        return new AppStatusResponse(applicationName, version, OK.value());
    }

}
