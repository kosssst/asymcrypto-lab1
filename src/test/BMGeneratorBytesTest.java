package test;

import main.generators.BMGenerator;
import main.util.TextUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BMGeneratorBytesTest {
    private final BMGenerator generator = new BMGenerator();

    @Test
    void testBMGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.01));
    }

    @Test
    void testBMGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.05));
    }

    @Test
    void testBMGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.1));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.01));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.05));
    }

    @Test
    void testBMGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.1));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.01));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.05));
    }

    @Test
    void testBMGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(TextUtil.bytesToBits(generator.generateByte(2000000)), 0.1));
    }
}
