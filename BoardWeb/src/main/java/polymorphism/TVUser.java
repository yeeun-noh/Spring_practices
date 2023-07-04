package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//인터페이스TV를 의존
public class TVUser {

	public static void main(String[] args) {
	/*
		TV tv = new SamsungTV(); //인터페이스를 사용함으로써 수정할일 최소화(구현하는 메서드이름 통일)
		//TV tv = new LgTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	*/ 
		
		
		//1. Spring 컨테이너 구동
		//- "applicationContext.xml" 를 읽고 찾아가 수행
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); //xml설정기반		
//		AbstractApplicationContext factory2 = new XmlWebApplicationContext("applicationContext.xml");	 //웹기반 스프링
		
		
		//2. 스프링 컨테이너로부터 필요한 객체 요청
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		//<bean>에 하나의 객체를 생성해 tv1,tv2,tv3 모두 접근함 
		
		
		
		tv1.powerOn();
		System.out.println("----------------");
		tv1.volumeUp();
		
		factory.close();
	}

}
