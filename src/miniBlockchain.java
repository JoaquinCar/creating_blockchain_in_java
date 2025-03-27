import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class miniBlockchain{

    public static ArrayList<block> blockchain = new ArrayList<>();

    public static int difficulty = 1  ;

    public static void main(String[] args) {
        System.out.println("Trying to Mine block 1... ");
        addBlock(new block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 2... ");
        addBlock(new block("Hi im the second block", blockchain.getLast().hash));
        System.out.println("Trying to Mine block 3... ");
        addBlock(new block("Hi im the third block", blockchain.getLast().hash));
        System.out.println("Trying to Mine block 4... ");
        addBlock(new block("Hi im the fourth block", blockchain.getLast().hash));



        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
        System.out.println("Is the blockchain valid? " + ChainValid());
    }
    public static boolean ChainValid(){
        block currentBlock;
        block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

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

            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)){
                System.out.println("Block wasn't mined");
                return false;
            }
        }
        return true;
    }
    public static void addBlock(block newBlock) {
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);

}
}

