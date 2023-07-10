package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardServiceImplTest {

	@Autowired
	private BoardService service;
	
	@Test
	public void testGetList() {
		log.info("--------------testGetList");
		service.getList().forEach(
				(list)->{
					log.info("list: {}", list);
				});
	}
	
	@Test
	public void testRemove() {
		log.info("--------------testRemove");
		log.info("delete========> : {}", service.remove(2L));
	}
	
	@Test
	public void testModify() {
		log.info("--------------testModify");
		BoardVO vo = new BoardVO();
		vo.setTitle("변경");
		vo.setContent("변경");
		vo.setWriter("변경");
		vo.setBno(3L);

		log.info("modify========> : {}", service.modify(vo));
	}
	
	@Test
	public void testGet() {
		log.info("--------------testGet");
		log.info("read========> : {}", service.get(3L));
	}
	
	@Test
	public void testRegister() {
		log.info("--------------testRegister");
		BoardVO vo = new BoardVO();
		vo.setTitle("추가");
		vo.setContent("추가");
		vo.setWriter("추가");
		service.register(vo);
		
		log.info("insert========> : {}", vo);
	}
	
}
