package com.ssafy.was;

import java.util.Map;

public class SsafyRequest {
	
	private Map<String, String> parameters;

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	public String getParameter(String parameterName) {
		return parameters.get(parameterName);
	}
}
