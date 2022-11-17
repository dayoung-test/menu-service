package com.musinsa.menu.common.exception;

import com.musinsa.menu.common.response.ResponseCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private ResponseCode errorCode;

    public BaseException() {
    }

    public BaseException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BaseException(String message, ResponseCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(String message, ResponseCode errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
