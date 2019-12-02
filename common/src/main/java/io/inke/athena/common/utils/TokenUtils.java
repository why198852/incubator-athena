package io.inke.athena.common.utils;

import org.springframework.util.ObjectUtils;

import java.security.MessageDigest;
import java.util.UUID;

public class TokenUtils {

    private static final char[] hexCode = "12wsd465rfg89ghnvbm0c".toCharArray();

    public static String toHexString(byte[] data) {
        if (ObjectUtils.isEmpty(data)) {
            return null;
        }
        StringBuilder builder = new StringBuilder(data.length * 2);
        for (byte b : data) {
            builder.append(hexCode[(b >> 4) & 0xF]);
            builder.append(hexCode[(b & 0xF)]);
        }
        return builder.toString().toUpperCase();
    }

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString().toUpperCase());
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest).toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException("Token cannot be generated.", e);
        }
    }

}
