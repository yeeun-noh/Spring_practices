package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV {
	
	public LgTV() {
		System.out.println("LgTV ������...");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV ���� ON");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV ���� OFF");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("LgTV ���� Up");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("LgTV ���� Down");
	}
}
