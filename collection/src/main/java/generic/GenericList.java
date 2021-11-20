package generic;

public class GenericList<T> {
    private Object[] vars; // 제너릭(여기선 T)으로 구현한다 하더라도 데이타는 Object 타입이어야만 한다. 다만 아래의 return 과 같이 형변환을 제너릭으로 정의한 값으로 할 수 있을 뿐이다.
    private int current;

    public GenericList() {
        vars = new Object[3];
        current = 0;
    }

    public void add(T obj) {
        vars[current] = obj;
        current ++;
    }

    public void clear() {
        current = 0;
    }

    public int size() {
        return current;
    }

    public T get(int index) {
        if(current <= index)
            throw new IndexOutOfBoundsException();
        return (T) vars[current];
    }
}
