package org.andedah.blackjack

import org.andedah.blackjack.gamecore.BlackjackEngine
import org.andedah.blackjack.gamecore.Deck
import org.andedah.blackjack.gamecore.Winner
import org.andedah.blackjack.gameloader.loadGameDeck

fun main(args: Array<String>) {

  val filePath: String? = args.firstOrNull()
  val deck = filePath?.let { loadGameDeck(filePath) } ?: Deck.buildShuffled()
  val gameResult = BlackjackEngine(deck).playGame()

  val winnerName =
      when (gameResult.winner) {
        Winner.PLAYER -> "sam"
        Winner.DEALER -> "dealer"
      }
  println(winnerName)
  println(
      "sam: ${gameResult.playerCards.cardLabels().toString().replace("[", "").replace("]", "")}")
  println(
      "dealer: ${gameResult.dealerCards.cardLabels().toString().replace("[", "").replace("]", "")}")
}
