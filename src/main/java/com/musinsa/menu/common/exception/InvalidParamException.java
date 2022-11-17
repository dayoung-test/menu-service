package com.musinsa.menu.common.exception;

import com.musinsa.menu.common.response.ResponseCode;

public class InvalidParamException extends BaseException {

    public InvalidParamException() {
        super(ResponseCode.INVALID_REQUEST_PARAMETER);
    }

    public InvalidParamException(ResponseCode errorCode) {
        super(errorCode);
    }

    public InvalidParamException(String errorMsg) {
        super(errorMsg, ResponseCode.INVALID_REQUEST_PARAMETER);
    }

    public InvalidParamException(String message, ResponseCode errorCode) {
        super(message, errorCode);
    }
}
