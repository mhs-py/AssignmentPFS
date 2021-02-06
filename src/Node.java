import java.util.*;


/**
 * @Author {Mahesh Miragi}
 * I am tired to write this explanation
 */
public class Node {

    private char[] src;
    private boolean matchFound;
    private List<Node> nextPossibleNode = new ArrayList<>();
    private boolean[] unMatchedPositions;
    private Node parentNode;

    public Node(char[] src, Node parentNode){
        this.src = Arrays.copyOf(src,src.length);
        unMatchedPositions = Helper.matchedPositions(this.src, Helper.target);
        matchFound = Helper.completeMatched(unMatchedPositions);
        this.parentNode = parentNode;

    }

    public void process(){
        if(!matchFound) {
            loadDirectMatches();
            loadIndirectMatches();
            if(nextPossibleNode.size() > 0){
                nextPossibleNode.stream().forEach(node -> node.process());
            }
        }else {
            printAllWords();
            Helper.matchSucceded = true;
        }
    }

    /**
     * Trys to replace a character that converges to destination word.
     */
    private void loadDirectMatches(){
        for(int currentPos = 0; currentPos < unMatchedPositions.length; currentPos++){
            if(!unMatchedPositions[currentPos]){
                char[] nextWord = Helper.checkWord(src,currentPos,Helper.target[currentPos]);
                 if (nextWord != null){
                     nextPossibleNode.add(new Node(nextWord,this));
                 }
            }
        }
    }

    /**
     * Finds random word by looping all alphabets
     */
    private void loadIndirectMatches(){
        for(int currentPos = 0; currentPos < unMatchedPositions.length; currentPos++){
            if(!unMatchedPositions[currentPos]){
                Helper.exceptionList.add(Arrays.toString(this.src));
                char[] nextWord = Helper.loopAlphabets(src,currentPos);
                if (nextWord != null && !Helper.exceptionList.contains(Arrays.toString(nextWord))){
                    nextPossibleNode.add(new Node(nextWord,this));
                }
            }
        }

    }

    /**
     * if this method executes then it brings smile :-)
     */
    private void printAllWords(){
        Stack<String> linkedWords = new Stack();
        Node parentNode = this.parentNode;
        linkedWords.push(String.copyValueOf(this.src));
        while (parentNode != null) {
            linkedWords.push(String.copyValueOf(parentNode.src));
            parentNode = parentNode.parentNode;
        }

        System.out.println("yo yo !!");
        while (!linkedWords.empty()){
            System.out.println(linkedWords.pop());
        }
    }

}
