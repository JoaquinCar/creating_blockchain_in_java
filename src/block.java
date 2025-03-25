import java.util.Date;


    public class block {
        public String hash;
        public String previousHash;
        private String data;
        private long timeStamp;

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
    }
