package com.thz.ssmmybatisplus.secret;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class secret {
    public static void main(String[] args) {
        try {
            String keyHex = "3a98b5cc0dc700d0c40daf3005f73640a68ea1f347ed83dcb7bd8254b358f0b9";
            String ivHex = "13e40838ada742b288be7ddd4577a25d";
            String plaintext = "2321211363_滕昊祖_数科23-12";

            String encryptedHex = encryptAES256CBC(plaintext, keyHex, ivHex);
            System.out.println("加密结果: " + encryptedHex);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptAES256CBC(String plaintext, String keyHex, String ivHex) throws Exception {
        byte[] keyBytes = hexToBytes(keyHex);
        byte[] ivBytes = hexToBytes(ivHex);

        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
        return bytesToHex(encryptedBytes);
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
