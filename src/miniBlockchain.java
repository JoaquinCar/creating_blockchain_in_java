import java.util.ArrayList;
import com.google.gson.GsonBuilder;
public class miniBlockchain{

    public static ArrayList<block> blockchain = new ArrayList<block>();
    public static void main(String[] args) {
        blockchain.add(new block("Hi im the first block", "0"));
        blockchain.add(new block("Hi im the second block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new block("Hi im the third block", blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);




    }
}

