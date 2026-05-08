package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import catcafe.FelineOverLord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FelineOverLordTest {

  @Test
  @DisplayName("Name von FelineOverLord wird richtig returnt")
  void name_validName_returnsName() {
    var testName = "name";
    FelineOverLord feline = new FelineOverLord(testName, 1);

    var name = feline.name();

    assertEquals(testName, name);
  }

  @Test
  @DisplayName("Gewicht von FelineOverLord wird richtig returnt")
  void weight_validWeight_returnsWeight() {
    var testWeight = 1;
    FelineOverLord feline = new FelineOverLord("", testWeight);

    var weight = feline.weight();

    assertEquals(testWeight, weight);
  }

  @Test
  @DisplayName("compareTo gibt positive Zahl zurück, wenn das Gewicht größer ist")
  void compareTo_biggerFeline_returnPositive() {
    FelineOverLord feline1 = new FelineOverLord("", 2);
    FelineOverLord feline2 = new FelineOverLord("", 1);

    var result = feline1.compareTo(feline2);

    assertTrue(result > 0);
  }

  @Test
  @DisplayName("compareTo gibt negative Zahl zurück, wenn das Gewicht kleiner ist")
  void compareTo_smallerFeline_returnNegative() {
    FelineOverLord feline1 = new FelineOverLord("", 1);
    FelineOverLord feline2 = new FelineOverLord("", 10);

    var result = feline1.compareTo(feline2);

    assertTrue(result < 0);
  }

  @Test
  @DisplayName("compareTo gibt 0 zurück, wenn das Gewicht gleich ist")
  void compareTo_equalFeline_returnZero() {
    FelineOverLord feline1 = new FelineOverLord("", 1);
    FelineOverLord feline2 = new FelineOverLord("", 1);

    var result = feline1.compareTo(feline2);

    assertEquals(0, result);
  }

  @Test
  @DisplayName("toString gibt korrekte String-Repräsentation zurück")
  void toString_stringification_correctValues() {
    var className = FelineOverLord.class.getSimpleName();
    var testName = "name";
    var testWeight = 100;
    FelineOverLord feline = new FelineOverLord(testName, testWeight);

    String text = feline.toString();

    assertTrue(text.startsWith(className));
    assertTrue(text.contains(testName));
    assertTrue(text.contains(String.valueOf(testWeight)));
  }
}
