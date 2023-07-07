package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

//새로운 클래스 만들고 bean에 등록해야함:
//servlet-context.xml > <context:component-scan base-package="org.zerock.exception" /> 추가

//-예외사항 처리:
@ControllerAdvice
@Slf4j
public class CommonExceptionAdvice {

	@ExceptionHandler //-해당메서드가 () 들어가는 예외타입을 처리함(Exception 클래스타입 지정가능)
	public String except(Exception ex, Model model) {
		log.error("Exception: {}", ex.getMessage());
		model.addAttribute("exception", ex);
		log.error("model: {}", model);
		
		return "error_page"; //views/error_page.jsp 찾아감
	}
}
