package generic;


public class ObjectList {
    private Object[] vars;
    private int current;

    public ObjectList() {
        vars = new Object[3];
        current = 0;
    }

    public void add(Object obj) {
        vars[current] = obj;
        current ++;
    }

    public void clear() {
        current = 0;
    }

    public int size() {
        return current;
    }

    public Object get(int index) {
        if(current <= index)
            throw new IndexOutOfBoundsException();
        return vars[current];
    }
}
