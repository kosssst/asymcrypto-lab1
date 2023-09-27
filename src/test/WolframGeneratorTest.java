package test;

import main.generators.WolframGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WolframGeneratorTest {
    private final WolframGenerator generator = new WolframGenerator();

    @Test
    void testWolframGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testWolframGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testWolframGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testWolframGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testWolframGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testWolframGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testWolframGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testWolframGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testWolframGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.1));
    }
}
