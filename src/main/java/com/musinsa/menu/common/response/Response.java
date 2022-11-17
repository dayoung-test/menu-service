package com.musinsa.menu.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response<T> {

	private String code;
	private String message;
	private T data;

	public static Response of() {
		return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
	}

	public static Response of(final ResponseCode responseCode) {
		return new Response(responseCode.getCode(), responseCode.getMessage(), null);
	}

	public static <T> Response<T> of(final T data) {
		return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
	}

	public static <T> Response<T> of(final ResponseCode responseCode, final T data) {
		return new Response(responseCode.getCode(), responseCode.getMessage(), data);
	}

}
