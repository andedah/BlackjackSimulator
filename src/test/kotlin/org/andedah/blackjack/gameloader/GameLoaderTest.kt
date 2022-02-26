package org.andedah.blackjack.gameloader

import org.andedah.blackjack.gamecore.Card
import org.andedah.blackjack.gamecore.Suit.CLUBS
import org.andedah.blackjack.gamecore.Suit.DIAMONDS
import org.andedah.blackjack.gamecore.Suit.HEARTS
import org.andedah.blackjack.gamecore.Suit.SPADES
import org.andedah.blackjack.gamecore.Value.ACE
import org.andedah.blackjack.gamecore.Value.EIGHT
import org.andedah.blackjack.gamecore.Value.FIVE
import org.andedah.blackjack.gamecore.Value.NINE
import org.andedah.blackjack.gamecore.Value.QUEEN
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GameLoaderTest {

  @Test
  fun `load deck from file and check deck content`() {
    val expectedCards =
        listOf(
            Card(ACE, CLUBS),
            Card(FIVE, DIAMONDS),
            Card(NINE, HEARTS),
            Card(QUEEN, HEARTS),
            Card(EIGHT, SPADES),
        )
    val deck = loadGameDeck("/Users/andedah/work/Blackjack/src/test/resources/deck")

    assertTrue(deck.cards.containsAll(expectedCards))
  }
}
