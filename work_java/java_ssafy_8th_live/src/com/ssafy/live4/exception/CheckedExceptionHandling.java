package com.ssafy.live4.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedExceptionHandling {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// @@TODOBLOCK: 다음에서 발생하는 예외를 처리해보자.

		try {
			Class.forName("abc.Def");
			new FileInputStream("Hello.java"); // FileNotFoundException
			DriverManager.getConnection("Hello"); // SQLException
		}
		catch (ClassNotFoundException | FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다. " + e.getMessage());
		}
		catch (SQLException e) {
			System.out.println("DB 접속 실패. " + e.getMessage());
		}

		// @@END:
		System.out.println("프로그램 정상 종료");

	}
}
