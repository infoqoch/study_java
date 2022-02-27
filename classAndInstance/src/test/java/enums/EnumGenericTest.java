package enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumGenericTest {
    @Test
    void test(){
        EnumGeneric<Fruit> obj = new EnumGeneric<>();
        obj.setFruit(Fruit.APPLE);

        System.out.println("obj = " + obj);
    }
}