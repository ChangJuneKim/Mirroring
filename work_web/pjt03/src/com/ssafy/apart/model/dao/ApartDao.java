package com.ssafy.apart.model.dao;

import java.sql.SQLException;
import java.util.Map;

public interface ApartDao {
	Map<String, String> getSidoNames() throws SQLException;
	Map<String, String> getGugunNames(String sidoCode) throws SQLException;
	Map<String, String> getDongNames(String gugunCode) throws SQLException;
}
