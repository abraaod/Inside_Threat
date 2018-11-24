package dominio;

import dominio.Connect;
import java.util.Arrays;

/**
 *
 * @author Abraao.
 *
 */
public class Input extends Node{
	
	Connect connect;
	Disconnect disconnect;
	
        /**
         * Construtor para a classe Input.
         * 
         * @param id identificador do dispositivo.
         */
	public Input(String id) {
		super(id);
		connect = new Connect(id);
		disconnect = new Disconnect(id);
		// TODO Auto-generated constructor stub
	}	
	
        /**
         * Atualizar o horário do histograma.
         * 
         * @param pos horário que foi conectado.
         */
	public void connectUpdate(int pos) {
		connect.updateHist(pos);
	}
	
        /**
         * Atualizar o horário do histograma.
         * 
         * @param pos horario que foi disconectado.
         */
	public void disconnectUpdate(int pos) {
		disconnect.updateHist(pos);
	}

        /**
         * Retornar a conexão.
         * 
         * @return retorna o estado conectado.
         * 
         */
	public Connect getConnect() {
		return connect;
	}

        /**
         * Configura o estado de conectado.
         * 
         * @param connect Estado de conexão.
         */
	public void setConnect(Connect connect) {
		this.connect = connect;
	}

        /**
         * Retorna o estado de conexão disconectado.
         * 
         * @return estado disconectado.
         */
	public Disconnect getDisconnect() {
		return disconnect;
	}

        /**
         * Configura o estado de disconexão.
         * 
         * @param disconnect novo estado de disconexão.
         */
	public void setDisconnect(Disconnect disconnect) {
		this.disconnect = disconnect;
	}
	
        /**
         * Retorna o histograma quanto as entradas.
         * 
         * @return retorna o histograma.
         */
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
