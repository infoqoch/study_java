package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

public class MyMethodResolver implements MethodResolver {
    private final Method method;

    public MyMethodResolver(Method method) {
        this.method = method;
    }

    @Override
    public String execute(Map<String, String> param) throws InvocationTargetException, IllegalAccessException {
        final Parameter[] parameters = method.getParameters();
        final Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("parameterType = " + parameterType);
        }
        Object[] parsedParams = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            System.out.println("parameters[i].getName() = " + parameters[i].getName());
            final String reqValue = param.get(parameters[i].getName());
            if (reqValue == null) continue;
            parsedParams[i] = parsedParams;
        }

        Method[] methods = MyHandler.class.getDeclaredMethods();
        System.out.println("Total methods: "+ methods.length);
        for (Method m : methods) {
            System.out.println();
            System.out.println("Method: "+m.getName());
            for(Parameter p : m.getParameters())
                printParam(p);
        }

        return (String) method.invoke(new MyHandler(), parsedParams[0]);
    }

    public static void printParam(Parameter p) {
        System.out.println("------------ Start -------------");
        System.out.println("Parameter class: "+ p.getType());
        System.out.println("Parameter name "+p.getName());
        System.out.println("Modifiers "+ p.getModifiers());
        System.out.println("------------ End -------------");

    }

}
