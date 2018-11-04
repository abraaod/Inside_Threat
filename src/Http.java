
public class Http extends Activity {
	
	String url;
	
	public Http(String id, String date, String hour, String user, String device, String url) {
		super(id, date, hour, user, device);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
