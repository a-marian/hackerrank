package greedy;

import java.util.*;


public class FraudulentActivities {
    static class Window  {
        PriorityQueue<Integer> firstQueue = new PriorityQueue<>((a, b) -> b -a);
        PriorityQueue<Integer> secondQueue = new PriorityQueue<>();

        void insert(int x){
            //is x greater that first element from secondQueue add x to secondQueue
            if (secondQueue.isEmpty() || x >= secondQueue.peek()){
                secondQueue.offer(x);
            } else  {
                firstQueue.offer(x);
            }
            adjustSizes();
        }
        void remove(int x){
            if(x >= secondQueue.peek()){
                secondQueue.remove(x);
            } else {
                firstQueue.remove(x);
            }
            adjustSizes();
        }

        private void adjustSizes(){
            if(firstQueue.size() > secondQueue.size()){
                int higherInFirstQueue = firstQueue.poll();
                secondQueue.offer(higherInFirstQueue);
            } else if (secondQueue.size() > firstQueue.size() + 1){
                int lowerInSecondQueue = secondQueue.poll();
                firstQueue.offer(lowerInSecondQueue);
            }
        }

        double median(){
            if (secondQueue.size() > firstQueue.size()) {
                return secondQueue.peek();
            } else {
                return ( firstQueue.peek() + secondQueue.peek()) /2.0;
            }
        }

        @Override
        public String toString() {
            return firstQueue + " - "+ secondQueue;
        }
    }

    static int activityNotifications(List<Integer> expenditure, int d){
        int numWarnings=0;

        Window window = new Window();
        for (int i = 0; i < d; i++) {
            window.insert(expenditure.get(i));
        }

        for (int i = d; i < expenditure.size() ; i++) {
            int currentExpend = expenditure.get(i);
            double median = window.median();

            if (currentExpend >= 2.0 * median){
               ++numWarnings;
            } else {
                System.out.println("NO: " + currentExpend);
            }
            window.remove(expenditure.get(i-d));
            window.insert(currentExpend);
        }

        return  numWarnings;
    }

    public static void main(String[] args) {
        int d = 5;
        List test0 = new ArrayList(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5));
        System.out.println(activityNotifications(test0, d ));

    //    int d1 = 0;
      //  List test1 = new ArrayList(Arrays.asList(10, 20, 30, 40, 50));
       // System.out.println(activityNotifications(test1, d1));

        //List test2 = new ArrayList(Arrays.asList(10, 20, 30, 40, 50));
       // System.out.println(activityNotifications(test2, ));

    }
}
