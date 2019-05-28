package com.senebii.api.common;

public class ResponseModel<T> {
	private static final String ERROR_CODE_SUCCESS = "SUCCESS";
	private static final String ERROR_CODE_FAILED = "FAILED";
	
	private T data;
	private String errorCode;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public static <T> ResponseModel<T> success(T data){
		ResponseModel<T> response = new ResponseModel<>();
		response.setErrorCode(ERROR_CODE_SUCCESS);
		response.setData(data);
		return response;
	}
	
	public static <T> ResponseModel<T> failed(T data){
		ResponseModel<T> response = new ResponseModel<>();
		response.setErrorCode(ERROR_CODE_FAILED);
		response.setData(data);
		return response;
	}
}
