package com.advance.assessment;

/**
 * Created by kgomotso on 2018/11/14.
 */

import com.advance.assessment.deck.Card;
import com.advance.assessment.poker.FiveCardDraw;
import com.advance.assessment.shuffle.KnuthShuffle;
import com.advance.assessment.shuffle.Shuffle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.function.BiFunction;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPokerHands {
    private static final Logger logger = LoggerFactory.getLogger(TestPokerHands.class);

    public  static final Card.CardSuit DIAMONDS = Card.CardSuit.DIAMONDS;
    public  static final Card.CardSuit CLUBS = Card.CardSuit.CLUBS;
    public  static final Card.CardSuit SPADES = Card.CardSuit.SPADES;
    public  static final Card.CardSuit HEARTS = Card.CardSuit.HEARTS;

    /**
     * Helper function to create card instances
     */
    public static BiFunction<Integer, Card.CardSuit, Card> cardFactory = (number, suit) -> new Card(number, suit);

    /***
     * Semi Done
     */
    @Test
    public void testDeckIsRoyalFlush() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(11, DIAMONDS));
                add(cardFactory.apply(12, DIAMONDS));
                add(cardFactory.apply(1, DIAMONDS));
                add(cardFactory.apply(10, DIAMONDS));
                add(cardFactory.apply(13, DIAMONDS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a royal flush", poker.isRoyalFlush(poker.getDealtCards()));
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsStraightFlush() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(5, CLUBS));
                add(cardFactory.apply(6, CLUBS));
                add(cardFactory.apply(4, CLUBS));
                add(cardFactory.apply(7, CLUBS));
                add(cardFactory.apply(8, CLUBS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a straight flush", poker.isStraightFlush(poker.getDealtCards()));
    }

    @Test
    public void testDeckIsFourOfAKind() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(11, CLUBS));
                add(cardFactory.apply(11, HEARTS));
                add(cardFactory.apply(11, SPADES));
                add(cardFactory.apply(7, DIAMONDS));
                add(cardFactory.apply(11, DIAMONDS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not four of a kind", poker.isFourOfAKind());
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsFullHouse() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(10, DIAMONDS));
                add(cardFactory.apply(9, CLUBS));
                add(cardFactory.apply(10, DIAMONDS));
                add(cardFactory.apply(10, HEARTS));
                add(cardFactory.apply(9, DIAMONDS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a full house", poker.isFullHouse());
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsFlush() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(9, CLUBS));
                add(cardFactory.apply(8, CLUBS));
                add(cardFactory.apply(4, CLUBS));
                add(cardFactory.apply(11, CLUBS));
                add(cardFactory.apply(2, CLUBS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a flush", poker.isFlush(poker.getDealtCards()));
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsStraight() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(5, HEARTS));
                add(cardFactory.apply(8, DIAMONDS));
                add(cardFactory.apply(9, CLUBS));
                add(cardFactory.apply(7, SPADES));
                add(cardFactory.apply(6, DIAMONDS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a straight flush", poker.isStraight(poker.getDealtCards()));
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsThreeOfAKind() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(7, DIAMONDS));
                add(cardFactory.apply(7, CLUBS));
                add(cardFactory.apply(3, DIAMONDS));
                add(cardFactory.apply(7, SPADES));
                add(cardFactory.apply(13, CLUBS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not three of a kind", poker.isThreeOfAKind());
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsTwoPair() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(12, CLUBS));
                add(cardFactory.apply(4, SPADES));
                add(cardFactory.apply(4, CLUBS));
                add(cardFactory.apply(3, DIAMONDS));
                add(cardFactory.apply(3, CLUBS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a two pairs", poker.isTwoPair());
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsPair() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(4, SPADES));
                add(cardFactory.apply(1, HEARTS));
                add(cardFactory.apply(7, HEARTS));
                add(cardFactory.apply(1, DIAMONDS));
                add(cardFactory.apply(8, CLUBS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a  pair", poker.isPair());
    }

    /**
     * Semi done
     */
    @Test
    public void testDeckIsHighCard() {
        Shuffle shuffle = new KnuthShuffle();
        FiveCardDraw poker = new FiveCardDraw(shuffle);

        ArrayList<Card> cards = new ArrayList<Card>(5) {
            {
                add(cardFactory.apply(2, SPADES));
                add(cardFactory.apply(4, HEARTS));
                add(cardFactory.apply(3, DIAMONDS));
                add(cardFactory.apply(8, SPADES));
                add(cardFactory.apply(11, CLUBS));
            }
        };
        poker.setDealtCards(cards);
        poker.prepareCards();
        poker.showHand();
        assertTrue("Hand is not a high hand", poker.isHighCard());
    }


}
