package org.andedah.blackjack.gamecore

class Deck(cards: List<Card>) {
  private val _cards: MutableList<Card> = cards.toMutableList()
  val cards
    get() = _cards.toList()

  fun dealCards(amount: Int = 1): List<Card> = (0 until amount).map { _cards.removeFirst() }

  companion object {
    fun build() = Deck(buildCardList())
    fun buildShuffled() = Deck(buildCardList().shuffled())
    private fun buildCardList() =
        Suit.values().flatMap { suit -> Value.values().map { value -> Card(value, suit) } }
  }
}

data class Card(val value: Value, val suit: Suit) {
  constructor(
      shortname: String
  ) : this(
      suit = Suit.fromLabel(shortname.first().toString()),
      value = Value.fromLabel(shortname.last().toString()))
}

enum class Value(val label: String, val points: Int) {
  TWO("2", 2),
  THREE("3", 3),
  FOUR("4", 4),
  FIVE("5", 5),
  SIX("6", 6),
  SEVEN("7", 7),
  EIGHT("8", 8),
  NINE("9", 9),
  TEN("10", 10),
  JACK("J", 10),
  QUEEN("Q", 10),
  KING("K", 10),
  ACE("A", 11);

  companion object {
    private val labelMap: Map<String, Value> = values().associateBy { it.label }
    fun fromLabel(label: String) =
        labelMap[label] ?: throw RuntimeException("Invalid value label: $label")
  }
}

enum class Suit(val label: String) {
  CLUBS("C"),
  DIAMONDS("D"),
  HEARTS("H"),
  SPADES("S");

  companion object {
    private val labelMap: Map<String, Suit> = values().associateBy { it.label }
    fun fromLabel(label: String) =
        labelMap[label] ?: throw RuntimeException("Invalid suit label: $label")
  }
}
