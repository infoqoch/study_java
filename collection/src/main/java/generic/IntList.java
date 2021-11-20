package generic;

public class IntList{
    private int[] vars;
    private int current;

    public IntList() {
        vars = new int[3];
        current = 0;
    }

    public void add(int num) {
        vars[current] = num;
        current ++;
    }

    public void clear() {
        current = 0;
    }

    public int size() {
        return current;
    }

    public int get(int index) {
        if(current <= index)
            throw new IndexOutOfBoundsException();
        return vars[current];
    }
}
