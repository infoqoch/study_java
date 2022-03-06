package statics;

import java.util.UUID;

public class StaticInitBlock {
    public static final String RANDOM_UUID;
    public String instanceField;

    static {
        System.out.println("정적 클래스에 대한 초기화 블록이 실행됩니다!");
        RANDOM_UUID = UUID.randomUUID().toString();

        // instanceField = "abc";
    }

    public static void main(String[] args) {
        System.out.println("StaticInitBlock.RANDOM_UUID = " + StaticInitBlock.RANDOM_UUID);

        // instanceField = "abc";
        final StaticInitBlock instance = new StaticInitBlock();
        instance.instanceField = "abc";
    }
}

