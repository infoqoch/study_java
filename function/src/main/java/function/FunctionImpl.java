package function;

import java.util.function.Function;

public class FunctionImpl implements Function<String,String>{

    @Override
    public String apply(String s) {
        return "나의 살던 고향은 "+s+"입니다.";
    }
}
