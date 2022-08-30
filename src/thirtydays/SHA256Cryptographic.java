package thirtydays;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Cryptographic {

    public static void main(String[] args)  throws NoSuchAlgorithmException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();

        //encoding string by SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        byte[] digest = md.digest();

        //printing encoded string in hexadecimal
        for (byte b : digest) {
            System.out.format("%02x", b);
        }

    }
}
