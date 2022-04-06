package operation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OverflowTest {
    @Test
    @DisplayName("덧샘의 바이트 환산 및 오버플로우 확인")
    void add_overflow() {
        final int i = Integer.parseInt("11111111", 2);
        System.out.println("Integer.toBinaryString (i*2) = " + Integer.toBinaryString(i * 2));
        // 111111110 이 된다.
        // 그런데 사실 자연수 간 덧샘의 오버플로우는 그것의 결과가 음수면 예외처리하면 된다. 간단한 듯?

        final int i2 = Integer.parseInt("10000000", 2);
        System.out.println("i2 = " + i2);
        System.out.println("(i2*2) = " + (i2 * 2));
        System.out.println("Integer.toBinaryString (i2*2) = " + Integer.toBinaryString(i2 * 2));
        // 곱하기 2를 할 경우 비트를 기준으로 한 자리가 무조건 올라간다.
        // 이 말은 곱하기 역시도 비트의 입장에서는 자릿수가 올라가는 상황일 수 있다는 점이다. 아닐 수도 있고
    }

    @Test
    @DisplayName("곱샘의 바이트 환산 및 오버플로우 확인")
    void multi_overflow() {
        System.out.println("(46340*46340) = " + (46340 * 46340));
        System.out.println("(46341*46341) = " + (46341 * 46341));
        System.out.println("(46341*46340) = " + (46341 * 46340));
        System.out.println("Integer.toBinaryString(46340) = " + Integer.toBinaryString(46340));
        System.out.println("Integer.toBinaryString(46341) = " + Integer.toBinaryString(46341));

        System.out.println("Integer.valueOf(\"10000000000000000\",2) = " + Integer.valueOf("10000000000000000",2));
        System.out.println("(Integer.valueOf(\"10000000000000000\",2)^2) = " + (Integer.valueOf("10000000000000000",2)*Integer.valueOf("10000000000000000",2)));
        System.out.println("(Integer.valueOf(\"10000000000000000\",2)*Integer.valueOf(\"10000000000000000\",2)-1) = " + (Integer.valueOf("10000000000000000",2)*Integer.valueOf("10000000000000000",2)-1));
        System.out.println("Integer.toBinaryString((Integer.valueOf(\"10000000000000000\",2)*Integer.valueOf(\"10000000000000000\",2)-1)) = " + Integer.toBinaryString((Integer.valueOf("10000000000000000",2)*Integer.valueOf("10000000000000000",2)-1)));
        System.out.println("Integer.parseInt(\"01111111111111111111111111111111\",2) = " + Integer.parseInt("01111111111111111111111111111111", 2));
        Assertions.assertThatThrownBy(()->{
            System.out.println("Integer.parseInt(\"11111111111111111111111111111111\",2) = " + Integer.parseInt("11111111111111111111111111111111", 2)); // http://zhtiansweet.github.io/Java-Unsigned-Integers/
        }).isInstanceOf(NumberFormatException.class);


        System.out.println("Integer.toBinaryString(Integer.parseInt(\"11111111\",2)*Integer.parseInt(\"11111111\",2)) = " + Integer.toBinaryString(Integer.parseInt("11111111", 2) * Integer.parseInt("11111111", 2)));
        System.out.println("Integer.toBinaryString(Integer.parseInt(\"11111111\", 2) * Integer.parseInt(\"11111111\", 2)).length() = " + Integer.toBinaryString(Integer.parseInt("11111111", 2) * Integer.parseInt("11111111", 2)).length());

        System.out.println("Integer.toBinaryString(Integer.parseInt(\"10000000\", 2) * Integer.parseInt(\"1000000\", 2)) = " + Integer.toBinaryString(Integer.parseInt("100000000", 2) * Integer.parseInt("10000000", 2)));
        System.out.println("Integer.toBinaryString(Integer.parseInt(\"100000000\", 2) * Integer.parseInt(\"10000000\", 2)).length() = " + Integer.toBinaryString(Integer.parseInt("100000000", 2) * Integer.parseInt("10000000", 2)).length());


        
    }
}
