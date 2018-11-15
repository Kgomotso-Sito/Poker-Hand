package com.advance.assessment.shuffle;

import com.advance.assessment.deck.Card;
import java.util.List;

/**
 * Created by kgomotso on 2018/11/13.
 */
public interface Shuffle {
    List<Card> shuffleCards(List<Card> cards);
}
