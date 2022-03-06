package inner.places;

public class SampleClass {

    // 인스턴스가 클래스의 중첩 클래스가 될 수 있으며,
    // 클래스가 인스턴스의 중첩 클래스가 될 수 있다.
    interface InnerInterface{
        int MAX_VALUE = 1234;
        String generateName();

        class InnerClassInInterface{
            String name;
            void printName(){
                System.out.println("name = " + name);
            }
        }
    }

    static String staticField;
    String instanceField;

    // 맴버 클래스, 인스턴스 맴버 클래스
    // 인스턴스 맴버 클래스는 어떤 필드에도 접근할 수 있다.
    class InstanceInnerClass{
        void sayGoodBye(){
            System.out.println("good bye~~");
            System.out.println("instanceField = " + instanceField);
            System.out.println("staticField = " + staticField);
        }
    }

    // 맴버 클래스, 정적 맴버 클래스
    // 정적 맴버 클래스는 인스턴스 필드에 접근할 수 없다.
    static class StaticInnerClass{
        void sayHello(){
            System.out.println("hello!");
            // System.out.println("instanceField = " + instanceField);
            System.out.println("staticField = " + staticField);
        }
    }


    // 인스턴스 매서드에서, 인스턴스 맴버 클래스와 정적 클래스를 선언하고 초기화함에 있어 제한이 없다.
    void instanceMethod(){
        final InstanceInnerClass instanceInnerClass = new InstanceInnerClass();
        final StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    // 정적 매서드에서, 인스턴스 매서드는 선언 및 초기화 불가능하다.
    static void staticMethod(){
        // final InstanceInnerClass instanceInnerClass = new InstanceInnerClass(); // 컴파일 에러
        final StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
