package org.zerock.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Slf4j
@WebAppConfiguration
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc; //가짜서버 생성
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	@Test
	public void testList() throws Exception {
		
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) //.get or .post
				.andReturn()
				.getModelAndView()
				.getModelMap() //데이터 전달된거 확인 가능
				);
	}
	
	@Test
	public void testRegister() throws Exception {
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
						.param("title", "오라클")
						.param("content", "view공부중")
						.param("writer", "이지스퍼블리싱")
						)
				.andReturn()
				.getModelAndView()
				.getViewName() //리턴값 있을때 사용
				);
	}
	
	@Test
	public void testGet() throws Exception {
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
						.param("bno", "20") //받을때 문자열로 인식
						)
				.andReturn()
				.getModelAndView()
				.getViewName()
				);
	}
	
	@Test
	public void testRemove() throws Exception {
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
						.param("bno", "20")
						)
				.andReturn()
				.getModelAndView()
				.getViewName()
				);
	}
	
	@Test
	public void testModify() throws Exception {
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno", "3")
						.param("title", "변경!!")
						.param("content", "변경!!")
						.param("writer", "변경!!")
						) 
				.andReturn()
				.getModelAndView()
				.getViewName()
				);
	}
	
}






















