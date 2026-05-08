package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import catcafe.CatCafe;
import catcafe.FelineOverLord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatCafeTest {

  private CatCafe cafe;

  @BeforeEach
  void setUp() {
    // given (gemeinsam für alle Tests): frisches Cafe
    cafe = new CatCafe();
  }

  @Test
  @DisplayName("Neues Cafe enthält keine Katzen")
  void getCatCount_emptyCafe_returnsZero() {
    // given: leeres Cafe (aus setUp)

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(0, count);
  }

  @Test
  @DisplayName("10 FelineOverLord hinzufügen ergibt 10 Katzen")
  void getCatCount_10FelineAdded_returns10() {
    for (int i = 0; i < 10; i++) cafe.addCat(new FelineOverLord("", 1));

    long count = cafe.getCatCount();

    assertEquals(10, count);
  }

  @Test
  @DisplayName("getCatByWeight mit inklusivem UpperWeight returnt richtige Katze")
  void getCatByWeight_RandomFelineWeights_returnsCorrectWeightCats() {
    for (int i = 1; i <= 10; i++) cafe.addCat(new FelineOverLord("", i));

    FelineOverLord cat = cafe.getCatByWeight(0, 2);

    assertEquals(1, cat.weight());
  }

  @Test
  @DisplayName("getCatByWeight mit exklusivem UpperWeight returnt null")
  void getCatByWeight_TestExclusiveUpperWeight_returnsNull() {
    for (int i = 1; i <= 10; i++) cafe.addCat(new FelineOverLord("", i));

    FelineOverLord cat = cafe.getCatByWeight(0, 1);

    assertNull(cat);
  }
}
