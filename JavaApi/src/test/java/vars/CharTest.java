package vars;

import org.junit.jupiter.api.Test;

public class CharTest {
    @Test
    void test(){
        char c1 = 'A';
        System.out.println("c1 = " + c1);
        System.out.println("(byte) c1 = " + (byte) c1);
        System.out.println("(int) c1 = " + (int) c1);
        System.out.println("Integer.toHexString(c1) = " + Integer.toHexString(c1));
        System.out.println("Integer.toOctalString(c1) = " + Integer.toOctalString(c1));
        System.out.println("Integer.toBinaryString(c1) = " + Integer.toBinaryString(c1));
    }

    @Test
    void test2(){
        char c1 = 'A';
        char c2 = 65;
        char c3 = '\u0041';

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
    }
}
