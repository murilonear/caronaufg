package caronaufg.android.com.caronaufg.model;

import java.sql.Time;
import java.util.Date;

public class TravelPassenger {
    private String beginPassenger;
    private String goalPassenger;
    private String datePassenger;
    private String timePassenger;

    public TravelPassenger() {
    }

    public String getBeginPassenger() {
        return beginPassenger;
    }

    public void setBeginPassenger(String beginPassenger) {
        this.beginPassenger = beginPassenger;
    }

    public String getGoalPassenger() {
        return goalPassenger;
    }

    public void setGoalPassenger(String goalPassenger) {
        this.goalPassenger = goalPassenger;
    }

    public String getDatePassenger() {
        return datePassenger;
    }

    public void setDatePassenger(String datePassenger) {
        this.datePassenger = datePassenger;
    }

    public String getTimePassenger() {
        return timePassenger;
    }

    public void setTimePassenger(String timePassenger) {
        this.timePassenger = timePassenger;
    }
}
