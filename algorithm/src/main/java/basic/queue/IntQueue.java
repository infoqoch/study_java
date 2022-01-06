package basic.queue;

public class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int size;
    private int[] queue;

    public IntQueue(int capacity){
        this.max = capacity;
        this.front = 0; // 디큐의 정확한 위치
        this.rear = 0; // 인큐를 예정할 위치
        this.size = 0;
        this.queue = new int[capacity];
    }

    public void push(int v) {
        if(size>=max-1)
            throw new OverFlowIntQueueException();

        queue[rear++]=v;

        size++;

        if(rear>=max)
            rear = 0;
    }

    public int pop(){
        if(size<=0)
            throw new EmptyIntQueueException();

        int result = queue[front++];

        size--;

        if(front>=max)
            front = 0;

        return result;
    }

    public void print(){
        System.out.printf("size : %d, front : %d, rear : %d \n", size, front, rear);
        for(int i=0; i<size; i++){
            int idx = rear-front;
            if(idx>=max){
                idx = 0;
            }
            System.out.print(queue[i]);
            System.out.print(" ");
        }
    }

    public class OverFlowIntQueueException extends RuntimeException{}

    public class EmptyIntQueueException extends RuntimeException{}


}
