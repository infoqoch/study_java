package vars;

import org.junit.jupiter.api.Test;

public class PrimiTest {
    @Test
    void test(){
        long l1 = 123l;
        long l2 = 123;
        float f1 = 123.123f;
        // float f2 = 123.123;
        double d1 = 2134.4235d;
        double d2 = 1231.34534;
    }

    @Test
    void testOperator(){
        byte b1 = '1';
        byte b2 = 'A';
        int result = b1 + b2;
        System.out.println("result = " + result);
    }
}
