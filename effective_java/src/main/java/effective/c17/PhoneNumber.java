package effective.c17;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {
    private final int areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static int rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return val;
    }

    @Override
    public String toString() {
        return "전화번호는 다음과 같습니다 : "+ areaCode + "-"+ prefix +"-"+ lineNum;
    }
}

