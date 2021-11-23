package interfaces;

public interface ImplMethodsOnInterface {
    String overrideThis(String name);

    String getName();

    /*
    *
    * @implSpec : 대문자로 바꾼다. null 을 입력하지 않도록 한다.
    * */
    default void dontNeedToOverrideThis(){ // 자식 객체가 구현하지 아니하여도 됨. 다만 자식객체가 구현예정일 것에 대하여 어떤 기능까지도 부여할 수 있음.
        System.out.println(getName().toUpperCase()); // 만약 null 이 들어오면 어떻게 하는가? 에 대한 고민이 필요...
    }

}
