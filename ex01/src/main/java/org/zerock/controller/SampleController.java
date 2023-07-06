package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.slf4j.Slf4j;

@Controller //스프링의 객체(bean)에 등록
@RequestMapping("/sample/*") //현재 클래스의 모든 메서들이 기본적인 url경로가 됨(클래스 선언/메서드 선언 둘다 가능)
@Slf4j
public class SampleController {
	
//	@RequestMapping 을 통해서 :
//	/			 치면 => HomeController 안 home 실행	
//	/sample/ 	 치면 => SampleController 안 basic() 실행
//	/sample/list 치면 => SampleController 안 list() 실행

	
//	@RequestMapping("")
	@GetMapping("") //축약가능(GetMapping or PostMapping)
	public void basic() {
		log.info("basic....");
	}
	
	
//	입력창에 직접 칠때는 get방식만 가능 => post방식일때는 postman사용해서 확인해보기
//	@RequestMapping(value="/list", method=RequestMethod.POST) //get방식, post방식 지정가능
	@PostMapping("/list") //축약가능
	public void list() {
		log.info("list....");
	}
	
	
//	/sample/ex1?name=aaa&age=20 치면 => ex1() 실행 (무조건 값을 설정해야함, 기본값을 설정하지 않았기 때문)
	@GetMapping("/ex1")
	public void ex1(String name, int age) { //@RequestParam() 생략되어있음
		log.info("name: {}", name);
		log.info("age: {}", age);
	}
	
	
//	기본값 설정가능:
//	/sample/ex2 치면 => ex2() 실행 (설정해둔 기본값이 출력)
//	/sample/ex2?name=aaa&age=20 치면 => ex2() 실행
	@GetMapping("/ex2")
	public void ex2(@RequestParam(name="name", defaultValue="kim") String name,
					@RequestParam(name="age", defaultValue="0") int age) {
		log.info("name: {}", name);
		log.info("age: {}", age);
	}
	
	
//	@RequestParam() 생략가능(변수명이 같으면):
	@GetMapping("/ex3")
//	public void ex3(@RequestParam("name") String name, @RequestParam("age") int age) {
	public void ex3(String name, int age) {
		log.info("name: {}", name);
		log.info("age: {}", age);
	}
	
	
//	/sample/ex4 치면 => ex4() 실행 (dto: SampleDTO(name=null, age=0) 출력)
	@GetMapping("/ex4")
	public String ex4(SampleDTO dto) {
		log.info("dto: {}", dto);
		return "ex4";
	}

//	리스트 처리:
//	/sample/exList?ids=a&ids=b&ids=c 치면 => exList() 실행 (ids: [a, b, c] 출력)
	@GetMapping("/exList")
	public String exList(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
		return "exList";
	}
	
	
//	배열 처리:
//	/sample/exArray?ids=a&ids=b&ids=c 치면 => exArray() 실행 (array ids: [a, b, c] 출력)
	@GetMapping("/exArray")
	public String ex2Array(@RequestParam("ids") String[] ids) {
		log.info("array ids: " + Arrays.toString(ids));
		return "exArray";
	}
	
//	-----------------------------------------------------------------------------------------
	
//	변환이 가능한 데이터는 자동으로 변환되지만, 경우에 따라서는 파라미터를 변환해서 처리해야 하는 경우도 있음 (ex. Date타입)
//	=> (1) @InitBinder 사용:
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
//	/sample/ex5?title=park&dueDate=2023-07-06 치면 => ex5() 실행 (todo : TodoDTO(title=park, dueDate=Thu Jul 06 00:00:00 KST 2023) 출력) 
	@GetMapping("/ex5")
	public String ex5(TodoDTO todo) {
		log.info("todo : {}", todo);
		return "ex5";
	}
	
//	=> (2) 다른방법: TodoDTO.java에 @DateTimeFormat(pattern="yyyy/MM/dd") 사용:
//	/sample/ex5_2?title=park&dueDate=2023-07-06 치면 => ex5_2() 실행 (todo : TodoDTO(title=park, dueDate=Thu Jul 06 00:00:00 KST 2023) 출력) 	
	@GetMapping("/ex5_2")
	public String ex5_2(TodoDTO todo) {
		log.info("todo : {}", todo);
		return "ex5_2";
	}

//	-----------------------------------------------------------------------------------------
//	Model 객체: jsp에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 하는 존재 (jsp로 전달해야하는 데이터를 담아서 보내기 가능)
	
//	ViewResolver를 통해 /WEB-INF/views/ex06_1.jsp로 찾아감 (prefix, suffix)
	@GetMapping("/ex6")
	public String ex6(Model model) {
		model.addAttribute("text", "HelloWorld!!!");
		return "ex06_1"; //jsp와 이름 같아야함
	}
	
//	@ModelAttribute: 강제로 전달받은 파라미터를 Model에 담아서 전달하도록 할때 필요함
//	@ModelAttribute를 사용함으로써 jsp에서 호출가능
//	sample/ex6_2?name=yeeun&age=10&page=10 처럼 입력가능
	@GetMapping("/ex6_2")
	public String ex6_2(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: {}", dto);
		log.info("page: {}", page);
		return "ex06_2";
	}
	
//	-----------------------------------------------------------------------------------------
	
