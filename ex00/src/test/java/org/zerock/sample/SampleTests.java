package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

//테스트 환경
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j 대신 @Slf4j 사용:
@Slf4j
public class SampleTests {

	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
//		System.out.println("restaurant: " + restaurant);
//		sysout 가급적 사용 자제 (INSTEAD log.info 사용)
		log.info("restaurant=> {}", restaurant);
		log.info("restaurant: {}", restaurant.getChef());
//		위의 로그 아웃풋:
//		INFO : org.zerock.sample.SampleTests - restaurant=> Restaurant(chef=Chef())
//		INFO : org.zerock.sample.SampleTests - restaurant: Chef()
	}
}
