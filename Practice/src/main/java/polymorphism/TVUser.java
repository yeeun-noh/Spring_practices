package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
//		일반적인 방법:
//		TV tv = new SamsungTV();
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
		
		
		//1.스프링컨테이너를 구동함:
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		//2.컨테이너에 올라온 빈 객체 요청후 참조함:
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		factory.close();
	}
}
