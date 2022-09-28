package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ssafy.board.util.DBUtil;

public class HouseDataDao {

	private static final String SERVICE_KEY = "QFgPOQhYrh+CCboi0j9FB4L9/iE2JfBgy+VTak4PxHUAgGwcy96K5l3+O85ijOCVbOj76VU3mQX/mFA0wguWJA==";
	private static final String URL = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHTrade";
	
	public Map<String, String> selectSidoNames(Connection conn) throws SQLException {
		String sql = "select dongCode, sidoName from dongcode where dongcode like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, "__00000000");
		
		ResultSet result = pstmt.executeQuery();
		
		Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해
		
		while(result.next()) {
			map.put(result.getString("dongCode"), result.getString("sidoName"));
		}
		
		DBUtil.close(result);
		DBUtil.close(pstmt);
		
		return map;
	}

	public Map<String, String> selectGugunNames(Connection conn, String sidoCode) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("select dongCode, gugunName \n");
		sb.append("from dongcode \n");
		sb.append("where dongcode like ? \n");
		sb.append("and gugunName is not null \n");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		pstmt.setString(1, sidoCode + "___00000");
		
		ResultSet result = pstmt.executeQuery();
		
		Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해
		
		while(result.next()) {
			map.put(result.getString("dongCode"), result.getString("gugunName"));
		}
		
		DBUtil.close(result);
		DBUtil.close(pstmt);
		
		return map;
	}

	public Map<String, String> selectDongNames(Connection conn, String gugunCode) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("select dongCode, dongName \n");
		sb.append("from dongcode \n");
		sb.append("where dongcode like ? \n");
		sb.append("and dongName is not null \n");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		pstmt.setString(1, gugunCode + "___00000");
		
		ResultSet result = pstmt.executeQuery();
		
		Map<String, String> map = new TreeMap<>(); // TreeMap을 사용하는 이유는 키 값 기준 오름차순 정렬을 위해
		
		while(result.next()) {
			map.put(result.getString("dongCode"), result.getString("dongName"));
		}
		
		DBUtil.close(result);
		DBUtil.close(pstmt);
		
		return map;
	}

	public Map<String, Object> requestRowHouseTrade(String regionCode, String dealYmd) {
		HttpHeaders headers = new HttpHeaders();
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
				.queryParam("pageNo", 1)
				.queryParam("numOfRows", 9999)
				.queryParam("LAWD_CD", regionCode)// 지역코드(동코드 5자리)
				.queryParam("DEAL_YMD", dealYmd); // 계약월
		
		// 공공 데이터 포털에서 받은 인증키 포함시키기
		// 따로 작성하는 이유는 인증키에 "/"가 포함되어 제대로 동작 X 때문
		String url = builder.toUriString() + "&serviceKey=" + SERVICE_KEY;
		System.out.println(url);
		
		// 헤더 정보를 포함해서 요청 보낼 때 사용. 현재는 보낼 내용이 없음
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Map> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				entity,
				Map.class);
		
		Map<String, Object> result = response.getBody();
		
		return result;
	}

}
