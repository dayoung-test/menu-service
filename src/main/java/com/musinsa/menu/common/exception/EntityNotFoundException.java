package com.musinsa.menu.common.exception;

import com.musinsa.menu.common.response.ResponseCode;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException() {
        super(ResponseCode.INVALID_REQUEST_PARAMETER);
    }

    public EntityNotFoundException(String message) {
        super(message, ResponseCode.INVALID_REQUEST_PARAMETER);
    }
}
