import java.util.HashMap;

public class Tree_insiders {
	
	HashMap<String, User> hash_user;
	
	public Tree_insiders() {
		hash_user = null;
	}
	
	public void insertUser(User user) {
		if(hash_user == null) {
			hash_user = new HashMap<>();
			hash_user.put(user.getId(), user);
		} else {
			hash_user.put(user.getId(), user);
		}
	}
	
	public void insertDate(Date date){
		User user = hash_user.get(date.getUser());
		if(user != null){
			user.addDate(date);
		}
	}
	
	public void insertDevice(Device device){
		User user = hash_user.get(device.getUser());
		if(user != null){
			Date date = user.getDate();
			if(date != null){
				date.addDevice(device.getId(), device);
			}
		}
	}
	
	public void insertLogon(Logon logon) {
		User user = hash_user.get(logon.getUser());
		Date date = user.getDate();
		if(date != null) {
			if(date.insideInterval(logon.getDate())) {
				Device device = user.getDate().getHash_table().get(logon.getDevice());
				if(device != null) {
					device.addLogon(logon.getId(), logon);
				}
			}
		}
	}
	
	public void insertHttp(Http http) {
		User user = hash_user.get(http.getUser());
		Date date = user.getDate();
		if(date != null) {
			if(date.insideInterval(http.getDate())) {
				Device device = user.getDate().getHash_table().get(http.getDevice());
				if(device != null) {
					device.addHttp(http.getId(), http);
				}
			}
		}
	}
	
	public void insertInput(Input input) {
		User user = hash_user.get(input.getUser());
		Date date = user.getDate();
		if(date != null) {
			if(date.insideInterval(input.getDate())) {
				Device device = user.getDate().getHash_table().get(input.getDevice());
				if(device != null) {
					device.addInput(input.getId(), input);
				}
			}
		}
	}
	
	public int getUserSize() {
		if(hash_user != null) {
			return hash_user.size();
		}
		return 0;
	}
}
