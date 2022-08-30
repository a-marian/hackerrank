package miscellaneous.stackAndQueues;

import java.util.*;

public class TaleOfTwoStacks {

    static class MyQueue<T> {
        Queue<Integer> queuey = new LinkedList<>();

        public void enqueue(int val){
            queuey.add(val);
        }

        public int dequeue(){
            return queuey.remove();
        }

        public int peek(){
            return queuey.peek();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
