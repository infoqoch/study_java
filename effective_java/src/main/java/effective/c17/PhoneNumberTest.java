package effective.c17;

import org.junit.jupiter.api.Test;

public class PhoneNumberTest {
    public static final PhoneNumber MY_MOTHER_PHONE_NUMBER = new PhoneNumber(111, 123,1235);
    public static final PhoneNumber MY_FATHER_PHONE_NUMBER = new PhoneNumber(222, 321,5321);

    @Test
    void test(){
        System.out.println((new PhoneNumber(222, 123, 1234))); // 참조변수르

        System.out.println("MY_MOTHER_PHONE_NUMBER = " + MY_MOTHER_PHONE_NUMBER);

    }
}
