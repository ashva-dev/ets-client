package com.pzone.kiran.client.model;

public class Trigger {
	private String method;
	private TriggeredData data;

	public Trigger() {

	  }

	public Trigger(String method, TriggeredData data) {
	    this.method = method;
	    this.data = data;
	  }

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public TriggeredData getData() {
		return data;
	}

	public void setData(TriggeredData data) {
		this.data = data;
	}

}
