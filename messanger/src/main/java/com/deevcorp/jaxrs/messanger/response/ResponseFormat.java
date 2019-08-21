package com.deevcorp.jaxrs.messanger.response;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.deevcorp.jaxrs.messanger.model.Profile;

@XmlRootElement
public class ResponseFormat {


	private boolean success = false;
	private Profile data = new Profile();
	
	public ResponseFormat() {
		
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Profile getData() {
		return data;
	}

	public void setData(Profile data) {
		this.data = data;
	}
	
	
}
