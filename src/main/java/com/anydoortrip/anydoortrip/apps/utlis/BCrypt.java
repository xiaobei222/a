package com.anydoortrip.anydoortrip.apps.utlis;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

/**
 * 密码的加密与验证
 */
public class BCrypt {

    /**
     * 盐
     */
    private static final String SECRET = "224119e04f236694d37c4f062f31175906fef1833af5cdd15b4300b5b797ddb215436f";

    /**
     * 哈希的轮数
     */
    private static final Integer strength = 10;

    /**
     * BCrypt对象
     */
    private final BCryptPasswordEncoder BCRYPTPASSWORDENCODER;

    public BCrypt() {
        SecureRandom SECURERANDOM = new SecureRandom(SECRET.getBytes());
        this.BCRYPTPASSWORDENCODER = new BCryptPasswordEncoder(strength, SECURERANDOM);
        ;
    }

    /**
     * 加密密码
     *
     * @param password 密码原文
     * @return 密码密文
     */
    public String get_password_hash(String password) {
        // 加密密码
        return this.BCRYPTPASSWORDENCODER.encode(password);
    }

    /**
     * 验证密码
     *
     * @param plain_password  密码原文
     * @param hashed_password 密码密文
     * @return 是否正确
     */
    public Boolean verify_password(String plain_password, String hashed_password) {
        // 是否正确
        return this.BCRYPTPASSWORDENCODER.matches(plain_password, hashed_password);
    }
}
