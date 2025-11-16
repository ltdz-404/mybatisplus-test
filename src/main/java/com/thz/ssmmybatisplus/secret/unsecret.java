package com.thz.ssmmybatisplus.secret;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.HexFormat;
public class unsecret {
    public static void main(String[] args) {
        try {
            // 密钥和IV（16进制字符串）
            String keyHex = "3a98b5cc0dc700d0c40daf3005f73640a68ea1f347ed83dcb7bd8254b358f0b9";
            String ivHex = "13e40838ada742b288be7ddd4577a25d";

            // 密文（16进制字符串）
            String encryptedHex = "baae403d012e34590017a94254e4926732f7e6b08e59d08a5ca9d92fe18ae8da6607afa76f2685914d9d738c9a7a0bc3";

            // 解密
            String decryptedText = decryptAES256CBC(encryptedHex, keyHex, ivHex);

            System.out.println("解密后的明文：");
            System.out.println(decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decryptAES256CBC(String encryptedHex, String keyHex, String ivHex) throws Exception {
        // 将16进制字符串转换为字节数组
        byte[] keyBytes = hexStringToByteArray(keyHex);
        byte[] ivBytes = hexStringToByteArray(ivHex);
        byte[] encryptedBytes = hexStringToByteArray(encryptedHex);

        // 创建密钥和IV对象
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // 初始化解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        // 解密
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // 转换为字符串
        return new String(decryptedBytes, "UTF-8");
    }

    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }

}
