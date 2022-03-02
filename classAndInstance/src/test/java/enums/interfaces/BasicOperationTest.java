package enums.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicOperationTest {

    @Test
    void test(){
        final double apply = BasicOperation.PLUS.apply(123, 54);
        System.out.println("apply = " + apply);
    }
}