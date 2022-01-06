package basic.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntDoubleStackTest {

    @Test
    void 예외테스트(){
        //given
        final IntDoubleStack stack = new IntDoubleStack(5);

        // 초과 입력
        Assertions.assertThatThrownBy(() -> {
            stack.popLeft();
        }).isInstanceOf(IntDoubleStack.EmptyIntDoubleStackException.class);

        Assertions.assertThatThrownBy(() -> {
            stack.popLeft();
        }).isInstanceOf(IntDoubleStack.EmptyIntDoubleStackException.class);

        stack.print();
        stack.pushLeft(1);
        stack.print();
        stack.pushLeft(2);
        stack.print();
        stack.pushLeft(3);
        stack.print();
        stack.pushLeft(4);
        stack.print();
        stack.pushRight(9);
        stack.print();

        // 초과 입력
        Assertions.assertThatThrownBy(() -> {
            stack.pushRight(8);
        }).isInstanceOf(IntDoubleStack.OverFlowIntDoubleStackException.class);

        Assertions.assertThatThrownBy(() -> {
            stack.pushLeft(8);
        }).isInstanceOf(IntDoubleStack.OverFlowIntDoubleStackException.class);
    }

    @Test
    void 사이즈테스트(){
        //given
        final IntDoubleStack stack = new IntDoubleStack(5);

        // when
        stack.pushLeft(1);
        stack.pushLeft(2);
        stack.pushRight(5);
        stack.pushRight(4);
        stack.pushRight(3);

        // then
        Assertions.assertThat(stack.getLeftSize()).isEqualTo(2);
        Assertions.assertThat(stack.getRightSize()).isEqualTo(3);
        Assertions.assertThat(stack.getTotalSize()).isEqualTo(5);
    }

    @Test
    void fullOrEmpty(){
        // given
        final IntDoubleStack stack = new IntDoubleStack(5);

        // when

        // then 비었을 때
        Assertions.assertThat(stack.isEmpty()).isEqualTo(true);
        Assertions.assertThat(stack.isFull()).isEqualTo(false);

        // when
        stack.pushLeft(1);
        stack.pushLeft(2);
        stack.pushRight(5);

        // then 어설프게 채웠을 떄
        Assertions.assertThat(stack.isEmpty()).isEqualTo(false);
        Assertions.assertThat(stack.isFull()).isEqualTo(false);

        // when
        stack.pushRight(4);
        stack.pushRight(3);

        // then 가득 찼을 떄
        Assertions.assertThat(stack.isEmpty()).isEqualTo(false);
        Assertions.assertThat(stack.isFull()).isEqualTo(true);
    }

    @Test
    void clearTest(){

        // when
        final IntDoubleStack stack = new IntDoubleStack(5);

        // given
        stack.pushLeft(1);
        stack.pushLeft(2);
        stack.pushRight(5);
        stack.pushRight(4);
        stack.pushRight(3);
        stack.print();

        // then
        stack.clear();
        stack.print();
        Assertions.assertThat(stack.getTotalSize()).isEqualTo(0);
        Assertions.assertThat(stack.getLeftSize()).isEqualTo(0);
        Assertions.assertThat(stack.getRightSize()).isEqualTo(0);
    }

    @Test
    void 테스트_푸쉬_팝(){
        final IntDoubleStack stack = new IntDoubleStack(5);

        // 왼쪽에 넣고 왼쪽을 뺀다.
        stack.pushLeft(1);
        stack.print();
        Assertions.assertThat(stack.popLeft()).isEqualTo(1);
        Assertions.assertThat(stack.getLeftSize()).isEqualTo(0);

        // 왼쪽에 두 번 넣고 왼쪽에 두 번 뺀다.
        stack.clear();
        stack.pushLeft(1);
        stack.pushLeft(2);
        Assertions.assertThat(stack.popLeft()).isEqualTo(2);
        Assertions.assertThat(stack.popLeft()).isEqualTo(1);
        Assertions.assertThat(stack.getLeftSize()).isEqualTo(0);

        // 오른쪽에 넣고 오른쪽에 뺀다.
        stack.clear();
        stack.pushRight(1);
        Assertions.assertThat(stack.popRight()).isEqualTo(1);
        Assertions.assertThat(stack.getRightSize()).isEqualTo(0);

        // 오른쪽에 두 번 넣고 오른 쪽에 두 번 뺸다.
        stack.clear();
        stack.pushRight(1);
        stack.pushRight(2);
        Assertions.assertThat(stack.popRight()).isEqualTo(2);
        Assertions.assertThat(stack.popRight()).isEqualTo(1);
        Assertions.assertThat(stack.getRightSize()).isEqualTo(0);

        // 왼쪽에 넣고 오른쪽에 넣고 왼쪽에 뺀다.
        stack.clear();
        stack.pushLeft(1);
        stack.pushRight(2);
        stack.print();
        Assertions.assertThat(stack.popLeft()).isEqualTo(1);
        Assertions.assertThat(stack.getRightSize()).isEqualTo(1);

        // 오른쪽에 넣고 왼쪽에 넣고 오른쪽에 뺀다.
        stack.clear();
        stack.pushRight(2);
        stack.pushLeft(1);
        stack.print();
        Assertions.assertThat(stack.popRight()).isEqualTo(2);
        Assertions.assertThat(stack.getRightSize()).isEqualTo(0);

        // 왼쪽 오른쪽 왼쪽 오른쪽에 넣고 왼쪽에 두 번 빼고 오른쪽에 두 번 뺴고 비어있는지 확인한다.
        stack.clear();
        stack.pushLeft(1);
        stack.pushRight(2);
        stack.pushLeft(3);
        stack.pushRight(4);
        stack.print();
        Assertions.assertThat(stack.popRight()).isEqualTo(4);
        Assertions.assertThat(stack.popRight()).isEqualTo(2);
        Assertions.assertThat(stack.getRightSize()).isEqualTo(0);
    }


}