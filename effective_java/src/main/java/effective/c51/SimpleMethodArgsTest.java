package effective.c51;

import org.junit.jupiter.api.Test;

import java.util.List;

public class SimpleMethodArgsTest {
    @Test
    void split_method(){
        final List<Integer> list = List.of(1, 2, 3, 4, 5);

//        list.subListAndGetIndexOf(1,4,1);

        final List<Integer> newList = list.subList(1, 4); // 1부터 4번째 값(2,3,4)를 꺼낸다.
        final Integer target = newList.get(1); //2,3,4 중 두 번째 값인 3을 꺼낸다.
        System.out.println("target = " + target);
    }


    String suit;
    String rank;

    @Test
    void card_game(){
        setGame("diamond", "6");
        boolean isCorrect = guessCard("heart", "7");
    }

    private boolean guessCard(String suit, String rank) {
        if(this.suit != suit) return false;
        if(this.rank != rank) return false;
        return true;
    }

    private void setGame(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Test
    void card_game_2(){
        Card setupCard = new Card(CardSuit.DIAMON, CardRank.SIX);
        CardGame game = new CardGame(setupCard);

        boolean isCorrect = game.guessCard(new Card(CardSuit.HEART, CardRank.SEVEN));
    }

    private class Card {
        public Card(CardSuit diamon, CardRank six) {
        }
    }

    private class CardGame {
        public CardGame(Card setupCard) {
        }

        public boolean guessCard(Card card) {
            return true;
        }
    }
}
