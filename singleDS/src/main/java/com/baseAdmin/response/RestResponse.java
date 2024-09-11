package com.baseAdmin.response;


import java.io.Serializable;

public class RestResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code = "200";
	private String message = "";
	private T result = null;

	public RestResponse() {
	}

	public static <T> RestResponse result(T result) {
		return new RestResponse(result);
	}

	public RestResponse(T result) {
		this.result = result;
	}

	public RestResponse(String code, T result) {
		this.code = code;
		//this.message = ResponseMessage.getInstance().getValue(code);
		this.result = result;
	}

	public RestResponse(String code, String message, T result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return this.result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}