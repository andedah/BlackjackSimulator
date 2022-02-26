package org.andedah.blackjack.gamecore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DeckTest {

  @Test
  fun `build deck and check deck size`() {
    val deck = Deck.build()
    assertEquals(52, deck.cards.size)
  }

  @Test
  fun `build deck and check suit distribution`() {
    val deck = Deck.build()
    val spades = deck.cards.filter { it.suit == Suit.SPADES }
    val clubs = deck.cards.filter { it.suit == Suit.CLUBS }
    val hearts = deck.cards.filter { it.suit == Suit.HEARTS }
    val diamonds = deck.cards.filter { it.suit == Suit.DIAMONDS }
    assertEquals(13, spades.size)
    assertEquals(13, clubs.size)
    assertEquals(13, hearts.size)
    assertEquals(13, diamonds.size)
  }

  @Test
  fun `build deck and check value distribution`() {
    val deck = Deck.build()
    val spades = deck.cards.filter { it.suit == Suit.SPADES }
    assertTrue(spades.map { it.value }.containsAll(Value.values().asList()))
  }

  @Test
  fun `build shuffled and unshuffled deck and check equality`() {
    val deck = Deck.build()
    val shuffledDeck = Deck.buildShuffled()
    assertTrue(deck.cards.containsAll(shuffledDeck.cards))
  }

  @Test
  fun `deal hand and check remaining deck size`() {
    val handSize = 2
    val deck = Deck.buildShuffled()
    val hand = deck.dealCards(handSize)
    assertEquals(handSize, hand.size)
    assertEquals(50, deck.cards.size)
  }
}
