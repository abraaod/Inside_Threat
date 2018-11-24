package dominio;

import java.util.HashMap;

public class Node{
	
	private String id;
	private int [] hist;
	
	public Node(String id) {
		this.id = id;
		hist = new int[24];
		
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getHist() {
		return this.hist;
	}

	public void setHist(int[] hist) {
		this.hist = hist;
	}
	
	public void updateHist(int pos) {
		hist[pos] += 1;
	}
	
}
