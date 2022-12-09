package 队列;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue<T> {
    private T [] queue;
    private int head=0;
    private int tail=0;
    private int maxSize=10;
    public Queue(Class<T> tClass ,int maxSize) {
        this.maxSize=maxSize;
        queue= (T[]) Array.newInstance(tClass,maxSize);
    }
    public int size(){
        return (tail+maxSize-head)%maxSize;
    }
    public boolean isEmpty(){
        return tail==head;
    }
    public boolean isFull(){
        return (tail+1)%maxSize == head;
    }
    public boolean push(T t){
        if(isFull()){
            return false;
        } else {
            queue[(tail++)%maxSize]=t;
            return true;
        }
    }
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }else {
            T temp=queue[head];
            queue[head]=null;
            head=(head+1)%maxSize;
            return temp;
        }
    }

    @Override
    public String toString() {
        return  Arrays.toString(queue);
    }
}
class QueueTest{
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(Integer.class, 10);
        queue.push(10);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.pop();
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(8);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
        queue.push(9);
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
