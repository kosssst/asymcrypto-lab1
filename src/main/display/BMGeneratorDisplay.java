package main.display;

import main.generators.BMGenerator;

public class BMGeneratorDisplay {
    public static void main(String[] args) {
        BMGenerator bmGenerator = new BMGenerator();
        System.out.println(bmGenerator.generate(20));
        System.out.println(bmGenerator.generateByte());
    }
}
