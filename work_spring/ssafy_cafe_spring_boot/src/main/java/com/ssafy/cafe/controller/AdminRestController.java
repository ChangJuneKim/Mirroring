package com.ssafy.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.model.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminRestController {

	private UserService userService;
	

	@Autowired
	public AdminRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public ResponseEntity<?> userList() {
		List<User> users = userService.getUsers();

		try {
			if (users != null && !users.isEmpty()) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Error: userList()", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<?> userRegister(@RequestBody User user) {
		userService.addUser(user);

		// 새로운 회원목록 받아오기
		List<User> users = userService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
	}

	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userInfo(@PathVariable("userid") String userId) {

		try {
			User user = userService.getUser(userId);
			if (user != null) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Error: userInfo()", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/user/{userid}")
	public ResponseEntity<?> userModify(@RequestBody User user, @PathVariable("userid") String userId) {
		try {
			user.setId(userId);
			userService.modifyUser(user);

			// 새로운 회원목록 받아오기
			List<User> users = userService.getUsers();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Error: userModify()", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> userRemove(@PathVariable("userid") String userId) {

		try {
			userService.removeUser(userId);

			// 새로운 회원목록 받아오기
			List<User> users = userService.getUsers();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Error: userRemove()", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
