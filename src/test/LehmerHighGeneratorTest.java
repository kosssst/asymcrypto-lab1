package test;

import main.generators.LehmerHighGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LehmerHighGeneratorTest {
    private final LehmerHighGenerator generator = new LehmerHighGenerator();
    // todo do exception in third's test
    @Test
    void testLehmerHighGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testLehmerHighGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testLehmerHighGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testLehmerHighGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testLehmerHighGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testLehmerHighGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testLehmerHighGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testLehmerHighGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testLehmerHighGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.1));
    }
}
