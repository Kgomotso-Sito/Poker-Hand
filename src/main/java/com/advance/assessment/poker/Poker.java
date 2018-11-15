package com.advance.assessment.poker;

import com.advance.assessment.shuffle.Shuffle;
import com.advance.assessment.deck.Card;
import com.advance.assessment.deck.Deck;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kgomotso on 2018/11/13.
 */
public abstract class Poker {

    @Autowired
    private Deck deckofCards;

    private Shuffle shuffle;
    protected Map<String, Integer> group;

    public Poker(Shuffle shuffle){
        this.shuffle = shuffle;
        deckofCards = new Deck();
    }

    public abstract ArrayList<Card> dealCards();

    /**
     * High Hand is when cards are not sequencial,
     * not matching numbers nor suits.
     * Return true when no hand has been made
     * @return
     */
    public abstract boolean isHighCard();

    /***
     * Check if cards follow each other sequentially
     * @param dealtCards
     * @return
     */
    public boolean isStraight(ArrayList<Card> dealtCards) {
        for (int i = 0; i < dealtCards.size() - 1; i++) {
            if (!dealtCards.get(i).isFollow(dealtCards.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
    /**
     * Evaluate if the hand is a flush
     * Any five cards of the same suit, but not in a sequence.
     * @param dealtCards
     * @return
     */
    public boolean isFlush(ArrayList<Card> dealtCards){
        for (int i = 0; i < dealtCards.size() - 1; i++) {
            if (!dealtCards.get(i).getSuit().equals(dealtCards.get(i+1).getSuit())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Evaluate if the hand is a royal flush, by checking if there's ace, if its a flush the check if cards follow each other
     * Royal flush is A, K, Q, J, 10, all the same suit.
     * @param dealtCards
     * @return
     */
    public boolean isRoyalFlush(ArrayList<Card> dealtCards) {
        if(dealtCards.get(0).getNumber() == 1 && isFlush(dealtCards)){
            for (int i = 1; i < dealtCards.size() - 1; i++) {
                if (!dealtCards.get(i).isFollow(dealtCards.get(i + 1))) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

    /***
     * Checks if hand is both straight and a flush
     * @param dealtCards
     * @return
     */
    public boolean isStraightFlush(ArrayList<Card> dealtCards)
    {
        return (isStraight(dealtCards) && isFlush(dealtCards));
    }

    public Card deal(){
        return deckofCards.getCards().remove(0);
    }

    public List<Card> shuffleCards(){
        return shuffle.shuffleCards(deckofCards.getCards());
    }

    public Shuffle getShuffle() {
        return shuffle;
    }

    public Deck getDeckofCards() {
        return deckofCards;
    }

    public void setDeckofCards(Deck deckofCards) {
        this.deckofCards = deckofCards;
    }

}
