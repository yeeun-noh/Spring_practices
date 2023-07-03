package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("SonySpeaker °´Ã¼ »ý¼º");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeaker º¼·ý Up");
	}
	
	public void volumeDown() {
		System.out.println("SonySpeaker º¼·ý Down");
	}
}
