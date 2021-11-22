package function;

@FunctionalInterface // 하나의 오버라이드를 할 매서드만을 허락함.
public interface FunctionalInterfaceConsumer {

    void execute();

    default void hello(){ // 디폴트는 상관 없음.
        System.out.println("hi");
    }
}
