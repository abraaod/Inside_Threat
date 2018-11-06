package dominio;

import java.util.HashMap;

public class Device extends Node {

	String user;
	String date;
	HashMap<String, Logon> hash_table_logon;
	HashMap<String, Http> hash_table_http;
	HashMap<String, Input> hash_table_input;
	
	public Device(String id, String user, String date) {
		super(id);
		this.user = user;
		this.date = date;
		hash_table_logon = null;
		hash_table_http = null;
		hash_table_input = null;
	}
	
	public void addLogon(String key, Logon logon) {
		if(hash_table_logon == null) {
			hash_table_logon = new HashMap<>();
			hash_table_logon.put(key, logon);
		} else {
			hash_table_logon.put(key, logon);
		}
	}
	
	public void addHttp(String key, Http http) {
		if(hash_table_http == null) {
			hash_table_http = new HashMap<>();
			hash_table_http.put(key, http);
		} else {
			hash_table_http.put(key, http);
		}
	}
	
	public void addInput(String key, Input input) {
		if(hash_table_input == null) {
			hash_table_input = new HashMap<>();
			hash_table_input.put(key,input);
		} else {
			hash_table_input.put(key, input);
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

	public HashMap<String, Logon> getHash_table_logon() {
		return hash_table_logon;
	}

	public void setHash_table_logon(HashMap<String, Logon> hash_table_logon) {
		this.hash_table_logon = hash_table_logon;
	}

	public HashMap<String, Http> getHash_table_http() {
		return hash_table_http;
	}

	public void setHash_table_http(HashMap<String, Http> hash_table_http) {
		this.hash_table_http = hash_table_http;
	}

	public HashMap<String, Input> getHash_table_input() {
		return hash_table_input;
	}

	public void setHash_table_input(HashMap<String, Input> hash_table_input) {
		this.hash_table_input = hash_table_input;
	}
	
	
}
