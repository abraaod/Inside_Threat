package dominio;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Tree_insiders {

    HashMap<String, User> hash_user;

    /**
     * Construtor para à árvore. Inicializa o HashMap.
     *
     */
    public Tree_insiders() {
        hash_user = null;
    }

    /**
     * Insere um novo usuário na árvore.
     *
     * @param user usuário a ser adicionado.
     */
    public void insertUser(User user) {
        if (hash_user == null) {
            hash_user = new HashMap<>();
            hash_user.put(user.getId(), user);
        } else {
            hash_user.put(user.getId(), user);
        }
    }

    /**
     * Insere uma data na árvore.
     *
     * @param date Data a ser adicionada.
     */
    public void insertDate(Date date) {
        User user = hash_user.get(date.getUser());
        if (user != null) {
            user.addDate(date);
        }
    }

    /**
     * Insere um novo dispositivo na árvore.
     *
     * @param device Dispositivo a ser inserido.
     */
    public void insertDevice(Device device) {
        User user = hash_user.get(device.getUser());
        if (user != null) {
            Date date = user.getDate();
            if (date != null) {
                date.addDevice(device.getId(), device);
            }
        }
    }

    /**
     * Insere uma nova conexão de dispositivo.
     *
     * @param device Dispositivo utilizado.
     * @param hours horário em que ocorreu a inserção.
     */
    public void insertConnect(Device device, String hours) {
        User user = hash_user.get(device.getUser());
        if (user != null) {
            Date date = user.getDate();
            if (date != null) {
                if (date.getId().equals("aggregate")) {
                    date.getHash_table().get(device.getId()).addInput(device.getId(), true, hours);
                } else if (date.insideInterval(device.getDate())) {
                    date.getHash_table().get(device.getId()).addInput(device.getId(), true, hours);
                }
            }
        }
    }

    /**
     * Insere uma nova disconexão de dispositivo.
     *
     * @param device Dispositivo que foi disconectado.
     * @param hours Horário em que ocorreu a disconexão.
     */
    public void insertDisconnect(Device device, String hours) {
        User user = hash_user.get(device.getUser());
        if (user != null) {
            Date date = user.getDate();
            if (date != null) {
                if (date.getId().equals("aggregate")) {
                    date.getHash_table().get(device.getId()).addInput(device.getId(), false, hours);
                } else if (date.insideInterval(device.getDate())) {
                    date.getHash_table().get(device.getId()).addInput(device.getId(), false, hours);
                }
            }
        }
    }

    /**
     * Insere a ocorrencia de um logon.
     *
     * @param device Dispositivo em que ocorreu a ação.
     * @param hours Horário em que ocorreu o logon.
     */
    public void insertLogon(Device device, String hours) {
        User user = hash_user.get(device.getUser());
        if (user != null) {
            Date date = user.getDate();
            if (date != null) {
                if (date.getId().equals("aggregate")) {
                    date.getHash_table().get(device.getId()).addLogin(device.getId(), true, hours);
                } else if (date.insideInterval(device.getDate())) {
                    date.getHash_table().get(device.getId()).addLogin(device.getId(), true, hours);
                }
            }
        }
    }

    /**
     * Insere um nó correspondente ao logoff.
     *
     * @param device Dispositivo em que ocorreu o logoff.
     * @param hours Horário que ocorreu o logoff.
     */
    public void insertLogoff(Device device, String hours) {
        User user = hash_user.get(device.getUser());
        if (user != null) {
            Date date = user.getDate();
            if (date != null) {
                if (date.getId().equals("aggregate")) {
                    date.getHash_table().get(device.getId()).addLogin(device.getId(), false, hours);
                } else if (date.insideInterval(device.getDate())) {
                    date.getHash_table().get(device.getId()).addLogin(device.getId(), false, hours);
                }
            }
        }
    }

    /**
     * Inserir um nó com o acesso a uma URL.
     *
     * @param device Dispositivo que foi utilizado para acessar a URL.
     * @param url Url que foi acessada.
     * @param hours Horário que foi acessado.
     *
     */
    public void insertUrl(Device device, String url, String hours) {
        User user = hash_user.get(device.getUser());
        if (user != null) {
            Date date = user.getDate();
            if (date != null) {
                if (date.getId().equals("aggregate")) {
                    date.getHash_table().get(device.getId()).addHttp(device.getId(), url, hours);
                } else if (date.insideInterval(device.getDate())) {
                    date.getHash_table().get(device.getId()).addHttp(device.getId(), url, hours);
                }
            }
        }
    }

    /**
     *
     * Criar o diagrama com os dados dos histogramas.
     *
     */
    public Collection<User> createDiagram() {
        Analyzer analyzer = new Analyzer();
        Collection<User> lista_user = hash_user.values();
        Iterator<User> lista = lista_user.iterator();
        while (lista.hasNext()) {
            analyzer.createUserDiagram(lista.next());
        }
        return lista_user;
    }

    /**
     *
     * Retornar o hashmap com com id e o usuários.
     *
     * @return retorna a hashmap.
     */
    public HashMap<String, User> getHash_user() {
        return hash_user;
    }

    /**
     * Configurar uma hashmap nova/existente.
     *
     * @param hash_user HashMap com o id e o usuário.
     */
    public void setHash_user(HashMap<String, User> hash_user) {
        this.hash_user = hash_user;
    }

    /**
     * Retornar um usuário específico.
     *
     * @param search Identificador do usuário.
     * @return usuário encontrado.
     */
    public User getSpecificUser(String search) {
        return hash_user.get(search);
    }

    //Crated to analyzer User in a most refined way
    ////type true represents user groupping by role, false represents by date 
    /**
     * Realizar uma análise por categoria. Gerar o histograma por uma categoria
     * específica.
     *
     * @param category categoria escolhida para filtrar.
     * @param type Verdadeiro se for por categoria e false se for por data
     * específica.
     */
    public Vector<Distance> analyzerByCategory(String category, boolean type) {
        Analyzer analyzer = new Analyzer(this);
        //Collection<User> lista_user = hash_user.values();
        Vector<User>lista_user = analyzer.analyzerByCategory(category, type);
        Vector<Distance> distances = analyzer.findAnomaly(lista_user, category);
        
        return distances;
    }

    /**
     * Imprimir todas as chaves de todos os usuários.
     */
    public void users() {
        Collection<User> lista = hash_user.values();
        Iterator<User> users = lista.iterator();
        while (users.hasNext()) {
            User aux = users.next();
            System.out.println(aux.getId());
        }
        System.out.println(lista.size());
    }
    
    /**
     * Calcula a média de um determinado papel.
     * 
     * @param role Papel de uma empresa a ser calculada a média.
     */
    public User medianRoles(String role){
        User role_ = new User("", "Media", "", "", role);
        Collection<User> lista = hash_user.values();
        Iterator<User> users = lista.iterator();
        int qnt = 0;
        int[] hist = new int[24];
        
        while(users.hasNext()){
            User aux = users.next();
            if(aux.getRole().equals(role)){
                qnt++;
                for( int i = 0; i < aux.getHist().length; i++){
                    hist[i] += aux.getHist()[i];
                }
            }
        }
        if(qnt > 0) {
        	 for(int i = 0; i < hist.length; i++) {
             	hist[i] /= qnt;
             }
        }
        role_.setHist(hist);
        return role_;
    }
    
    
    
}
