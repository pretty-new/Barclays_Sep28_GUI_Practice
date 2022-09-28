import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Session {


    private HashMap<String, HashMap<String, Integer>> fileWordCounts = new HashMap<>();

    public Session(){
        // get a file name and return word count
    }


    public void countFile(String file){
        System.out.println("Reading file "+file);
        HashMap<String, Integer> wordCounts = Reader.deconstruct(file);
        // print console for verification
        for (String word : wordCounts.keySet()) {
            System.out.println(word+": "+wordCounts.get(word));
        }

        fileWordCounts.put(file,wordCounts);
    }

    public String printFileWordCount(String file){
        String output = "Word: Count";
        HashMap<String, Integer> wordCounts = fileWordCounts.get(file);
        String[] words = wordCounts.keySet().toArray(new String[0]);
        Arrays.sort(words);
        for (String word: words) {
            output += ("\n"+word+": "+wordCounts.get(word));
        }
        return output;
    }

    public void listFiles(){
        System.out.println(fileWordCounts.keySet());
    }


}
