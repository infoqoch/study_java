package effective.c29;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackV2Test {
    @Test
    void test1(){
        // given
        StackV2<Integer> stack = new StackV2<>();

        // when
        stack.push(123);
        stack.push(456);

        //then
        Assertions.assertThat(stack.pop()+1).isEqualTo(456+1);
        Assertions.assertThat(stack.pop()+1).isEqualTo(123+1);
    }
}
