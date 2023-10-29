package io.github.kosssst.asymcryptolab1;

import io.github.kosssst.asymcryptolab1.generators.BuildInGenerator;
import main.util.TextUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuildInGeneratorTest {

    private static final String output = TextUtil.bitsToBytes(BuildInGenerator.generate(8000000));

    @Test
    void testBuildInGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.01));
    }

    @Test
    void testBuildInGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.05));
    }

    @Test
    void testBuildInGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(output, 0.1));
    }

    @Test
    void testBuildInGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.01));
    }

    @Test
    void testBuildInGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.05));
    }

    @Test
    void testBuildInGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(output, 0.1));
    }

    @Test
    void testBuildInGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.01));
    }

    @Test
    void testBuildInGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.05));
    }

    @Test
    void testBuildInGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(output, 0.1));
    }
}
