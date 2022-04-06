package operation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Overflow2Test {
    @Test
    @DisplayName("덧셈의 바이트 환산 및 오버플로우 확인")
    void add_overflow() {
        final int maxOf8bit = Integer.parseInt("11111111", 2);
        System.out.println("Integer.toBinaryString(maxOf8bit*2).length() = " + Integer.toBinaryString(maxOf8bit * 2).length());

        final int minOf8bit = Integer.parseInt("10000000", 2);
        System.out.println("Integer.toBinaryString(minOf8bit*2).length() = " + Integer.toBinaryString(minOf8bit * 2).length());
    }

    @Test
    @DisplayName("곱셈의 바이트 환산 및 오버플로우 확인")
    void multi_overflow() {
        final int maxOf8bit = Integer.parseInt("11111111", 2);
        System.out.println("Integer.toBinaryString(maxOf8bit * maxOf8bit).length() = " + Integer.toBinaryString(maxOf8bit * maxOf8bit).length());

        final int minOf8bit = Integer.parseInt("10000000", 2);
        System.out.println("Integer.toBinaryString(minOf8bit * minOf8bit).length() = " + Integer.toBinaryString(minOf8bit * minOf8bit).length());
    }
    
    @Test
    @DisplayName("Integer.parseInt()가 표현할 수 있는 이진수의 최대값")
    void parseIntTest(){
        Integer.parseInt("01111111111111111111111111111111", 2); // 문자가 32개인 문자열이다.
//        Integer.parseInt("11111111111111111111111111111111", 2); // 예외가 발생한다.
        int a = Integer.parseUnsignedInt("11111111111111111111111111111111", 2); // 예외가 발생한다.
        System.out.println(a);
    }


    @Test
    void test(){
        System.out.println(-Integer.MAX_VALUE);
        System.out.println("Integer.toBinaryString(-Integer.MAX_VALUE) = " + Integer.toBinaryString(-Integer.MAX_VALUE));

    }
}
