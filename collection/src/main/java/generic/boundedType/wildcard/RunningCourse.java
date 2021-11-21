package generic.boundedType.wildcard;

public class RunningCourse<T, M> extends Course<T>{
    private String name;
    private T[] students;
    private M runningType;

    public RunningCourse(String name, int capacity, M m) {
        super(name, capacity);
        this.name = name;
        this.students = (T[]) new Object[capacity];
        this.runningType = m;
    }

    public M getRunningType() {
        return runningType;
    }
}
