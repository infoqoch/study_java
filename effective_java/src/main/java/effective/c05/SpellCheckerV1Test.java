package effective.c05;

import org.junit.jupiter.api.Test;

class SpellCheckerV1Test {

    @Test
    void test(){
        final boolean kim = SpellCheckerV1.isValid("kim");
        System.out.println("kim = " + kim);
    }

}