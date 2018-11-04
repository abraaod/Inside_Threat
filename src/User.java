import java.util.HashMap;

public class User extends Node{

	private String name;
	private String domain;
	private String email;
	private String role;
	private Date date;
	private String start_date;
	private String end_date;
	
	public User(String name, String id, String domain, String email, String role) {
		super(id);
		this.name = name;
		this.domain = domain;
		this.email = email;
		this.role = role;
		date = null;
		start_date = null;
		end_date = null;
	}
	
	public User(String name, String id, String domain, String email, String role, String start_date, String end_date) {
		super(id);
		this.name = name;
		this.domain = domain;
		this.email = email;
		this.role = role;
		date = null;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public void addDate(Date date) {
		if(start_date == null && end_date == null) {
			if(this.date == null) {
				this.date = new Date("aggregate", getId());
			}
		} else {
			if(this.date == null) {
				this.date = new Date(start_date + "-" + end_date, getId());
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	
	
}
