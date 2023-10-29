package main.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextUtil {

    public static final ArrayList<String> bytes = new ArrayList<>(List.of("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"));

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

        for (int i = 0; i <= bits.length() - 4; i += 4) {
            result.append(dictionary.get(bits.substring(i, i + 4)));
        }

        return result.toString();
    }

    public static Map<String, Integer> getBytes(String input) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i <= input.length() - 2; i += 2) {
            String Byte = input.substring(i, i + 2);
            if (!result.containsKey(Byte)) {
                result.put(Byte, 0);
            }
            result.put(Byte, result.get(Byte) + 1);
        }

        return result;
    }

    public static Map<ArrayList<String>, Integer> countPairs(String input) {
        Map<ArrayList<String>, Integer> result = new HashMap<>();

        for (String i : bytes) {
            for (String j : bytes) {
                result.put(new ArrayList<>(List.of(i, j)), 0);
            }
        }

        for (int i = 0; i <= input.length() - 4; i += 4) {
            String sub = input.substring(i, i + 4);
            ArrayList<String> temp = new ArrayList<>(List.of(sub.substring(0, 2), sub.substring(2, 4)));
            result.put(temp, result.get(temp) + 1);
        }

        return result;
    }

    public static int countPairsWithByteInFirstPlace(Map<ArrayList<String>, Integer> pairs, String Byte) {
        int result = 0;

        for (String i : bytes) {
            result += pairs.get(new ArrayList<>(List.of(Byte, i)));
        }

        return result;
    }

    public static int countPairsWithByteInSecondPlace(Map<ArrayList<String>, Integer> pairs, String Byte) {
        int result = 0;

        for (String i : bytes) {
            result += pairs.get(new ArrayList<>(List.of(i, Byte)));
        }

        return result;
    }

    public static int countMatchedBytes(String input, String match) {
        int result = 0;

        for (int i = 0; i <= input.length() - 2; i += 2) {
            if (input.substring(i, i + 2).equals(match)) {
                result++;
            }
        }

        return result;
    }
}
