package interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplMethodsOnInterfaceTest {
    @Test
    void default는_override_안해도됨(){
        ImplMethodsOnInterface impl = new ImplMethodsOnInterfaceImpl();
        System.out.println(impl.overrideThis("hhi"));
        impl.dontNeedToOverrideThis();
    }

}