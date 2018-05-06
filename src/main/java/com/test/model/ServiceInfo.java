package com.test.model;

public class ServiceInfo {
	private String testInfo;
	private String name;
	private int port;

	public ServiceInfo() {
	}

	public ServiceInfo(String testInfo, String name, int port) {
		super();
		this.testInfo = testInfo;
		this.name = name;
		this.port = port;
	}

	public String getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(String testInfo) {
		this.testInfo = testInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


}
