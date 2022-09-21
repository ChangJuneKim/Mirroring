package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.Person;
import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.dao.PersonDao;

public class PersonService {
	PersonDao dao = new PersonDao();

	public int regist(Person newPerson) throws SQLException {
		int cnt = dao.regist(newPerson);
		return cnt;
	}

	public List<Person> findAll() throws SQLException {
		List<Person> personList = dao.findAll();
		return personList;
	}

	public Person detail(String id) throws SQLException {
		Person person = dao.findOne(id);
		return person;
	}

	public int delete(String removeId) throws SQLException {
		int cnt = dao.delete(removeId);
		return cnt;
	}

	public User login(HttpServletRequest request, String id, String password) {
		if ("ssafy".equals(id) && "1234".equals(password)) {
			User user = new User(id, password);

			// 로그인 정보를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			return user;
		}
		return null;
	}

	public boolean logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.removeAttribute("user");

		Object obj = session.getAttribute("user");
		if (obj == null) {
			return true;
		}
		return false;

	}
}
