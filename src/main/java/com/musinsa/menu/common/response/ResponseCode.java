package com.musinsa.menu.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

	SUCCESS("0000", "SUCCESS"),
	INVALID_REQUEST_PARAMETER("4000", "요청한 값이 올바르지 않습니다."),
	SYSTEM_ERROR("5000", "일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");

	private final String code;
	private final String message;

}
