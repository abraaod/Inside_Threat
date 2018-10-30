import java.util.HashMap;

public class Tree_insiders {
	
	HashMap<String, User> hash_user;
	
	public Tree_insiders() {
		hash_user = null;
	}
	
	public void insertUser(User user) {
		if(hash_user == null) {
			hash_user = new HashMap<>();
		} else {
			hash_user.put(user.getId(), user);
		}
	}
	
	public int getUserSize() {
		if(hash_user != null) {
			return hash_user.size();
		}
		return 0;
	}
}