	@GetMapping("/list2")
	public String list(String name, Model model) {
		log.info("list2....{}", name);
		model.addAttribute("name", name);
		return "list2";
	}

//	RedirectAttributes 타입 사용 (일회성으로 데이터를 전달하는 용도 otherwise Model 사용)
//	- addAttribute(이름,값): 주소창에 입력됨(URL 뒤에 붙게돼서 refresh해도 데이터가 유지)
//	- addFlashAttribute(이름,값): 주소창에 입력 안됨(한번만 사용되고 다음에는 사용되지 않는 데이터를 전달하기 위해 사용, 일회성이라 refresh할 경우 데이터가 소멸)
	@GetMapping("/ex7")
	public String ex7(RedirectAttributes rttr) {
		rttr.addAttribute("name", "AAA");
		rttr.addFlashAttribute("age", 10);
		return "redirect:/sample/list2";
	}

//	-----------------------------------------------------------------------------------------
//	String타입 vs void타입 :
//	- String타입: jsp를 이용하는 경우에는 jsp파일의 경로와 파일이름을 나타내기 위해서 사용
//	- void타입: 호출하는 url과 동일한 이름의 jsp를 의미
	
//	return type이 void 일 경우 => /WEB-INF/views/ 안에 sample폴더를 만들고 그 안에 ex08.jsp를 만들어야함
//	해당url의 경로를 그대로 jsp파일의 이름으로 사용
	@GetMapping("/ex08") // /WEB-INF/views/sample/ex08.jsp
	public void ex8() {
		log.info("/ex08");
	}
	
//	=> /WEB-INF/views/ 안에 sample폴더를 만들고 그 안에 list폴더를 만든후 그 안에 ex09.jsp를 만들어야함
	@GetMapping("/list/ex09") // /WEB-INF/views/sample/list/ex09.jsp
	public void ex9() {
		log.info("/ex09");
	}
	
	
	@GetMapping("/ex10") // /WEB-INF/views/sample/ex10.jsp
//	public String ex10() {
	public void ex10() { //경로를 바꾸지 않을 경우 String타입대신 void타입으로 주로 사용
		log.info("/ex10");
//		return "sample/ex10";
	}
	
//	-----------------------------------------------------------------------------------------
//	객체타입:
	
//	=> (1) Model 사용하여 객체에 값을 jsp에 전달하기:
	@GetMapping("/ex11")
	public SampleDTO ex11(Model model) {
		SampleDTO dto = new SampleDTO();
		dto.setName("yeeun");
		dto.setAge(20);
		model.addAttribute("dto", dto);
		return dto;
	}
	
//	=> (2) pom.xml에 Jackson Databind 추가하고 @ResponseBody 사용하기 (jsp따로 만들지 않아도 객체값 서버에 출력):
//	/sample/ex12 치면 => 서버에 {"name":"yeeun","age":20} 출력
	@GetMapping("/ex12")
	public @ResponseBody SampleDTO ex12() {
		SampleDTO dto = new SampleDTO();
		dto.setName("yeeun");
		dto.setAge(20);
		return dto;
	}
	
//	-----------------------------------------------------------------------------------------

//	@PathVariable를 사용함으로써 경로 지정가능
//	{id} 에 any 문자열 가능
//	/sample/ex13/free 치면 => ex13.jsp 출력
	@GetMapping("/ex13/{id}")
//	@DeleteMapping("/list/{id}")
//	public String ex13(@PathVariable("id") String id) {
	public String ex13(@PathVariable() String id) { //변수명이 같으면 생략가능
		log.info("id: {}", id);
		return "/sample/ex13";
	}
	
}












