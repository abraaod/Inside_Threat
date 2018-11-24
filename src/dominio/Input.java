package dominio;

import dominio.Connect;
import java.util.Arrays;

public class Input extends Node{
	
	Connect connect;
	Disconnect disconnect;
	
	public Input(String id) {
		super(id);
		connect = new Connect(id);
		disconnect = new Disconnect(id);
		// TODO Auto-generated constructor stub
	}	
	
	public void connectUpdate(int pos) {
		connect.updateHist(pos);
	}
	
	public void disconnectUpdate(int pos) {
		disconnect.updateHist(pos);
	}

	public Connect getConnect() {
		return connect;
	}

	public void setConnect(Connect connect) {
		this.connect = connect;
	}

	public Disconnect getDisconnect() {
		return disconnect;
	}

	public void setDisconnect(Disconnect disconnect) {
		this.disconnect = disconnect;
	}
	
	public int [] getHist() {
		
		int [] a = connect.getHist();
		int [] b = disconnect.getHist();
		int [] hist = new int [24];
		for(int i = 0; i < hist.length; i++) {
			hist[i] = a[i] + b[i];
		}
		return hist;
		
	}
}
