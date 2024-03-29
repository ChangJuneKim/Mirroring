package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.UserService;

@Controller
public class BookController {
	
	@Autowired
	private  UserService userService;
	@Autowired
	private  BookService bookService;

//	@Autowired
//	public BookController(UserService userService, BookService bookService) {
//		this.userService = userService;
//		this.bookService = bookService;
//	}

	@GetMapping({ "/", "/index" })
	public String showRoot(@RequestParam(required = false) String msg, Model model) {

		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		return "index";
	}

	@PostMapping("/login")
	public String doLogin(User user, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		
		User selected = userService.login(user);
		
		if (selected != null) {
			session.setAttribute("loginUser", selected);
			return "redirect:/";
		}
		else {
			redirectAttributes.addAttribute("msg", "로그인 실패");
			return "redirect:/";
		}
	}


	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@GetMapping("/list")
	public String showList(Model model) {
		SearchCondition condition = new SearchCondition();
		condition.setLimit(false); // 페이지 구분 없이 모든 도서 목록을 출력하기 위해 false

		List<Book> books = bookService.search(condition);

		model.addAttribute("books", books);
		return "list";
	}

	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}

	// 현재 클라이언트에서는 book이라는 이름으로 보내는 데이터가 없기 때문에
	// Book DTO 파라메터 앞에는 @RequestParam을 붙이면 안된다.
	@PostMapping("/regist")
	public String doRegist(@ModelAttribute Book book/* , Model model */) throws IllegalStateException, IOException {

		// model.addAttribute("book", book);

		bookService.insert(book);

		return "regist_result";
	}
}
