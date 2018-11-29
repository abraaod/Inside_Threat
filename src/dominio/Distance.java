package dominio;

public class Distance {

    User user;
    double distance;
    
    /**
     * Construtor da classe Distance
     * @param user objeto user
     * @param distance valor doublee representando a distância
     * */
    public Distance(User user, double distance) {
        this.user = user;
        this.distance = distance;
    }
    
    /**
     * Retorna o usuário
     * @return user
     * */
    public User getUser() {
        return user;
    }
    
    /**
     * Modifica o usuário
     * @param user User a ser modificado
     * */
    public void setUser(User user) {
        this.user = user;
    }
    
    /**
     * Retorna a distância
     * @return distance
     * */
    public double getDistance() {
        return distance;
    }
    
    /**
     * Modifica a distância
     * @param distance double a ser modificada
     * */
    public void setDistance(double distance) {
        this.distance = distance;
    }

}
