import java.util.HashMap;

public class Device extends Node {

	private String user;
	private String date;
	/*
	HashMap<String, Logon> hash_table_logon;
	HashMap<String, Http> hash_table_http;
	HashMap<String, Input> hash_table_input;*/
	private Login login;
	private Http http;
	private Input input;
	
	public Device(String id, String user, String date) {
		super(id);
		this.user = user;
		this.date = date;
		login = null;
		http = null;
		input = null;
	}
	
	public void addLogin(String key, boolean type, String hour) {
		String [] hours = hour.split(":");
		int pos = Integer.parseInt(hours[0]);
		if(login == null) {
			login = new Login(key);
			if(type) {
				login.logonUpdate(pos);
			} else {
				login.logoffUpdate(pos);
			}
		} else {
			if(type) {
				login.logonUpdate(pos);
			} else {
				login.logoffUpdate(pos);
			}
		}
	}
	
	public void addHttp(String key, String hour) {
		String [] hours = hour.split(":");
		int pos = Integer.parseInt(hours[0]);
		if(http == null) {
			http = new Http(key);
			http.updateHist(pos);
		} else {
			http.updateHist(pos);
		}
	}
	
	public void addInput(String key, boolean type, String hour) {
		String [] hours = hour.split(":");
		int pos = Integer.parseInt(hours[0]);
		if(input == null) {
			input = new Input(key);
			if(type) {
				input.connectUpdate(pos);
			} else {
				input.disconnectUpdate(pos);
			}
		} else {
			if(type) {
				input.connectUpdate(pos);
			} else {
				input.disconnectUpdate(pos);
			}
		}
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Http getHttp() {
		return http;
	}

	public void setHttp(Http http) {
		this.http = http;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	
	
	
}
