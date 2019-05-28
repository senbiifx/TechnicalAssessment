package com.senebii.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class ResponseModel {
	public static final String SUCCESS_RESPONSE = "SUCCESS";
	private Object data;
	private String response;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String errorCode) {
		this.response = errorCode;
	}
	
	public static ResponseModel success() {
		ResponseModel response = new ResponseModel();
		response.setResponse(ResponseModel.SUCCESS_RESPONSE);
		return response;
	}
	
	public static ResponseModel success(Object data) {
		ResponseModel model = success();
		model.setData(data);
		return model;
	}
}
