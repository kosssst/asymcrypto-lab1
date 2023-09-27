package test;

import main.generators.LibrarianGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibrarianGeneratorTest {
    private final LibrarianGenerator generator = new LibrarianGenerator();

    @Test
    void testLibrarianGeneratorFirstCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testLibrarianGeneratorFirstCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testLibrarianGeneratorFirstCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfUniformityOfBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testLibrarianGeneratorSecondCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testLibrarianGeneratorSecondCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testLibrarianGeneratorSecondCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfDistributionIndependenceForBits(generator.generate(2000000), 0.1));
    }

    @Test
    void testLibrarianGeneratorThirdCriterionWithAlpha001() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.01));
    }

    @Test
    void testLibrarianGeneratorThirdCriterionWithAlpha005() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.05));
    }

    @Test
    void testLibrarianGeneratorThirdCriterionWithAlpha01() {
        Assertions.assertTrue(Tests.criterionOfBinarySequenceHomogeneityForBits(generator.generate(2000000), 0.1));
    }
}
