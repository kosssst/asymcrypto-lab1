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
}
