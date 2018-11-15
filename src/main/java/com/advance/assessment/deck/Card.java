package com.advance.assessment.deck;

/**
 * Created by kgomotso on 2018/11/13.
 */
public class Card implements Comparable<Card>{
    private int number;
    private CardSuit suit;

    public enum CardSuit {
        HEARTS ("♥"),
        SPADES ("♠"),
        DIAMONDS ("♦"),
        CLUBS ("♣");

        private final String symbol;

        CardSuit(String s) {
            symbol = s;
        }
        public String toString() {
            return this.symbol;
        }
    }

    public Card(int number, CardSuit suit)
    {
        this.number=number;
        this.suit=suit;
    }

    /**
     * Changes card numbers to corresponding card symbol
     * @return
     */
    public String getSymbol() {
        String stringNumber;
        switch (number){
            case 1: stringNumber = "A";
                break;
            case 11: stringNumber = "J";
                break;
            case 12: stringNumber = "Q";
                break;
            case 13: stringNumber = "K";
                break;
            default: stringNumber = String.valueOf(number);
        }
        return stringNumber;
    }


    public boolean isFollow(Card card) {
            return (this.getNumber() + 1 == card.getNumber());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.getNumber(),card.getNumber());
    }

    @Override
    public String toString() {
        return getSymbol() + suit.toString();
    }


}
