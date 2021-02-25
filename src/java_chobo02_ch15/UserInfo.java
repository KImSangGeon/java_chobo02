package java_chobo02_ch15;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 2447933798827085811L;
	
	String name;
	String password;
	private int age;
	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("UserInfo [name=%s, password=%s, age=%s]", name, password, age);
	}
	public UserInfo() {
		this("Inknown", "1111", 0);		
	}


		
		

}
