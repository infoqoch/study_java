package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrettyPrinterTest {

    @Test
    void 프리티프린터테스트(){
        int a = 99999;
        int b = 11;
        int c = 666;

        int num = 3;

        // 처음부터 글자를 늘릴 수는 없음. 최대값이 나와야 함.
        // 1. 각자의 길이를 구한다.
        // 2. 모두의 길이 중 최대 길이를 구한다.
        // 3. 최대 길이와 각자의 길이의 남은 숫자만큼 스페이스를 삽입한다.

        PrettyPrinter aa = new PrettyPrinter(a);
        PrettyPrinter bb = new PrettyPrinter(b);
        PrettyPrinter cc = new PrettyPrinter(c);

        int max = PrettyPrinter.maxLength(aa.getLength(), bb.getLength(), cc.getLength());

        aa.setMaxLength(max);
        bb.setMaxLength(max);
        cc.setMaxLength(max);

        System.out.println(aa.toStringWithSpace()+"!");
        System.out.println(bb.toStringWithSpace()+"!");
        System.out.println(cc.toStringWithSpace()+"!");
    }
}