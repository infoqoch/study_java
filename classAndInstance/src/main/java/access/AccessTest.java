package access;

public class AccessTest {
    public static void main(String[] args) {
        final String publicField = PackagePrivateClass.PUBLIC_FIELD;
        final String protectedField = PackagePrivateClass.PROTECTED_FIELD;
        final String packagePrivateField = PackagePrivateClass.PACKAGE_PRIVATE_FIELD;
        // final String privatePrivateField = PackagePrivateClass.PRIVATE_PRIVATE_FIELD; // 컴파일 에러

    }
}

class PackagePrivateClass{
    public static final String PUBLIC_FIELD = "hi!";
    protected static final String PROTECTED_FIELD = "hi!";
    static final String PACKAGE_PRIVATE_FIELD = "hi!";
    private static final String PRIVATE_PRIVATE_FIELD = "hi!";
}