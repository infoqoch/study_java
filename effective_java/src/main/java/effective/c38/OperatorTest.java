package effective.c38;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

public class OperatorTest {
    @Test
    void test(){
        double x = 100d;
        double y = 50d;
        
        for(BasicOperation o :BasicOperation.values()){
            System.out.println("o.toString() = " + o.toString());
            System.out.println("o.apply(x,y) = " + o.apply(x,y));
            System.out.println();
        }

        for(ExtendedOperation o :ExtendedOperation.values()){
            System.out.println("o.toString() = " + o.toString());
            System.out.println("o.apply(x,y) = " + o.apply(x,y));
            System.out.println();
        }
    }

    // Enum 클래스를 받고, 해당 클래스를 values()로 루핑한다.
    private <T extends Enum<T> & Operation> void enumMethod
            (Class<T> opEnumType, double x, double y){
        for (Operation o : opEnumType.getEnumConstants()) {
            System.out.println("o.toString() = " + o.toString());
            System.out.println("o.apply(x,y) = " + o.apply(x,y));
            System.out.println();
        }
    }

    @Test
    void test2(){
        double x = 20d;
        double y = 80d;
        enumMethod(BasicOperation.class, x, y);
    }

    // 배열 (values())가 아닌 List 컬렉션을 받는다.
    // Operation 인터페이스로 받는다.
    private void collectionMethod(
            Collection<? extends Operation> opSet, double x, double y){
        for (Operation o : opSet) {
            System.out.println("o.toString() = " + o.toString());
            System.out.println("o.apply(x,y) = " + o.apply(x,y));
            System.out.println();
        }
    }

    @Test
    void test3(){
        double x = 30d;
        double y = 60d;
        collectionMethod(Arrays.asList(BasicOperation.values()), x, y);
    }
}

