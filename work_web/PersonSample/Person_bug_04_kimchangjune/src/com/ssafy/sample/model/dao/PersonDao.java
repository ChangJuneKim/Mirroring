package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.ssafy.sample.dto.Person;
import com.ssafy.sample.util.DBUtil;

public class PersonDao {
	private DBUtil dbUtil = DBUtil.getInstance();

	public int regist(Person newPerson) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("insert into person (id, name, department_name, pay)\n");
		sql.append("values (?, ?, ?, ?)");

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newPerson.getId());
			pstmt.setString(2, newPerson.getName());
			pstmt.setString(3, newPerson.getDepartment_name());
			pstmt.setInt(4, newPerson.getPay());

			int count = pstmt.executeUpdate();

			if (count == 0) {
				throw new SQLException();
			}
			return count;

		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	public List<Person> findAll() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("select id, name, department_name, pay\n");
		sql.append("from person");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			List<Person> people = new ArrayList<>();

			while (rs.next()) {
				Person person = new Person(rs.getString("id"), rs.getString("name"), rs.getString("department_name"),
						rs.getInt("pay"));
				people.add(person);
			}

			return people;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	public Person findOne(String id) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("select id, name, department_name, pay\n");
		sql.append("from person\n");
		sql.append("where id = ?");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Person person = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				person = new Person(rs.getString("id"), rs.getString("name"), rs.getString("department_name"),
						rs.getInt("pay"));
			}

			if (person == null) {
				throw new SQLException();
			}

			return person;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	public int delete(String removeId) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("delete\n");
		sql.append("from person\n");
		sql.append("where id = ?");

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, removeId);

			int count = pstmt.executeUpdate();

			return count;

		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
}
