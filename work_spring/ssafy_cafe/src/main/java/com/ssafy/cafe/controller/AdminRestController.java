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

import com.ssafy.cafe.model.User;
import com.ssafy.cafe.model.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminRestController {
	
	private final UserService userService;

	@Autowired
	public AdminRestController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> userList(){
		try {
			List<User> users = userService.getUsers(null);
			
			if(users != null && !users.isEmpty()) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> userRegister(@RequestBody User user) {
		try {
			userService.addUser(user);
			List<User> users = userService.getUsers(null);
			if(users != null && !users.isEmpty()) {
				return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody User user) {
		try {
			userService.modifyUser(user);
			List<User> users = userService.getUsers(null);
			if(users != null && !users.isEmpty()) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/user/{userid}")
	// 리턴되는 String이 view의 이름? 경로? 가 아니라 데이터 그 자체라는 뜻 (@ResponseBody)를 붙여야 되는데 컨트롤러 자체를 RestController라고 하면?
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) {
		try {
			
			userService.deleteUser(userId);
			List<User> users = userService.getUsers(null);
			if(users != null && !users.isEmpty()) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/user/{userid}")
	// 리턴되는 String이 view의 이름? 경로? 가 아니라 데이터 그 자체라는 뜻 (@ResponseBody)를 붙여야 되는데 컨트롤러 자체를 RestController라고 하면?
	public ResponseEntity<?> userView(@PathVariable("userid") String userId) {
		try {
			
			User user = userService.getUser(userId);
			
			if(user != null) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
