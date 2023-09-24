package main.util;

public class MathUtil {
    public static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            result.append((a.charAt(i) - '0') ^ (b.charAt(i) - '0'));
        }
        return result.toString();
    }

    public static String or(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            result.append((a.charAt(i) - '0') | (b.charAt(i) - '0'));
        }
        return result.toString();
    }

    public static String cycleLeft(String a, int n) {
        for (int i = 0; i < n; i++) {
            char temp = a.charAt(0);
            a = a.substring(1);
            a += temp;
        }
        return a;
    }

    public static String cycleRight(String a, int n) {
        for (int i = 0; i < n; i++) {
            char temp = a.charAt(31);
            a = a.substring(0, 31);
            a = temp + a;
        }
        return a;
    }
}
