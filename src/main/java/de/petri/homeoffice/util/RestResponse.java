package de.petri.homeoffice.util;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestResponse {
	private Boolean success;
	private List<?> data;
	private String message;

	public RestResponse() {
		this(true, Collections.EMPTY_LIST);
	}

	public RestResponse(boolean success) {
		this(success, Collections.EMPTY_LIST);
	}

	public RestResponse(boolean success, List<?> data) {
		this.success = success;
		this.data = data;
		this.message = null;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;

	}
	public String getMessage() {
		return message;
	}
}
