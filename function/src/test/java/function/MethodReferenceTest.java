package function;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

/*
* 매서드를 함수 인터페이스의 람다에 바로 사용할 수 있다. :: 와 함께
*/
class MethodReferenceTest {

    @Test
    void 매서드의_참조를_람다로_구현(){
        MethodRefer methodRefer = new MethodRefer();
        String hi = methodRefer.instanceMethod("hi");
        String hello = MethodRefer.staticMethod("hello");

        UnaryOperator<String> unaryOperator = MethodRefer::staticMethod;
        String result = unaryOperator.apply("with unaryOperator");
        System.out.println(result);
    }

    @Test
    void 매서드_참조의_다양한_방법들(){
        Supplier<String> supplier = ()->MethodRefer.staticMethod("with Supplier, It can't be lambda");
        String resultSupplier = supplier.get();
        System.out.println(resultSupplier);

        Supplier<MethodRefer> methodReferSupplier = MethodRefer::new;
        String result2 = methodReferSupplier.get().instanceMethod("Constructor called by Supplier");
        System.out.println(result2);

        Function<String, MethodRefer> referFunction = MethodRefer::new;
        MethodRefer instance = referFunction.apply((" with function and call constructor"));
    }

    @Test
    void 인스턴스를_참조한다(){
        //        @NotNull T[] a,
//        @Nullable java.util.Comparator<? super T> c
        String[] names = { "banana", "kiwi", "apple"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length1 = o1.length();
                int length2 = o2.length();
                if(length1>length2){
                    return 1;
                }else if(length1==length2){
                    return 0;
                }
                return -1;
            }
        });

        System.out.println(Arrays.toString(names));

        Arrays.sort(names, (o1, o2) -> {
            int char1 = o1.charAt(0);
            int char2 = o2.charAt(0);
            if(char1>char2){
                return -1;
            }else if(char1==char2){
                return 0;
            }
            return 1;
        });
        System.out.println(Arrays.toString(names));

        int bye = "hie".compareToIgnoreCase("bye");// 스트링을 비교하는 매서드

//        @NotNull T[] a,
//        @Nullable java.util.Comparator< super T?> c
        Arrays.sort(names, String::compareToIgnoreCase); // static 을 사용하는 것처럼 보이지만, 사실은 인스턴스매서드를 사용 중에 있다.
        System.out.println(Arrays.toString(names));
    }

    @Test
    void 매서드참조를_자유롭게_해보자(){
        Function<Long, String> referStaticMethod = String::valueOf; // static method 의 활용. String.valueOf(wrapper class, primitive type) => return String

        boolean h = "hi".startsWith("h");
        BiFunction<String,String,Boolean> referInstanceMethod1 = (s, s2) -> s.startsWith(s2);
        BiFunction<String,String,Boolean> referInstanceMethod2 = String::startsWith;

    }
}