package effective.c31;

import org.junit.jupiter.api.Test;

import java.util.*;

public class StackTest {
    @Test
    void test_pushAll(){
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        // numberStack.pushAll(integers);
        numberStack.pushAll2(integers);
    }

    @Test
    void test_popAll(){
        //given
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll2(integers);

        // when
        Collection<Object> obj = new ArrayList<>();
        // numberStack.popAll(obj);
        numberStack.popAll2(obj);
        
        // then
        for (Object o : obj) {
            System.out.println("o = " + o);
        }

    }
}
