package test;

import main.generators.L20Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class L20GeneratorTest {
    private final L20Generator generator = new L20Generator();

    @Test
    void testL20GeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(1000000), 0.01));
    }

    @Test
    void testL20GeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(1000000), 0.05));
    }

    @Test
    void testL20GeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(1000000), 0.1));
    }

    @Test
    void testL20GeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(1000000), 0.01));
    }

    @Test
    void testL20GeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(1000000), 0.05));
    }

    @Test
    void testL20GeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(1000000), 0.1));
    }

    @Test
    void testL20GeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(1000000), 0.01));
    }

    @Test
    void testL20GeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(1000000), 0.05));
    }

    @Test
    void testL20GeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(1000000), 0.1));
    }
}
