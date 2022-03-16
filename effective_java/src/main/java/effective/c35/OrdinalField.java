package effective.c35;

public enum OrdinalField {
    APPLE(1), CARROT(2);

    private final int intType;

    OrdinalField(int intType) {
        this.intType = intType;
    }

    int intType(){
        return intType;
    }

    public static void main(String[] args) {
        System.out.println("OrdinalField.APPLE.intType(); = " + OrdinalField.APPLE.intType());
    }
}
