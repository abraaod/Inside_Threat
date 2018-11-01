import java.util.HashMap;

public class User extends Node{

	private String name;
	private String domain;
	private String email;
	private String role;
	private HashMap<String, Date> hash_table;
	
	public User(String name, String id, String domain, String email, String role) {
		super(id);
		this.name = name;
		this.domain = domain;
		this.email = email;
		this.role = role;
		hash_table = null;
	}
	
	public void addDate(String key, Date date) {
		if(hash_table ==  null) {
			hash_table = new HashMap<>();
		}else {
			if(hash_table.get(key) ==  null){
				hash_table.put(key, date);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public HashMap<String, Date> getHash() {
		return hash_table;
	}

	public void setHash(HashMap<String, Date> hash) {
		this.hash_table = hash;
	}
	
	
}
