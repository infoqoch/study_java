package enums;

import enums.generic.EnumGeneric;
import enums.generic.Fruit;
import org.junit.jupiter.api.Test;

class EnumGenericTest {
    @Test
    void test(){
        EnumGeneric<Fruit> obj = new EnumGeneric<>();
        obj.setFruit(Fruit.APPLE);

        System.out.println("obj = " + obj);
    }
}