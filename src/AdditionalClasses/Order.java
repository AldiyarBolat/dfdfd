package AdditionalClasses;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Cloneable, Serializable, Comparable {
    private boolean done;
    private String orderName;

    public Order(boolean done, String orderName) {
        this.done = done;
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return done == order.done &&
                Objects.equals(orderName, order.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(done, orderName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "done=" + done +
                ", orderName='" + orderName + '\'' +
                '}';
    }




}
