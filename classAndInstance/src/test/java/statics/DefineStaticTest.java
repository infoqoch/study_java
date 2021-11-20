package statics;

import org.junit.jupiter.api.Test;

public class DefineStaticTest {
    @Test
    void static이_static블럭에서_정의되다(){
        String staticMember = DefineStatic.staticMember;
        System.out.println(staticMember);
    }

    @Test
    void 싱글톤은_static이어야한다(){
        DefineStatic instance = DefineStatic.getInstance();
        /*
        * 현재는 매서드의 호출단계에서 싱글톤이 구현된 것처럼 보인다. 그러나 모든 static 데이터는 클래스로딩 단계에서 생성된다. 그러니까 클래스로딩 단계에서 해당 인스턴스가 클래스로더에 저장이 되고, 차후 요청할 때는 클래스로더에 있는 인스턴스를 꺼내 사용한다.
        * 싱글톤을 할 때는 반드시 public 생성자를 없애야 한다. 그래야 싱글톤이 보장된다.
        */
        System.out.println(instance.getClass());
    }

}
