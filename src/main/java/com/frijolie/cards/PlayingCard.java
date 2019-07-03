package com.frijolie.cards;

import java.util.Objects;

/**
 * A concrete class used to represent a single {@link Card} in a {@link Deck} of cards. Each {@code
 * PlayingCard} has a {@link Rank} and {@link Suit}.
 *
 * @see Rank
 * @see Suit
 */
public class PlayingCard implements Card {

  /**
   * The {@link Rank}. Values are ACE, TWO, THREE ... TEN, JACK, QUEEN, KING.
   */
  private final Rank rank;

  /**
   * The {@link Suit}. Valid values are: CLUBS, DIAMONDS, SPADES, or HEARTS.
   */
  private final Suit suit;

  /**
   * Constructor. Must provide a {@link Rank} and {@link Suit}
   *
   * @param rank the cards rank
   * @param suit the cards suit
   */
  public PlayingCard(final Rank rank, final Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  @Override
  public int getValue() {
    return rank.getValue();
  }

  @Override
  public Rank getRank() {
    return rank;
  }

  @Override
  public Suit getSuit() {
    return suit;
  }

  @Override
  public CardColor getColor() {
    return suit.getColor();
  }

  @Override
  public boolean equals(Object o) {
    String message = "The object for comparison must not be null";
    Objects.requireNonNull(o, message);

    if (this == o) {
      return true;
    }

    if (getClass() != o.getClass()) {
      return false;
    }

    Card that = (Card) o;

    return this.compareTo(that) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRank(), getSuit());
  }

  @Override
  public String toString() {
    return String.format("%s%s", getRankLetter(), suit.getSymbol());
  }

  /**
   * Returns the {@link Rank}, represented as a character. For example, '5' for a {@code FIVE} or
   * 'Q' for a {@code QUEEN}.
   *
   * @return the {@code Rank} as a single character
   * @see Rank
   */
  public char getRankLetter() {
    return rank.getLetter();
  }

  /**
   * Returns the {@link Rank}, represented as a word. For example, "Ten" for a {@code TEN} or "King"
   * for a {@code KING}.
   *
   * @return the {@code Rank} as a word
   * @see Rank
   */
  public String getRankName() {
    return rank.getName();
  }

  /**
   * Returns the {@link Rank}, represented as a unicode symbol or graphic.
   *
   * @return the {@code Rank}, represented as a symbol
   */
  public char getSymbol() {
    return suit.getSymbol();
  }

  /**
   * Returns the {@link Suit}, represented as a word. For example, "Hearts" for {@code HEARTS}.
   *
   * @return the {@code Suit} as a word.
   */
  public String getSuitName() {
    return suit.getName();
  }
}
