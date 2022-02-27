package effective.c05;

public class SpellCheckerV3 {
    private final Lexicon dictionary;

    public SpellCheckerV3(Lexicon dictionary){
        this.dictionary = dictionary;
    }

    public boolean isValid(String word){
        return dictionary.contains(word);
    }
}
