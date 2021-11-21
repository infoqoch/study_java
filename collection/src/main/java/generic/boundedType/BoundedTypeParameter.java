package generic.boundedType;

public class BoundedTypeParameter {

    public static <T extends Number> int compare(T t1, T t2){ // 데이터 타입을 Number 의 하위 타입으로 한정함.
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
        return Double.compare(v1, v2);
    }
}
