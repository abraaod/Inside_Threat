
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
}
