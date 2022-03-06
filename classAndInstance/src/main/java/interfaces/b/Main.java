package interfaces.b;

import interfaces.a.InterfaceJava8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        final Field abc = InterfaceJava8.class.getDeclaredField("abc");
        System.out.println("abc = " + abc);

        final Method getDate = InterfaceJava8.class.getDeclaredMethod("getDate");
        System.out.println("getDate = " + getDate);

        System.out.println("InterfaceJava8.staticMethod() = " + InterfaceJava8.staticMethod());

        final InterfaceJava8 interfaceJava8 = LocalDateTime::now;
        System.out.println("interfaceJava8.defaultMethod() = " + interfaceJava8.defaultMethod());


        System.out.println("InterfaceJava8.class = " + InterfaceJava8.class);
        System.out.println("interfaceJava8.getClass() = " + interfaceJava8.getClass());


    }
}
