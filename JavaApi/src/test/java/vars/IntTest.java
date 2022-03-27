package vars;

import org.junit.jupiter.api.Test;

public class IntTest {
    @Test
    void test(){
        int i1 = 10;
        int i2 = 01012341234;
        int i3 = 0x1234;

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2); // 136954524
        System.out.println("i3 = " + i3); // 4660
    }
}
