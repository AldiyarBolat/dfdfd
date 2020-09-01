package DataAndStatickClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Log implements Serializable, Cloneable, Comparable {
    private Date time;
    private String action;

    public Log(String action) {
        this.time = new Date();
        this.action = action;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Log{" +
                "time=" + time +
                ", action='" + action + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(time, log.time) &&
                Objects.equals(action, log.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, action);
    }
}
