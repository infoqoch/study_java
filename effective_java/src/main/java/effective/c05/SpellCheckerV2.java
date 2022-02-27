package effective.c05;

public class SpellCheckerV2 {
    private final Lexicon dictionary = new Lexicon();

    private static final SpellCheckerV2 INSTANCE = new SpellCheckerV2();

    private SpellCheckerV2(){}

    public static SpellCheckerV2 getInstance(){
        return INSTANCE;
    }

    public boolean isValid(String word){
        return dictionary.contains(word);
    }
}
