package test;

import main.generators.L20Generator;
import main.util.TextUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class L20GeneratorTest {
    private static final L20Generator generator = new L20Generator();
    private static final String output = TextUtil.bitsToBytes(generator.generate(16000000));

    @Test
    void testL20GeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.01));
    }

    @Test
    void testL20GeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.05));
    }

    @Test
    void testL20GeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.1));
    }

    @Test
    void testL20GeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.01));
    }

    @Test
    void testL20GeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.05));
    }

    @Test
    void testL20GeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.1));
    }

    @Test
    void testL20GeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.01));
    }

    @Test
    void testL20GeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.05));
    }

    @Test
    void testL20GeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.1));
    }
}
