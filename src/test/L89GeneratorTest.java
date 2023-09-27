package test;

import main.generators.L89Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class L89GeneratorTest {
    private final L89Generator generator = new L89Generator();

    @Test
    void testL89GeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(1000000), 0.01));
    }

    @Test
    void testL89GeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(1000000), 0.05));
    }

    @Test
    void testL89GeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(1000000), 0.1));
    }

    @Test
    void testL89GeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(1000000), 0.01));
    }

    @Test
    void testL89GeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(1000000), 0.05));
    }

    @Test
    void testL89GeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(1000000), 0.1));
    }

    @Test
    void testL89GeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(1000000), 0.01));
    }

    @Test
    void testL89GeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(1000000), 0.05));
    }

    @Test
    void testL89GeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(1000000), 0.1));
    }
}
