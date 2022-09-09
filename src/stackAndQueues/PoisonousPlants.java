package stackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PoisonousPlants {

    public static int poisonousPlants(List<Integer> plants) {
        // Write your code here
        Stack<List> stacky = new Stack<>();
        int maxDays= -999;
        for (int plant : plants) {
            int days = 1;
            if(!stacky.isEmpty()){
                while(!stacky.isEmpty() && (int)stacky.get(stacky.size()-1).get(0) >= plant){
                    int d = (int) stacky.get(stacky.size()-1).get(1);
                    stacky.pop();
                    days = Math.max(days, d+1);
                }
            }
            if (stacky.isEmpty()) {
                days = 0;
            }
            maxDays = Math.max(maxDays, days);
            List<Integer> currentPlant = new ArrayList<>();
            currentPlant.add(plant);
            currentPlant.add(days);
            stacky.add(currentPlant);
        }
        return maxDays;
    }

    public static void main(String[] args) {
        List<Integer> sample1 = new ArrayList<>(Arrays.asList(3, 2, 5, 4));
        poisonousPlants(sample1);

        List<Integer> sample2 = new ArrayList<>(Arrays.asList(4, 3, 7, 5, 6, 4, 2));
        poisonousPlants(sample2);

        List<Integer> sample3 = new ArrayList<>(Arrays.asList(6, 5, 8, 4, 7, 10, 9));
        poisonousPlants(sample3);

    }
}
