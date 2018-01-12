package view;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encryptor {
    
        public static String Encrypt(String originalMessage) {
            byte[] message = originalMessage.getBytes(StandardCharsets.UTF_8);
            String encoded = Base64.getEncoder().encodeToString(message);;
            return encoded;
        }

        public static String Decrypt(String encrypted) {
            byte[] decoded = Base64.getDecoder().decode(encrypted);
            return new String(decoded, StandardCharsets.UTF_8);
        }

        public static void main(String[] args) {       
            String test = "hello";
            String encoded = Encrypt(test);
            System.out.println(encoded);
            // => aGVsbG8gd29ybGQ=

            String decoded = Decrypt(encoded);
            System.out.println(decoded);
            // => hello world
        }
}