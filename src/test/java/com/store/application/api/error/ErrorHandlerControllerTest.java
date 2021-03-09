package com.store.application.api.error;

import com.store.infrastructure.exception.StoreException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.rmi.UnexpectedException;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class ErrorHandlerControllerTest {

    @InjectMocks
    private ErrorHandlerController errorHandlerController;

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void shouldCatchAllUnexpectedException(){
        UnexpectedException unexpectedException = new UnexpectedException("Ops ...");
        ApiErrorResponse apiResponse = (ApiErrorResponse) errorHandlerController.handleUnexpectedException(unexpectedException);
        Assert.assertEquals(400,apiResponse.getStatus());
    }

    @Test
    public void shouldCatchAllStoreException(){
        StoreException storeException = new StoreException("Ops ...");
        ApiErrorResponse apiResponse = (ApiErrorResponse) errorHandlerController.handleStoreException(storeException);
        Assert.assertEquals(404,apiResponse.getStatus());
    }


}