package effective.c05;

import org.junit.jupiter.api.Test;

class SpellCheckerV2Test {
    @Test
    void test(){
        final SpellCheckerV2 instance = SpellCheckerV2.getInstance();
        final boolean kim = instance.isValid("kim");
        System.out.println("kim = " + kim);

    }

}