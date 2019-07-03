package com.frijolie.cards;

import static java.util.Comparator.comparing;

import java.util.Objects;

/**
 * An interface to represent the required behavior of a {@link PlayingCard}. It is used in a classic
 * {@link Deck} of cards. It assumes all cards have a {@link Rank} and {@link Suit}.
 *
 * <p>A PlayingCard can have only one rank and suit. The rank determines the value of the card while
 * the suit determines the color and grouping.
 *
 * @see PlayingCard
 * @see Rank
 * @see Suit
 * @see Deck
 */
public interface Card extends Comparable<Card> {

  /**
   * Returns the value as an {@code int}. This is linked to the cards {@link Rank}.
   *
   * @return the card value as an {@code int}
   * @see Rank#getValue()
   */
  int getValue();

  /**
   * Returns the card {@link Rank} as an enumerated value. Valid values are: ACE, TWO, THREE, ...
   * TEN, JACK, QUEEN, or KING.
   *
   * @return the card {@code Rank} as enumerated value.
   * @see Rank
   */
  Rank getRank();

  /**
   * Returns the {@link Suit} as an enumerated value. Valid suits are: CLUBS, DIAMONDS, SPADES, and
   * HEARTS.
   *
   * @return the card {@code Suit} as an enumerated value.
   * @see Suit
   */
  Suit getSuit();

  /**
   * Returns the {@link CardColor} as an enumerated value. Valid colors are: RED and BLACK.
   *
   * @return the {@code CardColor} as an enumerated value.
   * @see CardColor
   */
  CardColor getColor();

  @Override
  default int compareTo(Card that) {
    return comparing(Card::getRank).thenComparing(Card::getSuit).compare(this, that);
  }

  /**
   * Returns {@code true} if the {@link CardColor} matches the one being compared.
   *
   * @param that the {@code Card} used in the comparison
   * @return {@code true} if the colors are the same
   * @throws NullPointerException if the {@code card} argument is {@code null}.
   */
  default boolean sameColor(Card that) {
    String message = "You must pass a non null card for comparison.";
    Objects.requireNonNull(that, message);
    return comparing(Card::getColor).compare(this, that) == 0;
  }

  /**
   * Returns {@code true} if the current card and the one being compared share the same Rank.
   *
   * @param that the card used in the comparison
   * @return {@code true} if the rank is identical
   * @throws NullPointerException if the argument is {@code null}
   */
  default boolean sameRank(Card that) {
    String nullError = "You must pass a non null card for comparison.";
    Objects.requireNonNull(that, nullError);
    return comparing(Card::getRank).compare(this, that) == 0;
  }

  /**
   * Returns {@code true} if the current card and the one being compared share the same value.
   *
   * @param that the card used in the comparison
   * @return {@code true} if the values are identical
   * @throws NullPointerException if the argument is {@code null}
   */
  default boolean sameValue(Card that) {
    String nullError = "You must pass a non null card for comparison.";
    Objects.requireNonNull(that, nullError);
    return comparing(Card::getValue).compare(this, that) == 0;
  }
}
