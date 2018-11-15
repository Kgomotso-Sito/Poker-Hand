package com.advance.assessment;

import com.advance.assessment.deck.Deck;
import com.advance.assessment.poker.FiveCardDraw;
import com.advance.assessment.poker.Poker;
import com.advance.assessment.shuffle.KnuthShuffle;
import com.advance.assessment.shuffle.Shuffle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kgomotso on 2018/11/15.
 */
@Configuration
public class AppConfig {
    @Bean
    public Poker fiveCardDraw() {
        return new FiveCardDraw(knuthShuffle());
    }

    @Bean
    public Shuffle knuthShuffle() {
        return new KnuthShuffle();
    }

    @Bean
    public Deck deck() {
        return new Deck();
    }
}
