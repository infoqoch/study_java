package effective.c02;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

class PizzaTest {

    enum City {SEOUL, BUSAN, DAEGU}

    @Test
    void test(){
        final EnumSet<City> cities = EnumSet.noneOf(City.class);
        System.out.println("cities = " + cities);
    }



}