package operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FloatPointTest {
    @Test
    @DisplayName("부동소수점을 무시한 상태에서 비교한다")
    void compareTest(){
        double d = 2.1d;
        float f = 2.1f;
        System.out.println("d==f = " + (d==f)); // false
        System.out.println("((float)d==f) = " + ((float)d==f)); // true
        System.out.println("(d==(double)f) = " + (d == (double) f)); // false

        System.out.println("(long) Float.parseFloat(\"01111111011111111111111111111111\") = " + (long) Float.parseFloat("01111111011111111111111111111111"));
        System.out.println("Float.parseFloat(\"01111111011111111111111111111111\") = " + Float.parseFloat("01111111011111111111111111111111"));
        System.out.println("Math.pow(1.111111*10, 31) = " + Math.pow(1.111111*10, 31));
        System.out.println("Math.pow(4,7) = " + Math.pow(4,7));


    }
}
