package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component("lgtv")
@AllArgsConstructor
public class LgTV implements TV {

	private final Speaker speaker;
//	private int price;
	//-자바에서 생성자 or setter 통해서 이 객체에 접근해서 사용가능
	//-스프링도 bean에 먼저 등록 =>
	//(1)생성자 이용: <constructor-arg>에 추가하여 사용 or
	//(2)setter이용: <property>에 추가하여 사용
	
/*	
	//(1)생성자 이용
	public LgTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}

	
	//(2)setter이용
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
*/
	
	
/*
	public void initmethod() {
		System.out.println("LgTV 초기화 작업");
	}
	
	public void destorymethod() {
		System.out.println("LgTV 소멸시 동작");
	}
	
	public LgTV() {
		System.out.println("LgTV default 생성자...");
	}
 */
	
	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV powerOff");
		
	}

	@Override
	public void volumeUp() {
//		System.out.println("LgTV volumeUp");
		speaker.volumeUp();		
//		System.out.println("price: " + price);
	}

	@Override
	public void volumeDown() {
//		System.out.println("LgTV volumeDown");
		speaker.volumeDown();	
	}

}
