package dominio;

public class Distance implements Comparable{
	
	User user;
	double distance;
	
	public Distance(User user, double distance){
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

    @Override
    public int compareTo(Object o) {
        
        Distance d = (Distance) o;
        
        if(this.distance < d.distance){
            return -1;
        } else if( this.distance == d.distance ){
            return 0;
        } else{
            return 1;
        }
    }
    
    
}
