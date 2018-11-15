package com.advance.assessment.utility;

import com.advance.assessment.deck.Card;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kgomotso on 2018/11/13.
 */
public class PokerUtil {
    public static ArrayList<Card> sortCards(ArrayList<Card> cards){
         Collections.sort(cards);
        return cards;
    }

    public static Map<String, Long> groupCards(ArrayList<Card> dealtCards){
        Map<String, Long> counting = dealtCards.stream().collect(
                Collectors.groupingBy(Card::getSymbol, Collectors.counting()));
        return counting;
    }
}
