package interfaces.a;

import java.time.LocalDateTime;

public interface InterfaceJava8 {

    String abc =  "abc";

    LocalDateTime getDate();

    default String defaultMethod(){
        return "defaultMethod";
    }

    static String staticMethod(){
        return "staticMethod";
    }

}
