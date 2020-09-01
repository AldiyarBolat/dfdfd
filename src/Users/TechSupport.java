package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TechSupport extends User {
    public static List<String> orders = new ArrayList<String>();
    public TechSupport(String login, String password) {
        super(login, password);
    }

    @Override
    public void execute(int value) {
        Scanner scanner = new Scanner(System.in);
        String order;
        if (value == 1) { // Accept orders
            orders.clear();
        }
        if (value == 2) { // View new orders
            for(String curOrder : orders) {
                System.out.println(curOrder);
            }
        }
    }

    public static void getOrders(String order) {
        orders.add(order);
    }

}
