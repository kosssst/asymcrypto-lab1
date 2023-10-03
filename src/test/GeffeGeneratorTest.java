package test;

import main.generators.GeffeGenerator;
import main.util.TextUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeffeGeneratorTest {
    private final GeffeGenerator generator = new GeffeGenerator();
    private final String output = TextUtil.bitsToBytes(generator.generate(16000000));

    @Test
    void testGeffeGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.01));
    }

    @Test
    void testGeffeGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.05));
    }

    @Test
    void testGeffeGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.1));
    }

    @Test
    void testGeffeGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.01));
    }

    @Test
    void testGeffeGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.05));
    }

    @Test
    void testGeffeGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.1));
    }

    @Test
    void testGeffeGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.01));
    }

    @Test
    void testGeffeGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.05));
    }

    @Test
    void testGeffeGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.1));
    }
}
