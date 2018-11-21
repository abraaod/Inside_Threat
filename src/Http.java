
public class Http extends Node {
	
	private String urls;

	public Http(String id) {
		super(id);
		urls = "";
	}
	
	public void addUrl(String url) {
		this.urls += url + "\n";
	}
	
	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}
	
}
