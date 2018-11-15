package com.advance.assessment.shuffle;

import com.advance.assessment.deck.Card;

import java.util.Collections;
import java.util.List;

/**
 * Created by kgomotso on 2018/11/13.
 */
public class KnuthShuffle implements Shuffle {
    public List<Card> shuffleCards(List<Card> cards) {
        System.out.println("Shuffling... Shuffling... Shuffling...");
        int n = cards.size();
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            Collections.swap(cards, r,i);
        }
        return cards;
    }


}
