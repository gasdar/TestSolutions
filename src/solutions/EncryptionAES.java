package solutions;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionAES {

    // El algoritmo AES necesita una clave para cifrar de longitud mínima 16
    // y tiene que ser múltiplo de 8.
    private static final String secretKey = "MiClaveSecretaSecured209";

    public static void main(String[] args) {

        String phrase = "Frase a cifrar";
        Key key = new SecretKeySpec(secretKey.getBytes(), "AES");

        System.out.println("--------------------------");
        System.out.println("A continuación se cifrará la siguiente palabra:");
        System.out.println(phrase);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            System.out.println("--------------------------");
            System.out.println("Cifrando frase...");
            byte[] encWordBytes = cipher.doFinal(phrase.getBytes());
            String encWord = Base64.getEncoder().encodeToString(encWordBytes);
            System.out.println("Frase cifrada: " + encWord);

            System.out.println("--------------------------");
            System.out.println("Descifrando frase...");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decWordBytes = cipher.doFinal(Base64.getDecoder().decode(encWord));
            String decWord = new String(decWordBytes);
            System.out.println("Frase descifrada: " + decWord);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            errorGettingEncryption("Error al obtener el cifrado", e);
        } catch (InvalidKeyException e) {
            errorGettingEncryption("Error llave inválida para cifrado", e);
        } catch (Exception e) {
            errorGettingEncryption("Error inesperado al cifrar o descifrar frase", e);
        }

    }

    private static void errorGettingEncryption(String m, Exception e) {
        System.out.println(m);
        System.err.println(e.getMessage());
        System.err.println("Saliendo del programa");
        System.exit(1);
    }

}
