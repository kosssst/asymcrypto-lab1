package main.display;

import main.generators.LehmerGenerator;

public class LehmerGeneratorDisplay {
    public static void main(String[] args) {
        LehmerGenerator generator = new LehmerGenerator();
        //LehmerGenerator generator = new LehmerGenerator(12);

        for (int i = 0; i < 12; i++) {
            System.out.println(generator.lehmerLow());
        }

        System.out.println();

        for (int i = 0; i < 12; i++) {
            System.out.println(generator.lehmerHigh());
        }
    }
}
