package dominio;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Abraao
 */
public class Analyzer {
	
	
	public Tree_insiders tree;
	
	/**
	 * Construtor da classe Analyzer
	 * @param tree {@link Tree_insiders}
	 * */
	public Analyzer(Tree_insiders tree) {
		this.tree = tree;
	}
	/**
	 * Construtor default
	 * */
	public Analyzer() {
		
	}
    /**
     * Cria diagrama de usuário analisando os dispositivos.
     *
     * @param user Usuário a realizar a analise..
     *
     */
    public int[] createUserDiagram(User user) {
        Date date = user.getDate();
        Collection<Device> lista_devices;
        if (date != null) {
            lista_devices = date.getHash_table().values();
            Iterator<Device> lista = lista_devices.iterator();
            int[] hist = new int[24];
            while (lista.hasNext()) {
                Device device = lista.next();
                int[] hist_device = createDeviceDiagram(device);
                for (int i = 0; i < hist.length; i++) {
                    hist[i] += hist_device[i];
                }
            }

            user.setHist(percentageDiagram(hist));
            return percentageDiagram(hist);
        }
        return null;
    }

    /**
     * Definir a porcentagem no diagrama.
     *
     * @param hist recebe os valores do histograma.
     * @return retorna o novo valor após a conversão.
     */
    public int[] percentageDiagram(int[] hist) {
        try {
            int sum = 0;
            for (int i = 0; i < hist.length; i++) {
                sum += hist[i];
            }
            for (int i = 0; i < hist.length; i++) {
                if(sum == 0)
                    sum = 1;
                hist[i] = ((hist[i] * 100) / sum);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hist;
    }

    /**
     * Cria um histograma por dispositivo.
     *
     * @param device recebe o dispositivo a ser realizado a analise.
     * @return retorna o histograma (distribuido em 24 horas).
     */
    public int[] createDeviceDiagram(Device device) {

        int[] a = new int[24];
        int[] b = new int[24];
        int[] c = new int[24];
        if (device.getInput() != null) {
            a = device.getInput().getHist();
        }
        if (device.getLogin() != null) {
            b = device.getLogin().getHist();
        }
        if (device.getHttp() != null) {
            c = device.getHttp().getHist();
        }

        int[] hist = new int[24];

        for (int i = 0; i < hist.length; i++) {
            hist[i] = a[i] + b[i] + c[i];
        }

        device.setHist(hist);
        return hist;

    }

    /**
     * Realiza uma analise por categoria.
     *
     * @param lista_user Lista com os todos os usuários.
     * @param category qual categoria a ser analisada.
     * @param type Verdadeiro se deve considerar a categoria ou falso uma data
     * (ou intervalo de datas).
     * @return retorna uma coleção de usuarios.
     */
    public Collection<User> analyzerByCategory(Collection<User> lista_user, String category, boolean type) {

        //type true represents user groupping by role, false represents by date 
        Collection<User> collection = null;
        Iterator<User> lista = lista_user.iterator();

        while (lista.hasNext()) {
            User aux = lista.next();
            if (type) {
                if (aux.getRole().equalsIgnoreCase(category)) {
                    collection.add(aux);
                }
            } else {
                String date[] = category.split("-");
                if (aux.getDate().insideInterval(date[0], date[1])) {
                    collection.add(aux);
                }
            }
        }

        return collection;
    }
    
    public void findAnomaly(Collection<User> lista_user) {
    	
    	Iterator<User> it = lista_user.iterator();
    	User aux = it.next();
    	User media = tree.medianRoles(aux.getRole());
    	double distance = 0;
    	Vector<Double> distances = new Vector<>();
    	Vector<Distance> anomaly_users = new Vector<>();
    	
    	while(it.hasNext()) {
    		for(int i = 0; i < media.getHist().length; i++) {
    			distance += Math.pow((aux.getHist()[i] - media.getHist()[i]), 2);
    		}
    		
    		distances.add(Math.sqrt(distance));
    		distance = 0;
    		if(it.hasNext()) {
    			aux = it.next();
    		}
    	}
    	
    	double iqr = IQR(distances);
    	
    	it = lista_user.iterator();
    	while(it.hasNext()) {
    		User aux2 = it.next();
    		for(int i = 0; i < media.getHist().length; i++) {
    			distance += Math.pow((aux2.getHist()[i] - media.getHist()[i]), 2);
    		}
    		if(1.5 * iqr > Math.sqrt(distance)){
    			Distance dis = new Distance(aux2, Math.sqrt(distance));
    			anomaly_users.add(dis);
    		}
    		distance = 0;
    	}
        
        
        Collections.sort(anomaly_users, (Distance o1, Distance o2) -> o1.compareTo(o2));
        
        System.out.println(anomaly_users);
    }
    
    public boolean comparador(Distance a, Distance c){
        return a.distance < c.distance;
    }
    
 public void findAnomaly(User user) {
    	User media = tree.medianRoles(user.getRole());
    	double distance = 0;
    	for(int i = 0; i < media.getHist().length; i++) {
			distance += Math.pow((user.getHist()[i] - media.getHist()[i]), 2);
		}
    	
    	distance = Math.sqrt(distance);
    	int [] hist = user.getHist();
    	double iqr = 1.5 * IQR(hist);
    	System.out.println(distance);
    	System.out.println(iqr);
    }
    
    public double IQR(int [] hist) {
    	
    	Arrays.sort(hist);
    	double Q1 = hist[(hist.length + 1)/4];
    	double Q3 = hist[(3 * (hist.length + 1))/4];
    	
    	return Q3 - Q1;
    }
    
 public double IQR(Vector<Double> distance) {
	 	
    	Arrays.sort(distance.toArray());
    	double Q1 = distance.get((distance.size() + 1)/4);
    	double Q3 = distance.get((3 * (distance.size() + 1))/4);
    	
    	return Q3 - Q1;
    }
}
