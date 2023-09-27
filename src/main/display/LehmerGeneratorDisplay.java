package main.display;

import main.generators.LehmerHighGenerator;
import main.generators.LehmerLowGenerator;

public class LehmerGeneratorDisplay {
    public static void main(String[] args) {
        LehmerLowGenerator generator1 = new LehmerLowGenerator(123456);
        LehmerHighGenerator generator2 = new LehmerHighGenerator(123456);

        for (int i = 0; i < 12; i++) {
            System.out.println(generator1.generate(100));
        }

        System.out.println();

        for (int i = 0; i < 12; i++) {
            System.out.println(generator2.generate(100));
        }
    }
}
