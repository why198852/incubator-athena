package io.inke.athena.common.crypto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptoCommon {

    /**
     * encoder str by bcrypt
     *
     * @param source source char
     * @return encoder char
     */
    public static String bcryptEncoder(CharSequence source) {
        return new BCryptPasswordEncoder().encode(source);
    }

}
