package vars;

import org.junit.jupiter.api.Test;

import javax.lang.model.SourceVersion;

public class CastTest {
    @Test
    void promotion(){
        byte b1 = 12;
        int i1 = b1;
        System.out.println("i1 = " + i1);
    }

    @Test
    void cast(){
        int i1 = 1234;
        byte b1 = (byte) i1;
        System.out.println("b1 = " + b1);

        int i2 = 1231231238;
        byte b2 = (byte) i2;
        System.out.println("b2 = " + b2);
        System.out.println("Integer.toBinaryString(i2) = " + Integer.toBinaryString(i2));  // 마지막 8자리 00000110
        System.out.println("Integer.toBinaryString(b2) = " + Integer.toBinaryString(b2));  // 110
    }
}
