package effective.c31;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
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

    public void pushAll(Iterable<E> src){
        for (E e : src) {
            push(e);
        }
    }

    // 생산자, 데이터를 내보낸다.
    public void pushAll2(Iterable<? extends E> src){
        for (E e : src) {
            push(e);
        }
    }

    public void popAll(Collection<E>dst){
        while(!isEmpty())
            dst.add(pop());
    }

    // 그냥 와일드카드<?>와 달리 데이터를 넣어도 정상 동작한다.
    // 소비자, 데이터를 받는다.
    public void popAll2(Collection<? super E>dst){
        while(!isEmpty())
            dst.add(pop());
    }
}
