package DataAndStatickClasses;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class NavigationTree implements Cloneable, Serializable, Comparable {

    private File mainFile;
    private int index;
    private int length;
    private String mainPath;


    public NavigationTree(String mainPath) {
        this.mainPath = mainPath;
        this.mainFile = new File(mainPath);
        this.length = getLengthWithoutHidden();
        this.index = 0;
    }

    public void init(File mainFile) {
        this.mainFile = mainFile;
        this.length = getLengthWithoutHidden();
        this.index = 0;
    }

    static void printYellow(String string) {
        System.out.println(String.format("\033[33m%s\033", string));
    }
    static void printGreen(String string) {
        System.out.println(String.format("\033[32;1;2m%s\033", string));
    }

    public void incIndex() {
        index++;
        if (length == index) index = 0;
    }

    public void decIndex() {
        index--;
        if (index == -1) index = length - 1;
    }

    public void print() {
        clearScreen();
        int cnt = 0;
        for (File fileEntry : mainFile.listFiles()) {
            if(!fileEntry.isHidden()){
                if (cnt++ == index) {
                    printYellow(fileEntry.getName());
                }else {
                    printGreen(fileEntry.getName());
                }
            }
        }
    }

    public int execute() {
        String first = null;
        for(File fileEntry : mainFile.listFiles()) {
            if (!fileEntry.isHidden()) {
                first = fileEntry.getName();
            }
        }
        if (first == null) {
            return -1;
        }
        if (first.matches("\\d+")) {
            return Integer.parseInt(first);
        }
        return -1;
    }

    private static void clearScreen() {
        for(int i = 0; i < 100; ++i) System.out.println();
    }
    public void getDown() {
        int cnt = 0;
        for(File fileEntry : mainFile.listFiles()) {
            if (fileEntry.isHidden()) continue;
            if (cnt++ == index) {
                init(fileEntry);
                return;
            }
        }
    }

    private int getLengthWithoutHidden() {
        int cnt = 0;
        for(File fileEntry : mainFile.listFiles()) {
            if(fileEntry.isHidden()) continue;
            cnt++;
        }
        return cnt;
    }

    public void getParent() {
        if (mainPath.equals(mainFile.getPath())) return;
        init(mainFile.getParentFile());
    }

    public File getMainFile() {
        return mainFile;
    }

    public void setMainFile(File mainFile) {
        this.mainFile = mainFile;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMainPath() {
        return mainPath;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NavigationTree that = (NavigationTree) o;
        return index == that.index &&
                length == that.length &&
                Objects.equals(mainFile, that.mainFile) &&
                Objects.equals(mainPath, that.mainPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainFile, index, length, mainPath);
    }

    @Override
    public String toString() {
        return "NavigationTree{" +
                "mainFile=" + mainFile +
                ", index=" + index +
                ", length=" + length +
                ", mainPath='" + mainPath + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
