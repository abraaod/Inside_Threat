package dominio;

import java.util.HashMap;

/**
 *
 * @author Abraao
 *
 */
public class Device extends Node {

	private String user;
	private String date;
	private Login login;
	private Http http;
	private Input input;
	
        /**
         * Construct of the device.
         * 
         * @param id identification of the device.
         * @param user user that used that device.
         * @param date date that used the device.
         * 
         */
	public Device(String id, String user, String date) {
		super(id);
		this.user = user;
		this.date = date;
		login = null;
		http = null;
		input = null;
	}
	
        /**
         * Adicionar um login aquele dispositivo.
         * 
         * @param key Chave de identificação do login.
         * @param type True se foi um logon, False se foi um logoff.
         * @param hour horário que foi realziado o login.
         */
	public void addLogin(String key, boolean type, String hour) {
		String [] hours = hour.split(":");
		int pos = Integer.parseInt(hours[0]);
		if(login == null) {
			login = new Login(key);
			if(type) {
				login.logonUpdate(pos);
			} else {
				login.logoffUpdate(pos);
			}
		} else {
			if(type) {
				login.logonUpdate(pos);
			} else {
				login.logoffUpdate(pos);
			}
		}
	}
	
        /**
         * Adiciona URLs (HTTP).
         * 
         * @param key Chave de identificação da URL.
         * @param url Url que foi utilizada.
         * @param hour horário em que foi acessada.
         */
	public void addHttp(String key, String url, String hour) {
		String [] hours = hour.split(":");
		int pos = Integer.parseInt(hours[0]);
		if(http == null) {
			http = new Http(key);
			http.addUrl(url);
			http.updateHist(pos);
		} else {
			http.addUrl(url);
			http.updateHist(pos);
		}
	}
	
        /**
         * Adiciona uma movimentação de uso de dispositivos de entrada.
         * 
         * @param key chave de identificação da entrada.
         * @param type True se foi conectado e falso se foi desconectado.
         * @param hour horário em que foi realizada a movimentação.
         */
	public void addInput(String key, boolean type, String hour) {
		String [] hours = hour.split(":");
		int pos = Integer.parseInt(hours[0]);
		if(input == null) {
			input = new Input(key);
			if(type) {
				input.connectUpdate(pos);
			} else {
				input.disconnectUpdate(pos);
			}
		} else {
			if(type) {
				input.connectUpdate(pos);
			} else {
				input.disconnectUpdate(pos);
			}
		}
	}
	
        /**
         * Retorna o nome de usuário.
         * 
         * @return retorna o identificador do usuário.
         */
	public String getUser() {
		return user;
	}

        /**
         * Configura o nome de usuário.
         * 
         * @param user configura o identificador do usuário.
         */
	public void setUser(String user) {
		this.user = user;
	}

        /**
         * Retorna a data.
         * 
         * @return retorna a data do dispositivo.
         */
	public String getDate() {
		return date;
	}

        /**
         * Configura a data do dispositivo.
         * 
         * @param date Configura uma data para o dispositivo.
         */
	public void setDate(String date) {
		this.date = date;
	}

        /**
         * Retorna o login daquele dispositivo.
         * 
         * @return retorna o login.
         */
	public Login getLogin() {
		return login;
	}

        /**
         * Configura um login para o dispositivo.
         * 
         * @param login Login a ser adicionado para o dispositivo.
         * 
         */
	public void setLogin(Login login) {
		this.login = login;
	}

        /**
         * Retorna as URLs acessadas pelo dispositivo.
         * 
         * @return URLs acessadas pelo dispositivo.
         */
	public Http getHttp() {
		return http;
	}

        /**
         * Configura URLs para o dispositivo.
         * 
         * @param http URLs acessada pelo dispositivo.
         */
	public void setHttp(Http http) {
		this.http = http;
	}

        /**
         * Retorna se houve dispositivos de entrada.
         * 
         * @return Retorna o estado da classe Input.
         */
	public Input getInput() {
		return input;
	}

        /**
         * Configura se houve acesso de dispositivo de entrada.
         * 
         * @param input Configura os estados de dispositivos de entrada.
         */
	public void setInput(Input input) {
		this.input = input;
	}

	
	
	
}
