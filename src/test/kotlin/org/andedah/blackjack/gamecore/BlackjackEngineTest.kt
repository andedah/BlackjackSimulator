package org.andedah.blackjack.gamecore

import org.andedah.blackjack.gamecore.Suit.CLUBS
import org.andedah.blackjack.gamecore.Suit.DIAMONDS
import org.andedah.blackjack.gamecore.Suit.HEARTS
import org.andedah.blackjack.gamecore.Suit.SPADES
import org.andedah.blackjack.gamecore.Value.ACE
import org.andedah.blackjack.gamecore.Value.FOUR
import org.andedah.blackjack.gamecore.Value.JACK
import org.andedah.blackjack.gamecore.Value.NINE
import org.andedah.blackjack.gamecore.Value.SEVEN
import org.andedah.blackjack.gamecore.Value.SIX
import org.andedah.blackjack.gamecore.Value.TEN
import org.andedah.blackjack.gamecore.Value.THREE
import org.andedah.blackjack.gamecore.Value.TWO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BlackjackEngineTest {

  @Test
  fun `player should win if initial score is 21`() {
    val game =
        BlackjackEngine(
            Deck(
                listOf(
                    Card(ACE, SPADES), Card(TEN, SPADES), Card(TWO, SPADES), Card(THREE, SPADES))))
    assertEquals(Winner.PLAYER, game.playGame().winner)
  }

  @Test
  fun `player should win if player and dealer initial scores are 21`() {
    val game =
        BlackjackEngine(
            Deck(listOf(Card(ACE, SPADES), Card(TEN, SPADES), Card(ACE, CLUBS), Card(TEN, CLUBS))))
    assertEquals(Winner.PLAYER, game.playGame().winner)
  }

  @Test
  fun `dealer should win if player and dealer initial scores are 22`() {
    val game =
        BlackjackEngine(
            Deck(
                listOf(
                    Card(ACE, SPADES), Card(ACE, DIAMONDS), Card(ACE, CLUBS), Card(ACE, HEARTS))))
    assertEquals(Winner.DEALER, game.playGame().winner)
  }

  @Test
  fun `dealer should win if player busts`() {
    val game =
        BlackjackEngine(
            Deck(
                listOf(
                    Card(TWO, SPADES),
                    Card(TEN, SPADES),
                    Card(TWO, SPADES),
                    Card(THREE, SPADES),
                    Card(JACK, SPADES))))
    assertEquals(Winner.DEALER, game.playGame().winner)
  }

  @Test
  fun `player should win if dealer busts`() {
    val game =
        BlackjackEngine(
            Deck(
                listOf(
                    Card(NINE, SPADES),
                    Card(TEN, SPADES),
                    Card(NINE, CLUBS),
                    Card(NINE, DIAMONDS),
                    Card(JACK, SPADES))))
    assertEquals(Winner.PLAYER, game.playGame().winner)
  }

  @Test
  fun `dealer should win with 19 vs 17`() {
    val game =
        BlackjackEngine(
            Deck(
                listOf(
                    Card(SEVEN, SPADES),
                    Card(TEN, SPADES),
                    Card(NINE, CLUBS),
                    Card(SIX, DIAMONDS),
                    Card(FOUR, SPADES))))
    assertEquals(Winner.DEALER, game.playGame().winner)
  }
}
