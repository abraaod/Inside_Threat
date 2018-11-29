package dominio;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author Abraao
 */
public class Analyzer {

	public Tree_insiders tree;

	/**
	 * Construtor da classe Analyzer
	 * 
	 * @param tree {@link Tree_insiders}
	 */
	public Analyzer(Tree_insiders tree) {
		this.tree = tree;
	}

	/**
	 * Construtor default
	 */
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
				if (sum == 0)
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
	 * @param category   qual categoria a ser analisada.
	 * @param type       Verdadeiro se deve considerar a categoria ou falso uma data
	 *                   (ou intervalo de datas).
	 * @return retorna uma coleção de usuarios.
	 */
	public Vector<User> analyzerByCategory(String category, boolean type) {

		// type true represents user groupping by role, false represents by date
		Collection<User> lista_user = tree.getHash_user().values();
		Vector<User> collection = new Vector<>();
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

        /**
         * Método de ordenação de um vetor.
         * 
         * @param lista_distance vetor com todas as distancias a ser ordenadas.
         */
	public void order(Vector<Distance> lista_distance) {
		for (int i = 0; i < lista_distance.size() - 1; i++) {
			for (int j = i + 1; j < lista_distance.size(); j++) {
				if (lista_distance.get(i).getDistance() > lista_distance.get(j).getDistance()) {
					//System.out.println("rodou aq");
					Distance aux = lista_distance.get(i);
					lista_distance.set(i, lista_distance.get(j));
					lista_distance.set(j, aux);
				}
			}
		}
	}

        /**
         * Procurar anomalias de um vetor de usuários em um determinado papel.
         * 
         * @param lista Lista com os usuários.
         * @param category Papel para servir como base para calcular a anomalia.
         * @return Lista com possíveis infiltrados.
         */
	public Vector<Distance> findAnomaly(Vector<User> lista, String category) {
		Iterator<User> it = lista.iterator();// lista_user.iterator();
		User media = tree.medianRoles(category);
		double distance = 0;
		double [] distances = new double[lista.size()];
		Vector<Distance> anomaly_users = new Vector<>();
		int cont = 0;
		while (it.hasNext()) {
			User aux = it.next();
			for (int i = 0; i < media.getHist().length; i++) {
				distance += Math.pow((aux.getHist()[i] - media.getHist()[i]), 2);
			}

			distances[cont] = Math.sqrt(distance);
			distance = 0;
			cont ++;
		}
		
		double iqr = IQR(distances);
		cont = 0;
		it = lista.iterator();
		while (it.hasNext()) {
			User aux2 = it.next();
			for (int i = 0; i < media.getHist().length; i++) {
				distance += Math.pow((aux2.getHist()[i] - media.getHist()[i]), 2);
			}
			if (Math.sqrt(distance) > iqr) {
				Distance dis = new Distance(aux2, Math.sqrt(distance));
				anomaly_users.add(dis);
			}
			distance = 0;
			cont++;
		}
		order(anomaly_users);
		//System.out.println(anomaly_users);
		return anomaly_users;

	}

        /**
         * Calcular o IQR de um histograma.
         * 
         * @param hist histograma a ser calculado o iqr sobre ele.
         * @return valor correspondente ao iqr daquele histograma.
         */
	public double IQR(int[] hist) {

		DescriptiveStatistics da = new DescriptiveStatistics();
		double Q1 = hist[(hist.length + 1) / 4];
		double Q3 = hist[(3 * (hist.length + 1)) / 4];

		return Q3 - Q1;
	}

        /**
         * Calcular o IQR de uma lista com as distâncias.
         * 
         * @param distance Vetor das distancias em double.
         * @return valor correspondente ao iqr daquela lista.
         */
	public double IQR(double [] distance) {
		
		double [] data = distance;
		DescriptiveStatistics da = new DescriptiveStatistics(data);
		double iqr = da.getPercentile(75) - da.getPercentile(25);	
		return da.getPercentile(75) + (1.5 * (iqr));
	}
}
