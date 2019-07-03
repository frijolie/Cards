package com.frijolie.cards;

/**
 * An enumeration of all possible {@link PlayingCard} ranks. Each {@code Rank} can be represented as
 * a word or a character. They will also have a numerical value.
 *
 * <p>Declaration order of the constant values is intentional and important. The ordinal values are
 * used for comparison and sorting.
 *
 * <p>Valid ranks are as follows, in ASCENDING order:
 *
 * <ul>
 * <li>TWO
 * <li>THREE
 * <li>FOUR
 * <li>FIVE
 * <li>SIX
 * <li>SEVEN
 * <li>EIGHT
 * <li>NINE
 * <li>TEN
 * <li>JACK
 * <li>QUEEN
 * <li>KING
 * <li>ACE
 * </ul>
 */
public enum Rank {
  TWO("Two", '2', 2),
  THREE("Three", '3', 3),
  FOUR("Four", '4', 4),
  FIVE("Five", '5', 5),
  SIX("Six", '6', 6),
  SEVEN("Seven", '7', 7),
  EIGHT("Eight", '8', 8),
  NINE("Nine", '9', 9),
  TEN("Ten", 'T', 10),
  JACK("Jack", 'J', 10),
  QUEEN("Queen", 'Q', 10),
  KING("King", 'K', 10),
  ACE("Ace", 'A', 11);

  /**
   * {@code Rank} in the form of a word. For example, "Jack"
   */
  private final String name;

  /**
   * {@code Rank} in the form of a character. For example, 'Q'
   */
  private final char letter;

  /**
   * The assigned numerical value of a rank. For example, 10
   */
  private final int value;

  /**
   * Constructor. Must provide a name, letter, and int value.
   *
   * @param name   the string value
   * @param letter the char value
   * @param value  the int value
   */
  Rank(String name, char letter, int value) {
    this.name = name;
    this.letter = letter;
    this.value = value;
  }

  @Override
  public String toString() {
    return name;
  }

  /**
   * Returns the {@code String} value of {@code Rank}, as a word. For example, "Queen"
   *
   * @return the {@code Rank} as a word
   */
  public final String getName() {
    return name;
  }

  /**
   * Returns the {@code Char} value of {@link Rank}, as a single character. For example, 'K'
   *
   * @return the {@code Rank} as a single character
   */
  public final char getLetter() {
    return letter;
  }

  /**
   * Returns the {@code int} value of {@link Rank}, as an integer. For example, 10
   *
   * @return the {@code Rank} value as an {@code int}
   */
  public final int getValue() {
    return value;
  }
}
