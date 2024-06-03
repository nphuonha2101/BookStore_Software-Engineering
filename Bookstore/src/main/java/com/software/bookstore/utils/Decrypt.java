package com.software.bookstore.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Decrypt {

    public static String sha256(String input) {
        String secret = Files.env("hash.secret");
        input += secret;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static boolean compare(String original, String hashed) {
        String compare = sha256(original);
        return compare.equals(hashed);
    }

    public static String hmacSha512(String secretKey, String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
            mac.init(secretKeySpec);
            byte[] digest = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            // Convert the digest bytes to a hex string
            BigInteger bigInt = new BigInteger(1, digest);
            StringBuilder hexString = new StringBuilder(bigInt.toString(16));

            // Pad with 0s to ensure the hex string has a length of 128
            while (hexString.length() < 128) {
                hexString.insert(0, "0");
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmacSHA512", e);
        }
    }
}
