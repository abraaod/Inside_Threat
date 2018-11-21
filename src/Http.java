import java.util.Vector;

public class Http extends Node {
	
	private Vector<String> urls;

	public Http(String id) {
		super(id);
		urls = new Vector<>();
	}
	
	public void addUrl(String url) {
		this.urls.add(url);
	}

	public Vector<String> getUrls() {
		return urls;
	}

	public void setUrls(Vector<String> urls) {
		this.urls = urls;
	}
	
}
