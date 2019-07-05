package com.frijolie.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * A collection of {@link PlayingCard}s. A full standard deck will contain 52 cards. The deck is
 * comprised of one card for every {@link Rank} and for each {@link Suit}. There are 13 ranked cards
 * and 4 suits (13 * 4 = 52).
 *
 * <p>For example a sequential deck of cards would look something like this: Ace of Hearts Two of
 * Hearts Three of Hearts ... Ace of Spades Two of Spades Three of Spades ... Ace of Diamonds Two of
 * Diamonds Three of Diamonds ... Queen of Diamonds King of Diamonds
 *
 * <p>The default no-arg constructor will create a single deck of unshuffled cards. There is also an
 * overloaded constructor which allows the creation of multiple decks and to shuffle the deck after
 * instantiation.
 *
 * @see PlayingCard
 */
public class Deck {

  /**
   * A List to contain all of the cards in the deck.
   */
  private final List<Card> deck;

  /**
   * Default no-arg constructor.
   */
  public Deck() {
    this(1, false);
  }

  /**
   * Overloaded constructor. Allows for multiple decks and the ability to have it shuffled after it
   * has been created.
   *
   * @param numOfDecks the number of decks to create
   * @param shuffled   {@code true} if you wish to shuffle the deck afterwards
   */
  public Deck(int numOfDecks, boolean shuffled) {
    deck = new ArrayList<>();
    IntStream.range(0, numOfDecks).forEach(i -> populateDeck());
    if (shuffled) {
      shuffle();
    }
  }

  /**
   * Populates a full deck of cards. It will contain every rank within every suit (52 unique cards).
   */
  private void populateDeck() {
    Arrays.stream(Suit.values())
        .forEach(
            suit ->
                Arrays.stream(Rank.values())
                    .map(rank -> new PlayingCard(rank, suit))
                    .forEach(deck::add));
  }

  /**
   * Returns a List of all the cards contained in the current deck.
   *
   * @return List that contains all cards in the Deck
   */
  public List<Card> getDeck() {
    return new ArrayList<>(deck);
  }

  /**
   * Shuffles the current deck of cards.
   */
  private void shuffle() {
    Collections.shuffle(deck);
  }
}
