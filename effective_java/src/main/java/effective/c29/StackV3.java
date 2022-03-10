package effective.c29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackV3<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackV3() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0)
            throw new EmptyStackException();
        // 배열은 Object로 한다. 리턴할 때 형변환을 한다.
        @SuppressWarnings(value = "unchecked")
        final E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
