package com.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class FixedKeyEncryption {
    public static void main(String[] args) {
        try {
            String keyString = "chiave-segreta123"; // La tua chiave deve essere lunga 16, 24 o 32 byte per AES
            SecretKeySpec key = new SecretKeySpec(keyString.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String original = "passwordDaCifrare";
            byte[] encrypted = cipher.doFinal(original.getBytes("UTF-8"));
            String encryptedString = Base64.getEncoder().encodeToString(encrypted);
            System.out.println("Encrypted: " + encryptedString);

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            String decryptedString = new String(decryptedBytes, "UTF-8");
            System.out.println("Decrypted: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
