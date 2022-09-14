package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementTest {

	public static void main(String[] args) {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 완료...");
			
			// 2. Connection 객체 생성
			String url = "jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			System.out.println(conn.getClass().getName());
			System.out.println("Connection 완료...");
			
			// 실행할 쿼리문 작성
			String sql = "SELECT employee_id, first_name, job_id, salary FROM employees WHERE employee_id = 100";
			
			// 3. 쿼리문을 실행할 Statement 객체를 가져옴
			Statement stmt = conn.createStatement();
			
			// 4-1. 쿼리문 실행
			ResultSet result = stmt.executeQuery(sql);
			
			// 4-2. 실행 결과 출력
			while (result.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append(result.getInt(1)).append("\t")
				.append(result.getString(2)).append("\t")
				.append(result.getString(3)).append("\t")
				.append(result.getString(4));
				
				System.out.println(sb);
			}
			
			// 5. DBMS와 연결 끊기
			result.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
