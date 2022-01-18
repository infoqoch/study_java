package cipher;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Aes256Cipher {

    public static String encode(String key, String iv, String plainText) throws Exception {
        if(StringUtils.isBlank(plainText))
            throw new IllegalArgumentException("값을 입력해야 합니다.");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), new IvParameterSpec(iv.getBytes("UTF-8")));

        return new String(Base64.getEncoder().encode(cipher.doFinal(plainText.getBytes("UTF-8"))));
    }

    public static String decode(String key, String iv, String digest) throws Exception {
        if(StringUtils.isBlank(digest))
            throw new IllegalArgumentException("값을 입력해야 합니다.");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), new IvParameterSpec(iv.getBytes("UTF-8")));

        return new String(cipher.doFinal(Base64.getDecoder().decode(digest.getBytes())), "UTF-8");
    }

}
