package generic;

import org.junit.jupiter.api.Test;

public class GenericTest {
    @Test
    void genericIntegerTest() {
        GenericList<Integer> list = new GenericList<>();
        list.add(123);
        list.add(452);
        list.clear();
        int size = list.size();
        System.out.println("size : " + size);
        list.add(23482348);
        Integer target = list.get(0);
        System.out.println("target : " + target);
    }

    @Test
    void genericStringTest() {
        GenericList<String> list = new GenericList<>();
        list.add("3");
        list.add("hi");
        list.clear();
        int size = list.size();
        System.out.println("size : " + size);
        list.add("안녕");
        String target = (String) list.get(0);
        System.out.println("target : " + target);
    }

    @Test
    void objectTest() {
        ObjectList list = new ObjectList();
        list.add(3);
        list.add(5);
        list.clear();
        int size = list.size();
        System.out.println("size : " + size);
        list.add(7);
        int num = (Integer) list.get(0);
        System.out.println("num : " + num);
    }

    @Test
    void intTest() {
        IntList list = new IntList();
        list.add(3);
        list.add(5);
        list.clear();
        int size = list.size();
        System.out.println("size : " + size);
        list.add(7);
        int num = list.get(0);
        System.out.println("num : " + num);
    }
}
