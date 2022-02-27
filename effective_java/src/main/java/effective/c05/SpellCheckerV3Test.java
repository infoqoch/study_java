package effective.c05;

import org.junit.jupiter.api.Test;

class SpellCheckerV3Test {
    @Test
    void test(){
        Lexicon dictionary = new Lexicon();
        SpellCheckerV3 spellCheckerV3 = new SpellCheckerV3(dictionary);
        final boolean kim = spellCheckerV3.isValid("kim");
        System.out.println("kim = " + kim);
    }
}