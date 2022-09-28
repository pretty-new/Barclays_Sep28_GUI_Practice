import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Reader {

    private static String filepath = "src/resources/";
    public static HashMap<String, Integer> deconstruct(String file){
        ArrayList<String> wordList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath+file));
            String line;
            while ((line = br.readLine())!=null) {
                wordList.addAll(Arrays.asList(line.replaceAll("[^a-zA-Z ]","").toLowerCase().split("\\s+")));
            }
            System.out.println("Read.deconstruct() while loop success. Printing current state of wordList arraylist: ");
            System.out.println(wordList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : wordList) {
            wordCounts.put(word, wordCounts.getOrDefault(word,0)+1);
        }
        return wordCounts;
    }




}
