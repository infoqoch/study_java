package operation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OverflowSafetyOperationTest {
    @Test
    @DisplayName("덧샘, 정상")
    void add(){
        final int result = Math.addExact(123, 234);
        Assertions.assertThat(result).isEqualTo(357);
    }

    @Test
    @DisplayName("덧셈, 오버플로우")
    void add_overflow(){
        Assertions.assertThatThrownBy(()->{
            Math.addExact(Integer.MAX_VALUE, 1);
        }).isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("곱셈, 정상")
    void multi(){
        final int multi = Math.multiplyExact(10, 6);
        Assertions.assertThat(multi).isEqualTo(60);
    }
    
    @Test
    @DisplayName("곱셈, 오버플로우")
    void multi_overflow(){
        Assertions.assertThatThrownBy(()->{
            Math.multiplyExact(Integer.MAX_VALUE/5, 6);
        }).isInstanceOf(ArithmeticException.class);
    }
}
