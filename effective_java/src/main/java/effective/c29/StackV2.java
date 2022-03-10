package effective.c29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackV2<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackV2() {
        // 제네릭은 실체화 불가 타입이다.
        // 이번 구현은 return 마다 형변환을 하지 않고, 배열 자체를 초기화할 때 형변환을 한다.
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0)
            throw new EmptyStackException();
        final E result = elements[--size];
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
