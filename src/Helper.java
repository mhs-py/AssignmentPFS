import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * It is helper class to
 */
public class Helper {

    public static final int ALPHABET_INIT = 1;
    public static final int LOOP_ALPHABET = 26;

    public static boolean matchSucceded = false;

    public static List<String> exceptionList = new ArrayList<String>();
    public static char[] target ;
    public static char[] source ;

    public static char nextAlphabetChar (int current){
        return current == 122 ? (char)97 : (char)(current+1);
    }

    /**
     * It's for internal use don't worry if it confuses you
     * @param src
     * @param dest
     * @return
     */
    public static boolean[] matchedPositions(char[] src, char[] dest){
        boolean[] matchedPostions = new boolean[src.length];
        for(int i=0; i < src.length;i++){
            if(src[i] == dest[i]){
                matchedPostions[i] = true;
            }else {
                matchedPostions[i] = false;
            }
        }
        return matchedPostions;
    }

    /**
     * Don't try to give invalid inputs
     * @param args
     */

    public static void validateInputs(String[] args){
        if(args.length == 2 && (args[0].length() == args[1].length()) ){
            //Optional validate regex /^[a-z]+$]
            if(Dictionary.isWordInDictionary(args[0].toCharArray()) && Dictionary.isWordInDictionary(args[1].toCharArray())){
                Helper.source = args[0].toCharArray();
                Helper.target = args[1].toCharArray();
            }else {
                System.out.println("Either of the words ["+args[0]+","+args[1] +"] not found in Dictionary");
                System.exit(0);
            }
            System.out.println("Inputs : "+String.copyValueOf(Helper.source) +" ; "+String.copyValueOf(Helper.target));
        }else {
            System.out.println("Invalid inputs");
            System.exit(0);
        }
    }

    public static boolean completeMatched(boolean[] matchedPositions){
        for(boolean value : matchedPositions){
            if (!value) return false;
        }
        return true;
    }

    /**
     * Replaces single character and checks in Dictionary
     * @param src
     * @param pos
     * @param replacement
     * @return
     */
    public static char[] checkWord(char[] src, int pos, char replacement){
        char[] newWord = Arrays.copyOf(src,src.length);
        newWord[pos] = replacement;
        return  Dictionary.isWordInDictionary(newWord) ? newWord : null;
    }

    /**
     *  Loops over all 25 alphabets and returns if word is valid
     * @param src
     * @param pos
     * @return
     */
    public static char[] loopAlphabets(char[] src, int pos){
        char[] newWord = Arrays.copyOf(src,src.length);
        int count = ALPHABET_INIT;
        while(count < LOOP_ALPHABET) {
            newWord[pos] = nextAlphabetChar((int)newWord[pos]);
            if((newWord[pos] != Helper.target[pos]) && Dictionary.isWordInDictionary(newWord)){
                return newWord;
            }
            count = count + 1;
        }
        return null;
    }

}
