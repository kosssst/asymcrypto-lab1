package main.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TextUtil {

    public static String readFromFile(String fileName)  {
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            InputStream inputStream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

    public static int countMatches(String sequence, char target) {
        int num = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == target) {
                num += 1;
            }
        }
        return num;
    }

    public static Map<String, Integer> countPairsOfBits(String sequence) {
        Map<String, Integer> result = new HashMap<>() {{
            put("00", 0);
            put("01", 0);
            put("10", 0);
            put("11", 0);
        }};
        for (int i = 0; i < sequence.length() - 1; i += 2) {
            String key = "" + sequence.charAt(i) + sequence.charAt(i + 1);
            result.put(key, result.get(key) + 1);
        }

        return result;
    }

    public static String bytesToBits(String bytes) {
        StringBuilder bits = new StringBuilder();
        Map<Character, String> dictionary = new HashMap<>() {{
            put('0', "0000");
            put('1', "0001");
            put('2', "0010");
            put('3', "0011");
            put('4', "0100");
            put('5', "0101");
            put('6', "0110");
            put('7', "0111");
            put('8', "1000");
            put('9', "1001");
            put('A', "1010");
            put('B', "1011");
            put('C', "1100");
            put('D', "1101");
            put('E', "1110");
            put('F', "1111");
        }};

        for (int i = 0; i < bytes.length(); i++) {
            bits.append(dictionary.get(bytes.charAt(i)));
        }

        return bits.toString();
    }

    public static String bitsToBytes(String bits) {
        StringBuilder result = new StringBuilder();
        Map<String, Character> dictionary = new HashMap<>() {{
            put("0000", '0');
            put("0001", '1');
            put("0010", '2');
            put("0011", '3');
            put("0100", '4');
            put("0101", '5');
            put("0110", '6');
            put("0111", '7');
            put("1000", '8');
            put("1001", '9');
            put("1010", 'A');
            put("1011", 'B');
            put("1100", 'C');
            put("1101", 'D');
            put("1110", 'E');
            put("1111", 'F');
        }};

        for (int i = 0; i < bits.length() - 4; i += 4) {
            result.append(dictionary.get(bits.substring(i, i + 4)));
        }

        return result.toString();
    }

    public static Map<String, Integer> getBytes(String input) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < input.length() - 2; i += 2) {
            String Byte = input.substring(i, i + 2);
            if (!result.containsKey(Byte)) {
                result.put(Byte, 0);
            }
            result.put(Byte, result.get(Byte) + 1);
        }

        return result;
    }
}
