package access.b;

import access.a.AccessTest;

public class AccessTestTest {
    public static void main(String[] args) {
        // final String protectedField = AccessTest.PROTECTED_FIELD; // 컴파일 오류가 발생한다.
        final String publicField = AccessTest.PUBLIC_FIELD;
    }
}

class AccessExtends extends  AccessTest{
    public static void main(String[] args) {
        final String protectedField = AccessTest.PROTECTED_FIELD;
        final String publicField = AccessTest.PUBLIC_FIELD;
        // final String packagePrivateField = AccessTest.PACKAGE_PRIVATE_FIELD;
    }

}
