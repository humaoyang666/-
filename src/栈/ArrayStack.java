package 栈;

import java.util.Arrays;
import java.util.Stack;

public class ArrayStack extends AbstractStack{
    private int top=-1;
    private int [] array;
    private int maxSize;
    public ArrayStack(int maxSize) {
        this.maxSize=maxSize;
        this.array = new int[maxSize];
    }

    @Override
    void push(int val) {
        if(top<maxSize-1){
            this.array[++top]=val;
        }
    }

    @Override
    int pop() {
        return this.array[top--];
    }

    @Override
    int peek() {
        return this.array[top];
    }

    @Override
    int size() {
        return top+1;
    }

    @Override
    boolean isEmpty() {
        return top==-1;
    }

    @Override
    public String toString() {
        return  Arrays.toString(array);
    }
}
class StackTest{
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
    }
}
