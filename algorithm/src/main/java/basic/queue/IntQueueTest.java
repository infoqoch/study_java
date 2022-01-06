package basic.queue;

import org.junit.jupiter.api.Test;

public class IntQueueTest {
    @Test
    void intBuffer테스트1(){
        IntQueue queue = new IntQueue(10);
        queue.print();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.print();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.print();


    }
}
