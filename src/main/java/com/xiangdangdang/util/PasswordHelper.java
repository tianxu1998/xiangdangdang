package com.xiangdangdang.util;

import com.xiangdangdang.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.omg.CORBA.StringHolder;

public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithName = "MD5";

    private int hashInterations = 2;

    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;
    }

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getAlgorithName() {
        return algorithName;
    }

    public void setAlgorithName(String algorithName) {
        this.algorithName = algorithName;
    }

    public int getHashInterations() {
        return hashInterations;
    }

    public void setHashInterations(int hashInterations) {
        this.hashInterations = hashInterations;
    }

    public void encryptPassword(User user) {
        if (user.getPassword() != null) {
            user.setSalt(randomNumberGenerator.nextBytes().toHex());

            String newPasswd = new SimpleHash(
                    algorithName,
                    user.getPassword(),
                    user.getSalt(),this.hashInterations).toHex();

            user.setPassword(newPasswd);
        }
    }
}
