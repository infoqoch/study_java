package cipher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.UUID;

class Aes256CipherTest {
    @Test
    void 테스트_encode_encode() throws Exception {
        for(int i=1; i<100; i++) {
            final String key = UUID.randomUUID().toString().replace("-", "").substring(0, 32).toUpperCase(Locale.ROOT);
            final String iv = UUID.randomUUID().toString().replace("-", "").substring(0, 16).toUpperCase(Locale.ROOT);
            System.out.println("key : " + key);
            System.out.println("iv : " + iv);
            System.out.println("========");

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                sb.append(UUID.randomUUID().toString().replace("-", ""));
            }
            final String given = sb.toString();

            final String digest = Aes256Cipher.encode(key, iv, given);
            System.out.println(digest);

            final String then = Aes256Cipher.decode(key, iv, digest);
            System.out.println(then);

            Assertions.assertThat(then).isEqualTo(given);
        }
    }

}