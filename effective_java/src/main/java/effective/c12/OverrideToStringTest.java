package effective.c12;

import org.junit.jupiter.api.Test;

class OverrideToStringTest {

    @Test
    void test(){
        final OverrideToString kim = OverrideToString
                .builder()
                .name("kim")
                .age(14)
                .school("kimho high-school")
                .build();

        System.out.println("kim = " + kim.toString());
    }
}