import java.security.MessageDigest;


public class stringUtil {
    //encrypt the input string with SHA-256
    public static String applySha256(String input){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //create a message digest object, using SHA-256
            byte[]hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(int i = 0; i < hash.length; i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

            //apply SHA-256 to the input string
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
