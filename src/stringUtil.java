import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


public class stringUtil {
    //encrypt the input string with SHA-256
    public static String applySha256(String input){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //create a message digest object, using SHA-256
            byte[]hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

            //apply SHA-256 to the input string
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getDificultyString(int difficulty) {
        return "0".repeat(difficulty);
    }
}
