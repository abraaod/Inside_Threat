
public class Logon extends Activity{
	
	
	String activity;
	
	public Logon(String id, String date, String hour, String user, String device, String activity) {
		super(id, date, hour, user, device);
		this.activity = activity;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
}
