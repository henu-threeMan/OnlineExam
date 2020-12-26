package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DigestUtil {
    // 用于将字节数组内容转换为十六进制字符串
    private static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }

    // 对指定字符串进行md5摘要
    public static String md5(String s) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            return toHexString(md5.digest(s.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    // 对指定字符串进行sha1摘要
    public static String sha1(String s) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("sha1");
            return toHexString(sha1.digest(s.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String md5_1 = DigestUtil.md5("admin");
        String md5_2 = DigestUtil.md5("password2");
        System.out.println("MD5 of admin: " + md5_1);
        System.out.println("MD5 of password2: " + md5_2);
        assertNotEquals(md5_1, md5_2);
        assertEquals(md5_1, DigestUtil.md5("admin"));
        // sha1
        String sha1_1 = DigestUtil.sha1("password1");
        String sha1_2 = DigestUtil.sha1("password2");
        System.out.println("sha1 of password1: " + sha1_1);
        System.out.println("sha2 of password2: " + sha1_2);
        assertNotEquals(sha1_1, sha1_2);
        assertEquals(sha1_2, DigestUtil.sha1("password2"));
    }
}



