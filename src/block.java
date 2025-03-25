import java.util.Date;


    public class block {
        public String hash;
        public String previousHash;
        private String data;
        private long timeStamp;
        private int nonce;

        //constructor
        public block(String data, String previousHash) {
            this.data = data;
            this.previousHash = previousHash;
            this.timeStamp = new Date().getTime(); //get current time
            this.hash = calculateHash();

        }

        public String calculateHash() {
            String calculatedhash = stringUtil.applySha256(
                    previousHash +
                            Long.toString(timeStamp) + //long essentially is a 64-bit signed two's complement integer
                            data
            );
            return calculatedhash;
        }

        public void mineBlock(int difficulty){
            String target = new String(new char[difficulty]).replace('\0', '0');
            while(!hash.substring(0, difficulty).equals(target)){
                nonce++;
                hash = calculateHash();
            }
            System.out.println("Block Mined!!! : " + hash);

        }
    }
