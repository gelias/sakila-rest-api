package com.store.application.status;

import com.store.application.status.model.AppStatusResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.util.ReflectionTestUtils.setField;

public class AppStatusControllerTest {

    public static final String VERSION = "1.0.1";
    public static final String APPLICATION_NAME = "dvd-rental-store";
    @InjectMocks
    private AppStatusController appStatusController;

    @Before
    public void setup(){
        initMocks(this);
        setField(appStatusController,"version", VERSION);
        setField(appStatusController,"applicationName", APPLICATION_NAME);
    }

    @Test
    public void shouldGetAppStatusInfo(){
        AppStatusResponse status = appStatusController.status();
        Assert.assertEquals(String.format("%s_%s_200",APPLICATION_NAME,VERSION), status.toString());
    }
}