package org.zerock.mapper;

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
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach((vo)->{
			log.info("vo:{}" , vo);
		});
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1L);
		log.info("vo: {}", vo);
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("추가");
		vo.setContent("추가");
		vo.setWriter("추가");
		
		int result = mapper.insert(vo);
		log.info("result: {}", result);	
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("추가2");
		vo.setContent("추가2");
		vo.setWriter("추가2");
		
		int result = mapper.insertSelectKey(vo);
		log.info("result : {}", result);	
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setTitle("수정");
		vo.setContent("수정");
		vo.setWriter("수정");
		vo.setBno(1L);
		int result = mapper.update(vo);
		log.info("result : {}", result);
	}
	
	@Test
	public void testDelete() {
		int result = mapper.delete(23L);
		log.info("result : {}", result);	

	}
}
