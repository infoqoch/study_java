package effective.c03;

public class SampleSingleton {
    private static final SampleSingleton NOW = new SampleSingleton();

    private SampleSingleton(){
        throw new AssertionError();
    }

    public static SampleSingleton getInstance(){
        return NOW;
    }

}
