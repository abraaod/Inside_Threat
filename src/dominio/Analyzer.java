package dominio;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class Analyzer {
	
	public void createUserDiagram(User user) {
		//System.out.println("rodou aq");
		Date date = user.getDate();
		Collection<Device> lista_devices;
		if(date != null) {
			lista_devices = date.getHash_table().values();
			Iterator<Device> lista = lista_devices.iterator();
			int [] hist = new int [24];
			while(lista.hasNext()) {
				Device device = lista.next();
				int [] hist_device = createDeviceDiagram(device);
				for(int i =0; i < hist.length; i++) {
					hist[i] += hist_device[i];
				}
			}

			/*for(int i =0 ; i < hist.length; i++) {
				System.out.print(hist[i] + " ");
			}
			System.out.println();
			user.getDate().setHist(hist);*/
			user.setHist(percentageDiagram(hist));
		}
	}
	
	public int [] percentageDiagram(int [] hist) {
		int sum = 0;
		for(int i = 0; i < hist.length; i++) {
			sum += hist[i];
		}
		for(int i = 0; i < hist.length; i++) {
			hist[i] = ((hist[i]* 100)/sum);
		}
		return hist;
	}
	
	public int [] createDeviceDiagram(Device device) {
		
		int [] a = new int[24];
		int [] b = new int[24];
		int [] c = new int[24];
		if(device.getInput() != null) {
			a = device.getInput().getHist();
		}
		if(device.getLogin() != null) {
			b = device.getLogin().getHist();
		}
		if(device.getHttp() != null) {
			c = device.getHttp().getHist();
		}
		
		int [] hist = new int[24];
		
		for(int i = 0; i < hist.length; i++) {
			hist[i] = a[i] + b[i] + c[i];
		}
		
		device.setHist(hist);
		return hist;
		
	}
	
	public Collection<User> analyzerByCategory(Collection<User> lista_user, String category, boolean type) {
		
		//type true represents user groupping by role, false represents by date 
		
		Collection<User> collection = null;
		Iterator<User> lista = lista_user.iterator();
		
		while(lista.hasNext()) {
			User aux = lista.next();
			if(type) {
				if(aux.getRole().equals(category)) {
					collection.add(aux);
				}
			} else {
				String date [] = category.split("-");
				if(aux.getDate().insideInterval(date[0], date[1])) {
					collection.add(aux);
				}
			}
		}
		
		return collection;
	}
}
