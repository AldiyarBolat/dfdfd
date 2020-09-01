package DataAndStatickClasses;


import Users.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Session implements Serializable, Cloneable, Comparable {
    static final String mainPath = "src/ActionTreeText"; // TODO change path

    static public void start(User user) throws IOException {
        String path = mainPath;
        if (user instanceof Admin) path += "/Admin";
        if (user instanceof Teacher) path += "/Teacher";
        if (user instanceof ORManager) path += "/ORManager";
        if (user instanceof Student) path += "/Student";
        if (user instanceof TechSupport) path += "/TechSupportGuy";
        Scanner sc = new Scanner(System.in);
        NavigationTree navigationTree = new NavigationTree(path);
        navigationTree.print();
        while (true) {
            int key = read(sc);
            if (key == 0) continue;
            if (key == 1) navigationTree.decIndex();
            if (key == 2) navigationTree.incIndex();
            if (key == 3) navigationTree.getParent();
            if (key == 4) navigationTree.getDown();
            int executionValue = navigationTree.execute();
            if (executionValue == 0) {
                return;
            }
            if (executionValue != -1) {
                navigationTree.getParent();
                user.execute(executionValue);
                Data.saveData();
            }

            navigationTree.print();
        }



    }

    public static void clearScreen() {
        for(int i = 0; i < 100; i++) System.out.println();
    }

    static public int read(Scanner scanner) {
        String string = scanner.next();
        if (string.equals("w")) return 1;
        if (string.equals("s")) return 2;
        if (string.equals("a")) return 3;
        if (string.equals("d")) return 4;
        return 0;
    }

    public static String getMainPath() {
        return mainPath;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
