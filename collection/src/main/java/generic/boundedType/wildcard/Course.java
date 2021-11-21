package generic.boundedType.wildcard;

public class Course <T> {
    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;
        this.students = (T[]) new Object[capacity]; // 제너릭의 배열은 그냥 이런식으로 만든다.
    }

    public String getName() {
        return name;
    }

    public T[] getStudents() {
        return students;
    }

    public void add(T t){
        for(int i=0; i<students.length; i++){
            if(students[i]==null){
                students[i] = t;
                break;
            }
        }
    }
}
