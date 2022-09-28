package com.ssafy.apart.model.service;

import java.util.Map;

public interface ApartService {
	Map<String, String> getSidoNames() throws Exception;
	Map<String, String> getGugunNames(String sidoCode) throws Exception;
	Map<String, String> getDongNames(String gugunCode) throws Exception;
}
