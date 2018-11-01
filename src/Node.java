import java.util.HashMap;

public class Node{
	
	private String id;
	private int [] hist;
	
	public Node(String id) {
		this.id = id;
		hist = new int[24];
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getHist() {
		return hist;
	}

	public void setHist(int[] hist) {
		this.hist = hist;
	}
	
	
}
