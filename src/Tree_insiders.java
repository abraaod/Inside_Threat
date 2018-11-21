import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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
	
	public void insertConnect(Device device, String hours) {
		User user = hash_user.get(device.getUser());
		if(user != null) {
			Date date = user.getDate();
			if(date != null) {
				if(date.getId().equals("aggregate")) {
					date.getHash_table().get(device.getId()).addInput(device.getId(), true, hours);
				} else if (date.insideInterval(device.getDate())){
					date.getHash_table().get(device.getId()).addInput(device.getId(), true, hours);
				}
			}
		}
	}
	
	public void insertDisconnect(Device device, String hours) {
		User user = hash_user.get(device.getUser());
		if(user != null) {
			Date date = user.getDate();
			if(date != null) {
				if(date.getId().equals("aggregate")) {
					date.getHash_table().get(device.getId()).addInput(device.getId(), false, hours);
				} else if (date.insideInterval(device.getDate())){
					date.getHash_table().get(device.getId()).addInput(device.getId(), false, hours);
				}
			}
		}
	}
	
	public void insertLogon(Device device, String hours) {
		User user = hash_user.get(device.getUser());
		if(user != null) {
			Date date = user.getDate();
			if(date != null) {
				if(date.getId().equals("aggregate")) {
					date.getHash_table().get(device.getId()).addLogin(device.getId(), true, hours);
				} else if (date.insideInterval(device.getDate())){
					date.getHash_table().get(device.getId()).addLogin(device.getId(), true, hours);
				}
			}
		}
	}
	
	public void insertLogoff(Device device, String hours) {
		User user = hash_user.get(device.getUser());
		if(user != null) {
			Date date = user.getDate();
			if(date != null) {
				if(date.getId().equals("aggregate")) {
					date.getHash_table().get(device.getId()).addLogin(device.getId(), false, hours);
				} else if (date.insideInterval(device.getDate())){
					date.getHash_table().get(device.getId()).addLogin(device.getId(), false, hours);
				}
			}
		}
	}
	
	public void insertUrl(Device device, String url, String hours) {
		User user = hash_user.get(device.getUser());
		if(user != null) {
			Date date = user.getDate();
			if(date != null) {
				if(date.getId().equals("aggregate")) {
					date.getHash_table().get(device.getId()).addHttp(device.getId(), url, hours);
				} else if (date.insideInterval(device.getDate())){
					date.getHash_table().get(device.getId()).addHttp(device.getId(), url, hours);
				}
			}
		}
	}
	
	public void doAnalyzer() {
		Analyzer analyzer = new Analyzer();
		Collection<User> lista_user = hash_user.values();
		Iterator<User> lista = lista_user.iterator();
		while(lista.hasNext()) {
			analyzer.analyzerUsers(lista.next());
		}
	}
	
	
	/*public void insertLogon(Logon logon) {
		User user = hash_user.get(logon.getUser());
		Date date = user.getDate();
		if(date != null) {
			if(date.getId().equals("aggregate")) {
				Device device = user.getDate().getHash_table().get(logon.getDevice());
				if(device != null) {
					device.addLogon(logon.getId(), logon);
				}
			} else if(date.insideInterval(logon.getDate())) {
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
			if(date.getId().equals("aggregate")) {
				Device device = user.getDate().getHash_table().get(http.getDevice());
				if(device != null) {
					device.addHttp(http.getId(), http);
				}
			} else if(date.insideInterval(http.getDate())) {
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
			if(date.getId().equals("aggregate")) {
				Device device = user.getDate().getHash_table().get(input.getDevice());
				if(device != null) {
					device.addInput(input.getId(), input);
				}
			} else if(date.insideInterval(input.getDate())) {
				Device device = user.getDate().getHash_table().get(input.getDevice());
				if(device != null) {
					device.addInput(input.getId(), input);
				}
			}
		}
	}*/
	
	public HashMap<String, User> getHash_user() {
		return hash_user;
	}

	public void setHash_user(HashMap<String, User> hash_user) {
		this.hash_user = hash_user;
	}
	
	public User getSpecificUser(String search) {
		return hash_user.get(search);
	}
	public void users() {
		Collection<User> lista = hash_user.values();
		Iterator<User> users = lista.iterator();
		while(users.hasNext()) {
			User aux = users.next();
			System.out.println(aux.getId());
		}
		System.out.println(lista.size());
	}
}
