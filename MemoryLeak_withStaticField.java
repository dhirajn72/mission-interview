import java.util.*;

public class MemoryLeak_withStaticField {
    public static List<Double> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 50000000; i++) {
            list.add(Math.random());
        }
    }

    public static void main(String[] args) {
        new MemoryLeak_withStaticField().populateList();
        while(true){
        }
    }
}
