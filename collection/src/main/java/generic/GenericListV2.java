package generic;

public class GenericListV2<T> { // 메모리 최대치의 동적인 조정
    private Object[] vars;
    private int current;
    private int capacity; // 현재 최대 가용량
    private int amount; // 용량 확장 시 증가 수준

    public GenericListV2() {
        current = 0;
        amount = 3;
        capacity = 3;
        vars = new Object[capacity];

    }

    public void add(T obj) {
        if(current >= capacity){
            capacity += amount;
            Object[] newVars = new Object[capacity];
            for (int i=0; i<vars.length; i++) {
                newVars[i] = vars[i];
            }
            vars = newVars;
        }
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
