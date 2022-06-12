package reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface MethodResolver {
    String execute(Map<String, String> param) throws InvocationTargetException, IllegalAccessException;
}
