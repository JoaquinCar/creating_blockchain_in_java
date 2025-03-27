import java.util.Date;


    public class block {
        public String hash;
        public String previousHash;
        private final String data;
        private final long timeStamp;
        private int nonce;

        //constructor
        public block(String data, String previousHash) {
            this.data = data;
            this.previousHash = previousHash;
            this.timeStamp = new Date().getTime(); //get current time
            this.hash = calculateHash();

        }

        public String calculateHash() {
            //long essentially is a 64-bit signed two's complement integer
            return stringUtil.applySha256(
                    previousHash +
                            timeStamp +
                            nonce +//long essentially is a 64-bit signed two's complement integer
                            data
            );
        }

        public void mineBlock(int difficulty) {
            String target = stringUtil.getDificultyString(difficulty);
            while (!hash.substring(0, difficulty).equals(target)) {
                nonce++;
                hash = calculateHash();
                }
            System.out.println("Block Mined!!! : " + hash);
        }
    }
