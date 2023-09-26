package main.util;

import java.io.*;

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
}
