/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 5
Write a Program That Performs Encryption/Decryption.
*/

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

class EncryptionDecryptionExample {
    public static void main(String[] args) {
        try {
            String plainText = "Ruchit This is a secret message.";
            String encryptionKey = "MyEncryptionKey01123456789111213";

            // Encryption
            String encryptedText = encrypt(plainText, encryptionKey);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decryption
            String decryptedText = decrypt(encryptedText, encryptionKey);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String plainText, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}

/*
OUTPUT
Encrypted Text: 8mmfIuy+onffOdQqcEuM11V42avgVdPRAUKlppXH7agNulVPBds0yZlPiM13wUsl
Decrypted Text: Ruchit This is a secret message.
*/