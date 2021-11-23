package function;

public class MethodRefer {

    private String name;

    public MethodRefer() {
    }

    public MethodRefer(String name) {
        this.name = name;
    }

    public String instanceMethod(String name){
        return "instanceMethod : "+name;
    }

    public static String staticMethod(String name){
        return "staticMethod : "+name;
    }
}
