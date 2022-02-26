# Blackjack

This is a simple simulation of the game Blackjack.

## Building the application

```
./gradlew build
```

## Running the application and simulating the game

Simulating the game with a generated deck off cards can be done with

```
./gradlew run
```

### User specified deck of cards

It is possible to run the simulation using a predefined deck of cards. This can be done by creating
a file with a comma seperated list of card labels and providing the absolute path as an argument
when running the application

```
./gradlew run -args="<absolute-path-deck-file>"
```

e.g.

```
./gradlew run --args="/Users/andedah/work/Blackjack/src/test/resources/deck"
```

## Card labels

A card label consists of two characters the first representing its suit and the second its value.

E.g. `S9` is the label for the card Nine of Spades

### Suits

```
C: Clubs
D: Diamonds
H: Hearts
S: Spades
```

### Values

```
2: 2
3: 3
....
10: 10
J: Jack
Q: Queen
K: King
A: Ace
```
