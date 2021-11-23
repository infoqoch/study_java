package iterator;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

class iteratorTest {

    @Test
    void foreach() {
        List<String> list = new ArrayList<>();
        list.add("kim");
        list.add("lee");
        list.add("kang");
        list.add("bae");

        list.forEach(System.out::println);
    }

    @Test
    void spliterator() {
        List<String> list = new ArrayList<>();
        list.add("kim");
        list.add("lee");
        list.add("kang");
        list.add("bae");

        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        while (spliterator1.tryAdvance(System.out::println)) ;
        System.out.println("====");
        while (spliterator2.tryAdvance(System.out::println)) ;
    }

    @Test
    void removeIf() {
        List<String> list = new ArrayList<>();
        list.add("kim");
        list.add("lee");
        list.add("kang");
        list.add("bae");

        list.removeIf(s -> s.startsWith("k"));

        System.out.println(list.toString());
    }

    @Test
    void sort() {
        List<String> list = new ArrayList<>();
        list.add("kim");
        list.add("lee");
        list.add("kang");
        list.add("bae");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        list.sort(compareToIgnoreCase.reversed());
        System.out.println(list.toString());
    }
}
