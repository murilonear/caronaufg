package caronaufg.android.com.caronaufg.model;

import java.util.Date;

public class TravelDriver {

    private String beginDriver;
    private String goalDriver;
    private Date dateDriver;
    private String time;
    private int numberPlaces;
    private double valueDriver;

    public TravelDriver() {
    }

    public String getBeginDriver() {
        return beginDriver;
    }

    public void setBeginDriver(String beginDriver) {
        this.beginDriver = beginDriver;
    }

    public String getGoalDriver() {
        return goalDriver;
    }

    public void setGoalDriver(String goalDriver) {
        this.goalDriver = goalDriver;
    }

    public Date getDateDriver() {
        return dateDriver;
    }

    public void setDateDriver(Date dateDriver) {
        this.dateDriver = dateDriver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }

    public double getValueDriver() {
        return valueDriver;
    }

    public void setValueDriver(double valueDriver) {
        this.valueDriver = valueDriver;
    }
}
