package reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgumentResolverTest {
    @Test
    void test() {
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("name", "kim");

        final Method[] methods = MyHandler.class.getMethods();
        for (Method method : methods) {
            final Parameter[] parameters = method.getParameters();
            Object[] parsedParams = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                final String reqValue = reqParams.get(parameters[i].getName());
                if (reqValue == null) continue;
                parsedParams[i] = parsedParams;
            }
        }
    }

    @Test
    void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final MyHandler myHandler = new MyHandler();
        final String kim = myHandler.method_name("kim");
        final String invoke = (String) MyHandler.class.getMethods()[0].invoke(myHandler, "argssss");
        System.out.println("invoke = " + invoke);
    }

    @Test
    void test3() throws InvocationTargetException, IllegalAccessException {
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("name", "kim");

        final Method method = MyHandler.class.getDeclaredMethods()[0];
        MethodResolver methodResolver = new MyMethodResolver(method);
        String result = methodResolver.execute(reqParams);

        assertThat(result).isEqualTo("hello, kim");
    }
}
