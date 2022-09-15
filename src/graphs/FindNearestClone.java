package graphs;

import java.util.*;

public class FindNearestClone {

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        List<Integer>[] map = new ArrayList[graphNodes];
        HashMap<Integer, Integer> distances = new HashMap();
        Arrays.fill(map, new ArrayList<Integer>());

        for (int j = 0; j < graphFrom.length; j++) {
            map[graphFrom[j]-1].add(graphTo[j]);
            map[graphTo[j]-1].add(graphFrom[j]);
        }

        Queue<Integer> queuey = new LinkedList<>();
        for (int j = 0; j < ids.length; j++) {
            if(ids[j] == val){
                queuey.add(j+1);
                distances.put(j+1, 0);
            }
        }
        if(queuey.size()<2)
            return -1;

        HashSet<Integer> seen = new HashSet<>();
        while (!queuey.isEmpty()) {
            int current = queuey.remove();
            seen.add(current);
            for (int a : map[current-1]) {
                if(distances.containsKey(a) && !seen.contains(a)) {
                    return distances.get(a)+distances.get(current)+1;
                } else {
                    queuey.add(a);
                    distances.put(a, distances.get(current)+1);
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int graphNodes = 5;
        int[] graphFrom = {1,2,2,3};
        int[] graphTo = {2, 3, 4, 5};
        long[] ids= {1, 2, 3, 1, 3};
        int val = 4;
        int result = findShortest(graphNodes, graphFrom, graphTo, ids, val);
        System.out.println(result);
    }
}
