import java.util.HashMap;

public class Date extends Node {
	
	String user;
	HashMap<String, Device> hash_table;
	
	public Date(String id, String user) {
		super(id);
		this.user = user;
		hash_table = null;
	}
	
	public void addDevice(String key, Device device){
		if(hash_table == null){
			hash_table = new HashMap<>();
		}else{
			if(hash_table.get(key) == null){
				hash_table.put(key, device);
			}
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public HashMap<String, Device> getHash_table() {
		return hash_table;
	}

	public void setHash_table(HashMap<String, Device> hash_table) {
		this.hash_table = hash_table;
	}
	
}
