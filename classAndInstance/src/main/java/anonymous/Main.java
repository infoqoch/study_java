package anonymous;

public class Main {
    final AbstractParent abstractParent = new AbstractParent() { // 필드
        @Override
        void helloAbstract() {
            System.out.println("hello abstract!");
        }
    };

    public static void main(String[] args) {
        final InterfaceParent interfaceParent = new InterfaceParent() { // 로컬 변수
            @Override
            public void helloInterface() {
                System.out.println("hello interface!");
            }

            String newField ="newField";
            void newMethod(){
                System.out.println("new method");
            }
        };

        interfaceParent.helloInterface();
        // interfaceParent.newField; // 부모의 인스턴스에 종속되기 때문에, 새롭게 선언된 메서드나 필드에는 접근할 수 없다.
        // interfaceParent.newMethod();
    }

    static abstract class SampleClass{
        void method1(InterfaceParent interfaceParent) {}
        void method2() {

            method1(new InterfaceParent(){
                @Override
                public void helloInterface() {
                    System.out.println("hihi!!");
                }
            }); // 매개변수로 익명 객체가 사용될 수 있다.
        }
    }
}
