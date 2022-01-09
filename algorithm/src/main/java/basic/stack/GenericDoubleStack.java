package basic.stack;

import utils.PrettyPrinter;

public class GenericDoubleStack<E> {
    private int max;
    private int leftPointer;
    private int rightPointer;
    private E[] stack;

    public void clear(){
        stack = (E[]) new Object[max];
        leftPointer = 0;
        rightPointer = max-1;
    }
    public GenericDoubleStack(int capacity){
        max = capacity;
        stack = (E[]) new Object[max];
        leftPointer = 0;
        rightPointer = max-1;
    }

    public void pushLeft(E v){
        if(max <= getTotalSize())
            throw new OverFlowGenericDoubleStackException();

        stack[leftPointer++] = v;
    }

    public void pushRight(E v){
        if(max <= getTotalSize())
            throw new OverFlowGenericDoubleStackException();

        stack[rightPointer--] = v;
    }

    public E popLeft(){
        if(leftPointer<=0)
            throw new EmptyGenericDoubleStackException();

        return stack[--leftPointer];
    }

    public E popRight(){
        if(rightPointer>=max-1)
            throw new EmptyGenericDoubleStackException();

        return stack[++rightPointer];
    }

    public int getTotalSize() {
        return getLeftSize() + getRightSize();
    }

    public int getRightSize(){
        return (max-rightPointer-1);
    }

    public int getLeftSize(){
        return leftPointer;
    }


    public boolean isFull(){
        return getTotalSize()>=max-1?true:false;
    }
    public boolean isEmpty(){
        return getTotalSize()<=0?true:false;
    }


    // 0 1 2 3 4 5 6 7 8 9
    // 1 2 3 0 0 0 1 0 2 0
    //     L       R
    public void print(){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for(int i=0; i<stack.length; i++){
            PrettyPrinter line1 = new PrettyPrinter(i);
            PrettyPrinter line2 = new PrettyPrinter(stack[i]);

            String status  = "";
            if(leftPointer==i+1)
                status = "L";
            else if(rightPointer == i-1)
                status = "R";
            PrettyPrinter line3 = new PrettyPrinter(status);

            int max = PrettyPrinter.maxLength(line1.getLength(), line2.getLength(), line3.getLength());

            line1.setMaxLength(max);
            line2.setMaxLength(max);
            line3.setMaxLength(max);

            sb1.append(line1.toStringWithSpace()).append(" ");
            sb2.append(line2.toStringWithSpace()).append(" ");
            sb3.append(line3.toStringWithSpace()).append(" ");
        }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3.toString());

    }

}
class OverFlowGenericDoubleStackException extends RuntimeException{}

class EmptyGenericDoubleStackException extends RuntimeException{}

