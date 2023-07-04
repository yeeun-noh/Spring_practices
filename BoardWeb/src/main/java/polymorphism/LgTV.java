package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV {
	
	public LgTV() {
		System.out.println("LgTV default 생성자...");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV power ON");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV power OFF");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("LgTV volume Up");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("LgTV volume Down");
	}
}
