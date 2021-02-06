import java.util.Arrays;
import java.util.List;

/**
 * Dictionary : please specify list of words
 */
public class Dictionary {

    /**
     * Please upload all words suitable for testing
     * Including your two input words
     */
    public static List<String> dictionaryWords = Arrays.asList(new String[]{
            "corns","cores","cones","coney","money",
            "can","man","cab","cad","mad",
            "a","b","c","d","e"

    });

    /**
     * Finds if the word exist in dictionary
     * @param word
     * @return
     */

    public static boolean isWordInDictionary(char[] word){
        return dictionaryWords.contains(String.copyValueOf(word));
    }
}



