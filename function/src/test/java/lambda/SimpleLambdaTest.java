package lambda;

import function.FunctionImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.function.*;

public class SimpleLambdaTest {

    @Test
    void 자바함수를상속한펑션(){
        FunctionImpl function = new FunctionImpl();
        String result = function.apply("자갈치시장");
        System.out.println(result);
    }

    @Test
    void functionalInterface를_굳이_만들_필요는_없다(){
        Function<Float, Double> function = f -> Math.ceil(f);
        Double apply = function.apply(10.5f);
        System.out.println(apply);

        Consumer<String> consumer = s -> System.out.println("제 이름은 "+s+"입니다.");
        consumer.accept("김길동");

        Supplier<String> supplier = () -> LocalDateTime.now().toString();
        System.out.println(supplier.get());

        Predicate<String> predicate = s -> s.startsWith("서울");
        boolean truee = predicate.test("서울시 은평구");
        boolean falsee = predicate.test("부산시 자갈치구");
        Assertions.assertThat(truee).isTrue();
        Assertions.assertThat(falsee).isFalse();
    }

    @Test
    void 함수를_연결한다(){
        BiFunction<Float, Float, Double> biFunction = (f1, f2) -> Math.ceil(f1*f2);
        Function<Double, String> consumer = d -> "결과는 "+d+"입니다.";
        String apply = biFunction.andThen(consumer).apply(234.4f, 32.234f);
        System.out.println(apply);
    }
}
