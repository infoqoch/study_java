package basic.recursive;

import org.junit.jupiter.api.Test;

public class FactorialTest {
    @Test
    void 팩토리얼(){
        System.out.println(factorial(10));
    }

    private int factorial(int num){
        if(num<=0)
            return 1;
        return num*factorial(num-1);
    }

}
