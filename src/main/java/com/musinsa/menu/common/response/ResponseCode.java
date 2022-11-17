package com.musinsa.menu.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

	SUCCESS("0000", "SUCCESS"),
	INVALID_REQUEST_PARAMETER("4000", "INVALID_REQUEST_PARAMETER"),
	SYSTEM_ERROR("5000", "SERVER_ERROR");

	private final String code;
	private final String message;

}
