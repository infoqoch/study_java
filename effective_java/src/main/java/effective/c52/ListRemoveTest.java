package effective.c52;

import org.junit.jupiter.api.Test;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListRemoveTest {
    @Test
    void test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list.remove(2) = " + list.remove(2)); // 인덱스 2로 동작한다.
        System.out.println("list.remove((Integer) 1) = " + list.remove((Integer) 1)); // Object인 값 Integer 1로 동작한다.
        System.out.println("list.toString() = " + list.toString());
    }

    void test2(){
//        final ObjectOutputStream objectOutputStream = new ObjectOutputStream();
//        objectOutputStream.writeInt(123);
//        objectOutputStream.writeByte();
    }
}
