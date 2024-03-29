import java.util.*;
public class StaticTest_MemoryLeaks {
    public static List<Double> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) {
        System.out.println("Debug Point 1");
        new StaticTest_MemoryLeaks().populateList();
        System.out.println("Debug Point 3");
        Map<Person, Integer> map = new HashMap<>();
        for(int i=0; i<100; i++) {
            map.put(new Person("jon"), 1);
        }
    }
    static class Person{
        String name;
        Person(String name){
            this.name = name;
        }
    }
}
