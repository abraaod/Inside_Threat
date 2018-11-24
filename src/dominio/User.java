package dominio;

import java.util.HashMap;

public class User extends Node {

    private String name;
    private String domain;
    private String email;
    private String role;
    private Date date;
    private String start_date;
    private String end_date;

    /**
     * Default construct of the User class.
     *
     * @param name Name of the user.
     * @param id User identification.
     * @param domain What's the domain that the user use.
     * @param email Email of the user.
     * @param role what's the role of the user in the company.
     */
    public User(String name, String id, String domain, String email, String role) {
        super(id);
        this.name = name;
        this.domain = domain;
        this.email = email;
        this.role = role;
        date = null;
        start_date = null;
        end_date = null;
    }

    /**
     * Default construct of the User class.
     *
     * @param name Name of the user.
     * @param id User identification.
     * @param domain What's the domain that the user use.
     * @param email Email of the user.
     * @param role what's the role of the user in the company.
     * @param start_date Date that start the analysis.
     * @param end_date Date that end the analysis.
     */
    public User(String name, String id, String domain, String email, String role, String start_date, String end_date) {
        super(id);
        this.name = name;
        this.domain = domain;
        this.email = email;
        this.role = role;
        date = null;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    /**
     * Add a new date, using the dates informed on the construct or not.
     *
     * @param date_
     */
    public void addDate(Date date_) {
        if (start_date == null && end_date == null) {
            if (date == null) {
                date = new Date("aggregate", getId());
            }
        } else {
            if (date == null) {
                date = new Date(start_date + "-" + end_date, getId());
            }
        }
    }

    /**
     * Return name of the user.
     *
     * @return name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the user.
     *
     * @param name user's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the domain that the user use.
     *
     * @return name of the domain.
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Set the domain.
     *
     * @param domain name of the domain.
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * Return the email of the user.
     *
     * @return the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the user.
     *
     * @param email set the email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the role of the user on the company.
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", domain=" + domain + ", email=" + email + ", role=" + role + ", date=" + date + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }

    
}
