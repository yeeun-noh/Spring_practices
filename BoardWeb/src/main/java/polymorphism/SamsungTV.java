package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") //객체명 지정가능
public class SamsungTV implements TV {
	
	@Autowired //타입이 일치하는 객체 자동 주입 (객체에 대한 의존성을 주입)
	@Qualifier("apple") //필드, 생성자, 입력 파라미터가 여러 개인 메소드에 적용(""에 따라 주입)
	
	private Speaker speaker;
	private int price;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public SamsungTV(Speaker speaker, int price) { //index="0", index="1"
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV(Speaker speaker, int price)");
	}	
	
	//생성자:
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("SamsungTV(Speaker speaker) 객체 생성");
	}
	

	public SamsungTV() { //객체 생성되면 실행되게 기본생성자 만듬 => 확인가능
		System.out.println("SamsungTV() 객체 생성");
	}
	
	//init-method
	public void initMethod() { //초기설정
		System.out.println("객체 초기화 작업 수행"); 

	}
	
	//destroy-method
	public void destoryMethod() { //close() 연결 해제 로직 등을 호출할때 활용
		System.out.println("객체 소멸시 동작하는 부분");
	}
	
	
	
	public void powerOn() {
		System.out.println("SamsungTV 전원 ON");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV 전원 OFF");
	}
	
	public void volumeUp() {
		//System.out.println("SamsungTV 볼륨 Up");
		speaker.volumeUp();
		System.out.println("price : " + this.price);
	}
	
	public void volumeDown() {
		//System.out.println("SamsungTV 볼륨 Down");
		speaker.volumeDown();
	}
}
