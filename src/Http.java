
public class Http extends Node {
	
	String date;
	String hour;
	String user;
	String device;
	String url;
	
	public Http(String id, String date, String hour, String user, String device, String url) {
		super(id);
		this.date = date;
		this.hour = hour;
		this.user = user;
		this.device = device;
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
