package io.github.kosssst.asymcryptolab1;

import io.github.kosssst.asymcryptolab1.generators.BMGenerator;
import main.util.TextUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BMGeneratorBitsTest {
    private static final BMGenerator generator = new BMGenerator();
    private static final String output = TextUtil.bitsToBytes(generator.generate(8000000));

    @Test
    void testBMGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.01));
    }

    @Test
    void testBMGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.05));
    }

    @Test
    void testBMGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.1));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.01));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.05));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.1));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.01));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.05));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.1));
    }
}
