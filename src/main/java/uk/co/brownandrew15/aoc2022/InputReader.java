package uk.co.brownandrew15.aoc2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read the input files.
 */
public class InputReader {
    
    /**
     * Reads the input into an array of Strings where each element is a line from the file.
     * 
     * @param dayNumber the day number to read
     * @return an array of the lines of the file
     */
    public static String[] readDay(int dayNumber) {

        String filename = String.format("%02d", dayNumber) + ".txt";

        try {
            // get the resource into a input stream
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(filename);
            // read the input stream
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            // process the file lines
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            System.err.println("There was an exception reading " + filename);
            return new String[0];
        }
            

    }


}
