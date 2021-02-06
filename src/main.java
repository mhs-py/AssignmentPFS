/**
 * @author Mahesh Miragi
 */
public class main {

    public static void main(String args[]){

        Helper.validateInputs(args);
        Node rootNode = new Node(args[0].toCharArray(),null);
        rootNode.process();

        if(!Helper.matchSucceded){
            System.out.println("Oops ! Link cannot be established");
        }

    }
}
