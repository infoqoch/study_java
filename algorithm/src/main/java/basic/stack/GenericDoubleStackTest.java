package basic.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericDoubleStackTest {

    @Test
    void 테스트(){
        GenericDoubleStack<Integer> stack = new GenericDoubleStack<>(5);

        try{
            stack.popLeft();
        }catch (EmptyGenericDoubleStackException e){

        }

        stack.pushLeft(1);
        stack.print();

        stack.pushRight(5);
        stack.print();


        stack.popLeft();
        stack.print();

        stack.popRight();
        stack.print();
    }

}