package main.display;

import main.generators.BBSGenerator;

public class BBSGeneratorDisplay {
    public static void main(String[] args) {
        BBSGenerator bbsGenerator = new BBSGenerator();

        System.out.println(bbsGenerator.generate(100));

        for (int i = 0; i < 10; i++) {
            System.out.println(bbsGenerator.generateByte());
        }
    }
}
