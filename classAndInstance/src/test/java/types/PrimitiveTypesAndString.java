package types;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypesAndString {
    @Test
    void Stringtest(){
        String a = "java";
        String b = "java";
        System.out.println(a==b);  // true

        String aa = new String("spring");
        String bb = new String("spring");
        System.out.println(aa==bb); // false

        String aaa = "aaa";
        String bbb = aaa;
        System.out.println(aaa==bbb); // true

    }

    @Test
    void string_and_array(){
        String str = "abcdefg";
        int length = str.length();
        String substring = str.substring(0, 3);
        str.charAt(4);
    }

    @Test
    void string_int_null_and_zero(){

        String[] strs = new String[3];
        System.out.println(strs); // 값 : Ljava.lang.String;@3b6eb2ec
        for (String str : strs) {
            System.out.println(str); // 값 : null / null / null
        }

        int[] ints = new int[3];
        System.out.println(ints); // 값 : [I@1e643faf
        for (int i : ints) {
            System.out.println(i); // 값 : 0 / 0 / 0
        }

    }
}
