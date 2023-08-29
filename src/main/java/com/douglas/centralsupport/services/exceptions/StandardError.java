package com.douglas.centralsupport.services.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{  
	private static final long serialVersionUID = 1L;
	
	private Long timetamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
		super();
	}

	public StandardError(Long timetamp, Integer status, String error, String message, String path) {
		super();
		this.timetamp = timetamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimetamp() {
		return timetamp;
	}

	public void setTimetamp(Long timetamp) {
		this.timetamp = timetamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
}
