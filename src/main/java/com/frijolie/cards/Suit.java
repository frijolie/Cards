package com.frijolie.cards;

/**
 * A enumeration of all possible {@link PlayingCard} suits. Each {@code Suit} can be represented as
 * a word or symbol. Each suit will also have a {@link CardColor}.
 *
 * <p>Declaration order of the constant values is intentional and important. The {@code ordinal}
 * values are used to sort and compare cards. The alternating order of Suits are meant to present an
 * aesthetically pleasing sorted order.
 *
 * <p>Valid {@code Suit} values are:
 *
 * <ul>
 * <li>CLUBS
 * <li>DIAMONDS
 * <li>SPADES
 * <li>HEARTS
 * </ul>
 *
 * @see PlayingCard
 * @see CardColor
 */
public enum Suit {
  CLUBS("Clubs", '♣', CardColor.BLACK),
  DIAMONDS("Diamonds", '♦', CardColor.RED),
  SPADES("Spades", '♠', CardColor.BLACK),
  HEARTS("Hearts", '♥', CardColor.RED);

  /**
   * {@code Suit} in the form of a word. For example, "Diamonds"
   */
  private final String name;

  /**
   * {@code Suit} in the form of a single character. For example, ♠
   */
  private final char symbol;

  /**
   * {@code CardColor} as an enumerated value. For example, CardColor.BLACK
   */
  private final CardColor color;

  /**
   * Constructor. Required: {@code Name}, {@code Symbol}, and {@code CardColor}.
   *
   * @param name   the {@code String} value
   * @param symbol the {@code char} value
   * @param color  the {@code CardColor} value
   */
  Suit(String name, char symbol, CardColor color) {
    this.name = name;
    this.symbol = symbol;
    this.color = color;
  }

  @Override
  public String toString() {
    return name;
  }

  /**
   * Returns the {@code String} value of the {@code Suit}, as a word. For example, "Hearts"
   *
   * @return the {@code Suit} as a word
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the {@code char} value of the {@code Suit}, as a unicode symbol. For example, ♠
   *
   * @return the {@code Suit} as a symbol
   */
  public char getSymbol() {
    return symbol;
  }

  /**
   * Returns the {@code CardColor} of the {@code Suit}. For example, CardColor.RED
   *
   * @return the color of the suit
   */
  public CardColor getColor() {
    return color;
  }
}
