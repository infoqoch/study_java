package extend;

/*
* final 과 상속과의 관계를 확인하였다. 클래스가 final 일 경우 상속받지 못한다. 맴버나 매서드는 존재하더라도 상속이 가능하다.
* final abstract method 는 컴파일 오류가 발생한다. 미리 정의하지 않은 final 은 불가능할테니.
*/
public class AbstractClassWithFinalTest {

    class ParentWithFinalMember {
        private final String finalMember = "final member";
//    private final String finalMemberNotDefined; // 컴파일에러
    }

    class Child extends ParentWithFinalMember {
        public void helloWorld(){
            System.out.println("hi");
        }
    }

    final class FinalClassParent{
        private final String finalMember = "final member";
    }

// class ChildOfFinalParent extends FinalClassParent{ }

    class ParentWithFinalMethod{
        public final void finalMethod(){
            System.out.println("final Method");
        }
    }

    class ChildOfParentWithFinalMethod extends ParentWithFinalMethod{
//        @Override
//        public void finalMethod() { // final 이 존재하는 매서드는 override 할 수 없다.
//        public void finalMethod() { // final 이 존재하는 매서드는 override 할 수 없다.
//            super.finalMethod();
//        }
    }

//class ParentWithFinalAbstractMethod{
//    public final abstract void finalMethod();
//}

}

