package org.andedah.blackjack.gameloader

import java.io.File
import org.andedah.blackjack.gamecore.Card
import org.andedah.blackjack.gamecore.Deck

fun loadGameDeck(filePath: String): Deck {
  val gameFile = File(filePath)
  val labels = gameFile.readText().split(',').map { it.trim() }
  return Deck(labels.map { Card(it) })
}
