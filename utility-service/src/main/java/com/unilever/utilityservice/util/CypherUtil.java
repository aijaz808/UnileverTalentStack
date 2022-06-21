package com.unilever.utilityservice.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CypherUtil {
    // thisIsASecretKey
    private static byte[] key = { 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41,
            0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79 };

    public static String encrypt(String value, String message) {
        String encryptedValue = null;

        try {

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            encryptedValue = new String(Base64.encodeBase64(cipher.doFinal(value.getBytes())));

        } catch (Exception ex) {
            message = message == null ? ex.getMessage() : message;
            throw new RuntimeException(message);
        }

        return encryptedValue;
    }

    public static String decrypt(String value, String message) {
        String decryptedValue = null;

        try {

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            decryptedValue = new String(cipher.doFinal(Base64.decodeBase64(value.getBytes())));

        } catch (Exception ex) {
            message = message == null ? ex.getMessage() : message;
            throw new RuntimeException(message);
        }

        return decryptedValue;
    }

    public static String encryptEmail(String value) {
        return encrypt(value, "Please provide valid information.");
    }

    public static String decryptEmail(String value) {
        value = replaceSpaceWithPlus(value);
        return decrypt(value, "Please provide valid information.");
    }

    public static String replaceSpaceWithPlus(String value) {
        if (!StringUtil.isEmpty(value)
                && value.split(" ") != null
                && value.split(" ").length > 0) {

            value = value.replace(" ", "+");
        }

        return value;
    }

	/*public static void main(String[] args) {
		System.out.println(CypherUtil.encrypt("529294", "An error"));
		String enc=CypherUtil.encrypt("529294", "An error", true);
		System.out.println(enc);
		String dec=CypherUtil.decrypt(enc, "An error", true);
		System.out.println(dec);
	}*/
}
