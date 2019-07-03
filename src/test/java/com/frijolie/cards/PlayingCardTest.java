package com.frijolie.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayingCardTest {

  private PlayingCard aceOfHearts;
  private PlayingCard nineOfDiamonds;
  private PlayingCard aceOfSpades;

  @BeforeEach
  void setUp() {
    aceOfHearts = new PlayingCard(Rank.ACE, Suit.HEARTS);
    nineOfDiamonds = new PlayingCard(Rank.NINE, Suit.DIAMONDS);
    aceOfSpades = new PlayingCard(Rank.ACE, Suit.SPADES);
  }

  @AfterEach
  void tearDown() {
    aceOfHearts = null;
    nineOfDiamonds = null;
    aceOfSpades = null;
  }

  @Test
  void testGetValue_AceOfHeartsShouldReturn_11() {
    String message =
        String.format("Was expecting value to equal 11. Instead it is: %d", aceOfHearts.getValue());
    assertEquals(11, aceOfHearts.getValue(), message);
  }

  @Test
  void testGetRank_AceOfHeartsRankShouldEqual_ACE() {
    String message = "Was expecting Rank.ACE, instead rank was: " + aceOfHearts.getRank();
    assertEquals(Rank.ACE, aceOfHearts.getRank(), message);
  }

  @Test
  void testGetSuit_AceOfHeartsSuitShouldEqualSuit_HEARTS() {
    String message = "Was expecting Suit.HEARTS, instead received: " + aceOfHearts.getSuit();
    assertEquals(Suit.HEARTS, aceOfHearts.getSuit(), message);
  }

  @Test
  void testGetColor_AceOfHeartsColorShouldEqualColor_RED() {
    String message = "Was expecting CardColor.RED, instead color was: " + aceOfHearts.getColor();
    assertEquals(CardColor.RED, aceOfHearts.getColor(), message);
  }

  @Test
  void testEquals_AceOfHeartsEqualToAceOfSpacesShouldBeFalse() {
    String message = "An AceOfHearts should not equal an AceOfSpades";
    assertNotEquals(aceOfHearts, aceOfSpades, message);
  }

  @Test
  void testEquals_AceOfHeartsEqualToAceOfHeartsShouldBeTrue() {
    String message = "An AceOfHearts should equal another AceOfHearts";
    assertEquals(aceOfHearts, aceOfHearts, message);
  }

  @Test
  void testEquals_PassingNullArgumentShouldThrowNullPointerException() {
    String message = "Passing a null argument should throw a NullPointerException";
    assertThrows(
        NullPointerException.class,
        () -> {
          aceOfHearts.equals(null);
        },
        message);
  }

  @Test
  void testEquals_DifferentClassesShouldReturnFalse() {
    String message = "Passing a different object, should return false";
    assertNotEquals(aceOfHearts, new Object(), message);
  }

  @Test
  void testHash_AceOfHeartsHashCodeShouldEqual_750713243() {
    String message =
        String.format(
            "Ace of Hearts hashCode should equal" + " random number, instead it is: %d",
            aceOfHearts.hashCode());
    assertNotEquals(750713243, aceOfHearts.hashCode(), message);
  }

  /**
   * Hearts suit.ordinal = 3 Diamonds suit.ordinal = 1 3 - 1 = 2
   */
  @Test
  void testCompareTo_AceOfHeartsComparedToNineOfDiamondsShouldReturn_Pos5() {
    String message =
        String.format(
            "Was expecting the result to equal 5, instead it is: %d",
            aceOfHearts.compareTo(nineOfDiamonds));
    assertEquals(5, aceOfHearts.compareTo(nineOfDiamonds), message);
  }

  /**
   * Diamonds suit.ordinal = 1 Hearts suit.ordinal = 3 1 - 3 = -2
   */
  @Test
  void testCompareTo_NineOfDiamondsComparedToAceOfHeartsShouldReturn_Neg5() {
    String message =
        String.format(
            "Was expecting the result to be -5, instead it is: %d",
            nineOfDiamonds.compareTo(aceOfHearts));
    assertEquals(-5, nineOfDiamonds.compareTo(aceOfHearts), message);
  }

  /**
   * Ace has a value of 1 rank is equal (1 = 1) Now need to compare suits ♥ ordinal + 1 = 4 ♠
   * ordinal + 1 = 3 ♥(4) > ♠(3) compareTo should return 1
   */
  @Test
  void testCompareTo_AceOfHeartsComparedToAceOfSpadesShouldReturn_Pos1() {
    String message =
        "Was expecting the difference to be 1, instead it is: "
            + aceOfHearts.compareTo(aceOfSpades);
    assertEquals(1, aceOfHearts.compareTo(aceOfSpades), message);
  }

  @Test
  void testCompareTo_PassingNullArgumentShouldThrowNullPointerException() {
    String message = "Passing a null argument should throw NullPointerException";
    assertThrows(NullPointerException.class, () -> aceOfSpades.compareTo(null), message);
  }

  @Test
  void testToString_AceOfHeartsShouldReturn_Ace_Of_Hearts() {
    String message = "Was expecting 'A♥', instead it was : " + aceOfHearts.toString();
    assertEquals("A♥", aceOfHearts.toString(), message);
  }

  @Test
  void testGetRankLetter_AceOfHeartsRankLetterShouldEqual_A() {
    String message = "Was expecting 'A', instead Rank letter was: " + aceOfHearts.getRankLetter();
    assertEquals('A', aceOfHearts.getRankLetter(), message);
  }

  @Test
  void testGetRankName_AceOfHeartsRankNameShouldEqual_Ace() {
    String message = "Was expecting 'Ace', instead rank name was: " + aceOfHearts.getRankName();
    assertEquals("Ace", aceOfHearts.getRankName(), message);
  }

  @Test
  void testGetSymbol_AceOfHeartsSymbolShouldEqual_u2764() {
    String message = "Was expecting '♥', instead it was: " + aceOfHearts.getSymbol();
    assertEquals('♥', aceOfHearts.getSymbol(), message);
  }

  @Test
  void testGetSuitName_AceOfHeartsSuitNameShouldEqual_Hearts() {
    String message = "Suit name should equal 'Hearts'. Instead it is: " + aceOfHearts.getSuitName();
    assertEquals("Hearts", aceOfHearts.getSuitName(), message);
  }

  @Test
  void testSameColor_AceOfHeartsSameColorAsAceOfHeartsShouldReturn_True() {
    String message = "An Ace of Hearts should have the same color as another Ace of Hearts.";
    assertTrue(aceOfHearts.sameColor(aceOfHearts), message);
  }

  @Test
  void testSameColor_PassingNullArgumentShouldThrowNullPointerException() {
    String message = "Passing a null argument should throw NullPointerException";
    assertThrows(NullPointerException.class, () -> aceOfSpades.sameColor(null), message);
  }

  @Test
  void testSameRank_TwoAcesShouldReturnTrue() {
    assertTrue(aceOfHearts.sameRank(aceOfSpades));
  }

  @Test
  void testSameValue_TwoAcesShouldReturnTrue() {
    assertTrue(aceOfHearts.sameValue(aceOfSpades));
  }

  private Rank randomRank() {
    return Rank.values()[new Random().nextInt(Rank.values().length)];
  }

  private Suit randomSuit() {
    return Suit.values()[new Random().nextInt(Suit.values().length)];
  }
}
