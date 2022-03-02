package effective.c17;

public final class PhoneNumberV2 {
    private final int areaCode, prefix, lineNum;

    private PhoneNumberV2(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    public static PhoneNumberV2 valueOf(int areaCode, int prefix, int lineNum){
        return new PhoneNumberV2(areaCode, prefix, lineNum);
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
