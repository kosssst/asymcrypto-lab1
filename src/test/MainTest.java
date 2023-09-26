package test;

import main.generators.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void testBuildInGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(BuildInGenerator.generate(2000000), 0.01));
    }

    @Test
    void testBuildInGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(BuildInGenerator.generate(2000000), 0.05));
    }

    @Test
    void testBuildInGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(BuildInGenerator.generate(2000000), 0.1));
    }

    @Test
    void testBuildInGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(BuildInGenerator.generate(1000000), 0.01));
    }

    @Test
    void testBuildInGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(BuildInGenerator.generate(1000000), 0.05));
    }

    @Test
    void testBuildInGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(BuildInGenerator.generate(1000000), 0.1));
    }

    @Test
    void testBuildInGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(BuildInGenerator.generate(1000000), 0.01));
    }

    @Test
    void testBuildInGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(BuildInGenerator.generate(1000000), 0.05));
    }

    @Test
    void testBuildInGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(BuildInGenerator.generate(1000000), 0.1));
    }
}
