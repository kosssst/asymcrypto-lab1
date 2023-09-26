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
}
