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
		User user = null;
		user = hash_user.get(date.getUser());
		if(user != null){
			user.addDate(date);
		}
	}
	
	public void insertDevice(Device device){
		User user = null;
		user = hash_user.get(device.getUser());
		if(user != null){
			Date date = user.getDate();
			if(date != null){
				date.addDevice(device.getId(), device);
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
