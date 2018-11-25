package dominio;

import java.util.HashMap;

/**
 * 
 * @author Abraao
 * 
 */
public class Date extends Node {
	
	String user;
	HashMap<String, Device> hash_table;
	
        /** Construct of the Date class.
         * 
         * @param id Identification of the Date (id column of the csv).
         * @param user User that the date it's gonna communicate.
         */
	public Date(String id, String user) {
		super(id);
		this.user = user;
		hash_table = null;
	}
	
        /** Add a new device on that date.
         * 
         * @param key The identification of that date.
         * @param device Device used on that date.
         */
	public void addDevice(String key, Device device){
		if(hash_table == null){
			hash_table = new HashMap<>();
			if(getId().equals("aggregate")) {
				hash_table.put(key, device);
			}else {
				if(insideInterval(device.getDate())) {
					hash_table.put(key, device);
				}
			}
		}else{
			if(hash_table.get(key) == null){
				if(getId().equals("aggregate")){
					hash_table.put(key, device);
				} else {
					if(insideInterval(device.getDate())) {
						hash_table.put(key, device);
					}
				}
			}
		}
	}
	
        /** Verifica se é um intervalo de data valida.
         * 
         * @param date String com o intervalo no formato xx/xx/xxxx-yy/yy/yyyy
         * @return result of the test.
         */
	public boolean insideInterval(String date) {
		String [] dates = getId().split("-");
		String [] time1 = dates[0].split("/");
		String [] time2 = dates[1].split("/");
		String [] devicedate = date.split("/");
		
		if(Integer.parseInt(devicedate[0]) >= Integer.parseInt(time1[0]) && Integer.parseInt(devicedate[0]) <= Integer.parseInt(time2[0])  ) {
			if(Integer.parseInt(devicedate[1]) >= Integer.parseInt(time1[1]) && Integer.parseInt(devicedate[1]) <= Integer.parseInt(time2[1])){
				if(Integer.parseInt(devicedate[2]) >= Integer.parseInt(time1[2]) && Integer.parseInt(devicedate[2]) <= Integer.parseInt(time2[2])) {
					//System.out.println("Rodou true");
					return true;
				}
			}
				
		}
		return false;
	}
	
        /** Verifica se as datas são válidas.
         * 
         * @param date_ini Data de inicio.
         * @param date_end Data final.
         * @return Verdadeiro se são válidas, falsa se não são.
         */
	public boolean insideInterval(String date_ini, String date_end) {
		if(insideInterval(date_ini) && insideInterval(date_end)) {
			return true;
		}
		return false;
		
	}

        /** Retorna o usuário referente a data.
         * 
         * @return retorna o nome do usuário.
         */
	public String getUser() {
		return user;
	}

        /** Configura o nome do usuario referente aquela data.
         * 
         * @param user Configura o nome do usuário.
         */
	public void setUser(String user) {
		this.user = user;
	}

        /** Retorna o HashMap com o id e o dispositivo.
         * 
         * @return retorna o hashmap.
         */
	public HashMap<String, Device> getHash_table() {
		return hash_table;
	}

        /** Configura uma hashmap para a data.
         * 
         * @param hash_table nova hashtable.
         */
	public void setHash_table(HashMap<String, Device> hash_table) {
		this.hash_table = hash_table;
	}
	
}
