package com.advance.assessment;

import com.advance.assessment.poker.FiveCardDraw;
import com.advance.assessment.shuffle.KnuthShuffle;
import com.advance.assessment.shuffle.Shuffle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {

			FiveCardDraw fiveCardDraw = context.getBean(FiveCardDraw.class);
			fiveCardDraw.shuffleCards();
			while(!fiveCardDraw.getDeckofCards().getCards().isEmpty()) { //TODO Remove after testing
				fiveCardDraw.dealCards();
				System.out.println("Your hand :" + fiveCardDraw.showHand());
				System.out.println("Your have :" + fiveCardDraw.evaluateStrength());
				fiveCardDraw.dealtCards.clear(); //TODO Remove after testing
			}
		};
	}

}
