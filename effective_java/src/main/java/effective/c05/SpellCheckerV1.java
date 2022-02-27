package effective.c05;

public class SpellCheckerV1 {
    private static final Lexicon dictionary = new Lexicon();

    public static boolean isValid(String word) {
        return dictionary.contains(word);
    }
}
