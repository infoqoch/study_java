package extend;

import org.junit.jupiter.api.Test;

public class InterfaceCastTest {

    @Test
    void 다운캐스팅시_자식의_매서드는_사용불가(){
        InterfaceParent parent = new ChildOfInterfaceParent();
//        parent.childMethod(); // 컴파일 오류
        ((ChildOfInterfaceParent) parent).printOfChildMember(); // 이렇게 이상하게 하니까 된다. 근데 사실은 아래의 메서드와 같다.
    }

    @Test
    void 부모타입의_자식객체는_부모가된다(){
        InterfaceParent parent = new ChildOfInterfaceParent();
        ChildOfInterfaceParent parent1 = (ChildOfInterfaceParent) parent;
        parent1.setterOfChildMethod("자식으로 변환한 부모의 세터를 넣는다.");
        parent1.printOfChildMember(); // 위의 값이 호출된다. 
    }

    @Test
    void 데이타타입자식_역시_부모가된다(){
        ChildOfInterfaceParent pureChild = new ChildOfInterfaceParent();
        InterfaceParent parent = pureChild; // 된다.
    }

    @Test
    void 데이타타입자식이_부모가되었다_자식이되면_자식맴버데이터는_유지가된다(){
        ChildOfInterfaceParent child = new ChildOfInterfaceParent();
        child.setterOfChildMethod("data");
        InterfaceParent childUpCasted = child;
        ChildOfInterfaceParent childDowncastAfterUpCasted = (ChildOfInterfaceParent) childUpCasted;
        System.out.println("----");
        childDowncastAfterUpCasted.printOfChildMember();
    }
    
    
    
    interface InterfaceParent {
        void parentMethod();
    }

    class ChildOfInterfaceParent implements InterfaceParent {
        private String childMember;

        @Override
        public void parentMethod() {
            System.out.println("부모의 매서드");
        }

        public void setterOfChildMethod(String var){
            childMember = var;
        }

        public void printOfChildMember(){
            if(childMember==null){
                System.out.println("정의되지 않았다.");
            }else{
                System.out.println(childMember);
            }
        }
    }
}




