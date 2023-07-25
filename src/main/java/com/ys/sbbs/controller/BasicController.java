package com.ys.sbbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sbbs/basic") // localhost:8080/sbbs/basic
public class BasicController {
	
	// localhost:8080/sbbs/basic/basic1로 액세스
	@RequestMapping("/basic1") 
	public String basic1() {
		// application.propreties에 prepix=/WEB-INF/view/, suffix=.jsp
		// prefix가 앞에 붙고 return이 붙고 suffix가 붙는다
		// --> /WEB-INF/view/basic/basic1.jsp
		return "basic/basic1";
	}
	
	@ResponseBody
	@RequestMapping("/basic2")
	public String basic2() {
		// 문자열을 출력
		return "<h1>문자열을 웹화면으로 보낼때 @ResponseBody를 사용</h1>";
		
	}
	
	@RequestMapping("/basic3") 
	public String basic3(Model model) {
		model.addAttribute("filename", "basic3.jsp");
		model.addAttribute("message", "Model 객체를 통해 데이터가 전달됨.");
		List<String> fruits = new ArrayList<>();
		fruits.add("사과"); fruits.add("참외"); fruits.add("수박");
		model.addAttribute("fruits", fruits);
		return "basic/basic3";
	}
	
	@RequestMapping("/basic4") 
	public String basic4(HttpServletRequest req) {
		String id = req.getParameter("id");
		return "<h1>파라메터로 받은 id 값은 " + id + "입니다.<br>" 
				+ "기존 방식의 HttpServletRequest로 받을 수 있습니다.</h1>";
	}
	
	// =============================================================
	
	// 새로운 방식
	
	// 1. @RequestParam
		// localhost:8080/sbbs/basic/basic5?num=3&id=spring
	@ResponseBody
	@RequestMapping("/basic5") 
	// public String basic5(int num, String id) {
		public String basic5(int num, @RequestParam(name = "id", defaultValue = "spring") String id) {
		return "<h1>파라메터로 받은 num 값은 " + num + "이고.<br>" 
				+ "id 값은 " + id +"입니다.</h1>";
	}
		// 함수에서 파라메터를 입력하면 자동으로 매핑된다.
		// @RequestParam을 입력하여 디폴트 값을 설정할 수 있다.
	
	// 2. @PathVariable
		// localhost:8080/sbbs/basic/basic6/3/spring
	@RequestMapping("/basic6/{num}/{id}") // <-- 여기에 num, id를 써줌 
	public String basic6(@PathVariable int num, @PathVariable String id) {
		return "redirect:/sbbs/basic/basic5?num=" + num + "&id=" + id;
	} 	// sendRedirect와 유사함
	
	// 3. 메세지 전달
	@GetMapping("/basic7") 
	public String basic7(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		session.setAttribute("sessionMsg", "세션을 통한 메세지 전달");
		model.addAttribute("modelMsg", "모델을 통한 메세지 전달");
		return "basic/basic7";
	}
	
	// 4. form 전달
	@GetMapping("/basic8")
	public String basic8get() {
		return "basic/basic8";
	} // 입력받는 화면
	@ResponseBody
	@PostMapping("/basic8")
	public String basic8post(String id, String pwd) {
		return "<h1>id: " + id + ", pwd: " + pwd + "</h1>"; 
	} // 결과창, 복잡한 변환 과정이 필요없다.
	
}
