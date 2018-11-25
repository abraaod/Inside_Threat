package dominio;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Abraao
 */
public class Analyzer {

    /** Cria diagrama de usuário analisando os dispositivos.
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

    /** Definir a porcentagem do diagrama.
     * 
     * @param hist recebe os valores do histograma.
     * @return retorna o novo valor após a conversão.
     */
    public int[] percentageDiagram(int[] hist) {
        int sum = 0;
        for (int i = 0; i < hist.length; i++) {
            sum += hist[i];
        }
        for (int i = 0; i < hist.length; i++) {
            hist[i] = ((hist[i] * 100) / sum);
        }
        return hist;
    }

    /** Cria um histograma por dispositivo.
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

    /** Realiza uma analise por categoria.
     * 
     * @param lista_user Lista com os todos os usuários.
     * @param category qual categoria a ser analisada.
     * @param type Verdadeiro se deve considerar a categoria ou falso uma data (ou intervalo de datas).
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
}
