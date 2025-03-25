import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class miniBlockchain{

    public static ArrayList<block> blockchain = new ArrayList<block>();
    public static void main(String[] args) {
        blockchain.add(new block("Hi im the first block", "0"));
        blockchain.add(new block("Hi im the second block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new block("Hi im the third block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new block("Hi im the fourth block", blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
        System.out.println("Is the blockchain valid? " + ChainValid());
    }
    public static boolean ChainValid(){
        block currentBlock;
        block previousBlock;

        for (int i=1; i<blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if (!currentBlock.hash.equals(currentBlock.calculateHash())){ //actual con su hash calculado
                System.out.println("Hashes are not equal");
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)){ //anterior y actual
                System.out.println("Previous Hashes are not equal");
                return false;
            }
        } return true;
    }
}

