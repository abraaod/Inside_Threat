package dominio;


public class Login extends Node{
	
	Logon logon;
	Logoff logoff;
	
	public Login(String id) {
		super(id);
		logon = new Logon(id);
		logoff = new Logoff(id);
	}
	
	public void logonUpdate(int pos) {
		logon.updateHist(pos);
	}
	
	public void logoffUpdate(int pos) {
		logoff.updateHist(pos);
	}
	public Logon getLogon() {
		return logon;
	}

	public void setLogon(Logon logon) {
		this.logon = logon;
	}

	public Logoff getLogoff() {
		return logoff;
	}

	public void setLogoff(Logoff logoff) {
		this.logoff = logoff;
	}
	
	public int [] getHist() {
		int [] a = logon.getHist();
		int [] b = logoff.getHist();
		int [] hist = new int [24];
		for(int i = 0; i < hist.length; i++) {
			hist[i] = a[i] + b[i];
		}
		return hist;
		
	}
	
		
}
