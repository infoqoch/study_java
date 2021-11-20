package extend;

import org.junit.jupiter.api.Test;

public class AbstractCastTest {

    @Test
    void 다운캐스팅시_자식의_매서드는_사용불가(){
        AbstractParent parent = new ChildOfAbstractParent();
//        parent.childMethod(); // 컴파일 오류
    }

    @Test
    void 부모타입의_자식객체는_부모가된다(){
        AbstractParent parent = new ChildOfAbstractParent();
        ChildOfAbstractParent parent1 = (ChildOfAbstractParent) parent;
        parent1.childMethod();
    }

    @Test
    void 데이타타입자식_역시_부모가된다(){
        ChildOfAbstractParent pureChild = new ChildOfAbstractParent();
        AbstractParent parent = pureChild; // 된다.
    }
    
    abstract class AbstractParent {
        abstract void parentAbstractMethod();
        void noneAbstractMethod(){
            System.out.println("call none abstract method");
        }
    }

    class ChildOfAbstractParent extends AbstractParent {
        private String childMemberForParentMethod;

        private String childMember;
        
        void childMethod(){
            System.out.println("자식의 구현 매서드 호출");
        }

        @Override
        void parentAbstractMethod() {
            if(childMember==null){
                System.out.println("정의되지 않았다.");
            }else{
                System.out.println(childMember);
            }
        }
    }
}




