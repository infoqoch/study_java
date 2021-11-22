package function;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleFunctionTest {
    @Test
    void functionalInterface_and_익명내부클래스(){
        FunctionalInterfaceConsumer function = new FunctionalInterfaceConsumer() {
            @Override
            public void execute() {
                System.out.println("함수");
            }
        };
        function.execute();

        FunctionalInterfaceConsumer lambda = () -> System.out.println("람다");
        lambda.execute();
    }

    @Test
    @DisplayName("함수형 프로그램은 입력한 값이 같으면 계속 동일한 리턴을 보장해야 한다. 그러니까 함수 안에서 외부의 값을 참조할 때")
    void 수학적함수(){
        FunctionalInterfaceFunction function = i ->  i + 100;
        int result1 = function.execute(10);
        int result2 = function.execute(10);

        Assertions.assertThat(result1).isEqualTo(result2);
    }

    @Test
    void 수학적함수가아니다1(){
        int external = 123;
        FunctionalInterfaceFunction function = i ->  i + external;
        int result1 = function.execute(10);
//        external = 566; 불가능. 자동적으로 외부 값은 final이 된다.
        int result2 = function.execute(10);

        Assertions.assertThat(result1).isEqualTo(result2);
    }
    @Test
    void 수학적함수가아니다2(){

        FunctionalInterfaceFunction function = new FunctionalInterfaceFunction() {
            public int external = 123; // 문법적으로 가능하지만 순수한 함수평 프로그래밍 pure function 으로 볼 수 없다. 그러나 외부 변수를 참조하는 것이 나쁜지는 음 고민해봐야겠지.
            @Override
            public int execute(int value) {
                return value+external;
            }
        };

        int result1 = function.execute(10);
        int result2 = function.execute(10);

        Assertions.assertThat(result1).isEqualTo(result2);
    }

}
