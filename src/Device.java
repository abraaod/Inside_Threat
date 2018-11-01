import java.util.HashMap;

public class Device extends Node {

	String user;
	String date;
	
	public Device(String id, String user, String date) {
		super(id);
		this.user = user;
		this.date = date;
		// TODO Auto-generated constructor stub
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
