package interfaces;

public class ImplMethodsOnInterfaceImpl implements  ImplMethodsOnInterface{
    private String name;

    @Override
    public String overrideThis(String name) {
        this.name = name;
        return "hi : " + name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
