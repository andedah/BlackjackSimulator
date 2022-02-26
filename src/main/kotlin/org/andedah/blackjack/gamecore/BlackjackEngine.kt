package org.andedah.blackjack.gamecore

class BlackjackEngine(private val deck: Deck = Deck.buildShuffled()) {

  fun playGame(): GameResult {
    val player = Player(deck.dealCards(2))
    val dealer = Dealer(deck.dealCards(2))

    return when {
      player.getScore() == 21 -> GameResult(dealer, player, Winner.PLAYER)
      dealer.getScore() == 21 -> GameResult(dealer, player, Winner.DEALER)
      player.getScore() == 22 && dealer.getScore() == 22 ->
          GameResult(dealer, player, Winner.DEALER)
      else -> getWinner(player, dealer)
    }
  }

  private fun getWinner(player: Player, dealer: Dealer): GameResult {
    val playersFinalScore = playerRound(player).getScore()
    val dealersFinalScore = dealerRound(dealer, playersFinalScore).getScore()
    return when {
      playersFinalScore > 21 -> GameResult(dealer, player, Winner.DEALER)
      dealersFinalScore > 21 -> GameResult(dealer, player, Winner.PLAYER)
      playersFinalScore > dealersFinalScore -> GameResult(dealer, player, Winner.PLAYER)
      else -> GameResult(dealer, player, Winner.DEALER)
    }
  }

  private fun dealerRound(dealer: Dealer, playersScore: Int): Dealer =
      if (dealer.shouldDraw(playersScore)) {
        dealerRound(Dealer(dealer.cards + deck.dealCards()), playersScore)
      } else {
        dealer
      }

  private fun playerRound(player: Player): Player =
      if (player.shouldDraw()) {
        playerRound(Player(player.cards + deck.dealCards()))
      } else {
        player
      }
}

enum class Winner {
  DEALER,
  PLAYER
}

data class GameResult(val dealerCards: Hand, val playerCards: Hand, val winner: Winner)

class Player(cards: List<Card>) : Hand(cards) {
  fun shouldDraw() = getScore() < 17
}

class Dealer(cards: List<Card>) : Hand(cards) {
  fun shouldDraw(playersScore: Int) = getScore() < playersScore && playersScore <= 21
}

open class Hand(val cards: List<Card>) {
  fun getScore() = cards.sumOf { it.value.points }

  fun cardLabels(): List<String> = cards.map { it.suit.label + it.value.label }
}
