package dominio;

public class Distance {

    User user;
    double distance;

    public Distance(User user, double distance) {
        this.user = user;
        this.distance = distance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
