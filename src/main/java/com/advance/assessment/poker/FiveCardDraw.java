package com.advance.assessment.poker;

import com.advance.assessment.utility.PokerUtil;
import com.advance.assessment.shuffle.Shuffle;
import com.advance.assessment.deck.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by kgomotso on 2018/11/13.
 */
public class FiveCardDraw extends Poker {

    private final short NOCARDS = 5;
    private static final Logger logger = LoggerFactory.getLogger(Logger.class);
    private Map<String, Long> groups;
    private String hand;


    public ArrayList<Card> dealtCards;

    public FiveCardDraw(Shuffle shuffle){
        super(shuffle);
        dealtCards = new ArrayList<>(NOCARDS);
        groups = new HashMap<>();
    }

    @Override
    public ArrayList<Card> dealCards(){
        for (int i = 0; i < NOCARDS; i++) {
            try {
                dealtCards.add(deal());
            }
            catch (IndexOutOfBoundsException e){
                logger.warn("This deck empty");
                break;
            }
        }
        prepareCards();
        return dealtCards;
    }

    /**
     * Sort cards in ascending order
     * as well deduce the number groups in a hand i.e pairs, group 3
     */
    public void prepareCards(){
        dealtCards = PokerUtil.sortCards(dealtCards);
        groups = PokerUtil.groupCards(dealtCards);
    }

    @Override
    public boolean isHighCard() {
        return (evaluateStrength().equals("High Card"));
    }

    /**
     *
     * @return
     */
    public boolean isFourOfAKind(){
        return (groups.containsValue(4L));
    }

    public boolean isFullHouse(){
        return (groups.containsValue(3L) && groups.containsValue(2L));
    }

    public boolean isThreeOfAKind(){
        return (groups.containsValue(3L));
    }

    /**
     * Gets the number of pairs in a hand
     * @return
     */
    public int getNoOfPair(){
        int dups = 0;
        for (Map.Entry<String, Long> entry : groups.entrySet()) {
            if(entry.getValue() == 2L) {
                dups++;
            }
        }
        return dups;
    }

    public boolean isTwoPair(){
        return (getNoOfPair() == 2);
    }

    public boolean isPair(){
        return (getNoOfPair() == 1);
    }


    /**
     * Find clean and effecient solution
     * @return
     */
    public String evaluateStrength() {
        if(isRoyalFlush(dealtCards)) {
            hand = "Royal Flush";
        }
        else if(isStraightFlush(dealtCards)) {
            hand = "Straight Flush";
        }
        else if(isFourOfAKind()) {
            hand = "Four Of A Kind";
        }
        else if(isFullHouse()) {
            hand = "Full House";
        }
        else if(isFlush(dealtCards)) {
            hand = "Flush";
        }
        else if(isStraight(dealtCards)) {
            hand = "Straight";
        }
        else if(isThreeOfAKind()) {
            hand = "Straight";
        }
        else if(isTwoPair()) {
            hand = "Two Pair";
        }
        else if(isPair()) {
            hand = "Pair";
        }
        else {
            hand = "High Card";
        }
        return hand;
    }


    public ArrayList<Card> getDealtCards() {
        return dealtCards;
    }

    public void setDealtCards(ArrayList<Card> dealtCards) {
        this.dealtCards = dealtCards;
    }

    @Override
    public String toString() {
        return dealtCards.toString().replaceAll(", ", " ");
    }

    public String showHand() {
       return dealtCards.toString().replace(" ,", " ")  //replace the commas with spaces
               .replace("[", "")  //remove the right bracket
               .replace("]", ""); //remove the left bracket
    }



}
