package dominio;
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
			if(getId().equals("aggregate")) {
				hash_table.put(key, device);
			}else {
				if(insideInterval(device.getDate())) {
					hash_table.put(key, device);
				}
			}
		}else{
			if(hash_table.get(key) == null){
				if(getId().equals("aggregate")){
					hash_table.put(key, device);
				} else {
					if(insideInterval(device.getDate())) {
						hash_table.put(key, device);
					}
				}
			}
		}
	}
	
	public boolean insideInterval(String date) {
		String [] dates = getId().split("-");
		String [] time1 = dates[0].split("/");
		String [] time2 = dates[1].split("/");
		String [] devicedate = date.split("/");
		
		if(Integer.parseInt(devicedate[0]) >= Integer.parseInt(time1[0]) && Integer.parseInt(devicedate[0]) <= Integer.parseInt(time2[0])  ) {
			if(Integer.parseInt(devicedate[1]) >= Integer.parseInt(time1[1]) && Integer.parseInt(devicedate[1]) <= Integer.parseInt(time2[1])){
				if(Integer.parseInt(devicedate[2]) >= Integer.parseInt(time1[2]) && Integer.parseInt(devicedate[2]) <= Integer.parseInt(time2[2])) {
					return true;
				}
			}
				
		}
		return false;
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
