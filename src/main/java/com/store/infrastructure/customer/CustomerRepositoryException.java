package com.store.infrastructure.customer;

import com.store.infrastructure.exception.StoreException;

public class CustomerRepositoryException extends StoreException {

    public CustomerRepositoryException(String message) {
        super(message);
    }
}
