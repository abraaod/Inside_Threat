package dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class Activity extends Node {
    
    private String date;
    private String hour;
    private String user;
    private String device;

    /** Activity of the user on the system.
     * 
     * @param id activity identification.
     * @param date hour of the event (or activity in this case).
     * @param hour hour of the event.
     * @param user the user of that event.
     * @param device the device used.
     */
    public Activity(String id, String date, String hour, String user, String device) {
        super(id);
        this.date = date;
        this.hour = hour;
        this.user = user;
        this.device = device;
    }

    /** Return the date of the event.
     * 
     * @return return the date.
     */
    public String getDate() {
        return date;
    }

    /** Set the date of the event.
     * 
     * @param date set a date on the activity.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /** Return the hour of the event.
     * 
     * @return hour of the event.
     */
    public String getHour() {
        return hour;
    }

    /** Set a hour on the activity.
     * 
     * @param hour set a hour of the activity.
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /** Return the user of the activity.
     * 
     * @return the user of that activity.
     */
    public String getUser() {
        return user;
    }

    /** Set the user of the activity.
     * 
     * @param user Set the user of the activity.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /** Return the device of the activity;
     * 
     * @return return the name of the device of that activity.
     */
    public String getDevice() {
        return device;
    }

    /** Set the device of the activity.
     * 
     * @param device set the device of the activity.
     */
    public void setDevice(String device) {
        this.device = device;
    }
    
    
}
