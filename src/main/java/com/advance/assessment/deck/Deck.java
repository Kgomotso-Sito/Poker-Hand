package com.advance.assessment.deck;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by kgomotso on 2018/11/13.
 */
public class Deck {

    private ArrayList<Card> cards;
    private final int NO_OF_CARDS_PER_SUIT = 13;

    public Deck() {
        cards = new ArrayList<>();
        Stream.of(Card.CardSuit.values()).forEach(cardSuit -> {
            for (int number = 1; number < NO_OF_CARDS_PER_SUIT + 1; number++) {
                cards.add(new Card(number, cardSuit));
            }
        });
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void showDeck() {
        cards.forEach(System.out::print);
        System.out.println();
    }

    @Override
    public String toString() {
        return cards.toString().replaceAll(", ", "");
    }
}