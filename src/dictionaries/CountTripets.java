package dictionaries;

import java.util.*;

public class CountTripets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long response = 0;

        int arrsize = arr.size();
        for (int i = 0; i < arrsize ; i++) {
            for (int j = i+1; j < arrsize; j++) {
                for (int k = j+1; k < arrsize ; k++) {
                    if ((arr.get(k) / arr.get(j) == r) && (arr.get(j) / arr.get(i) == r)){
                        response++;
                    }
                }
            }
        }
        return response;
    }

    static long countTripletsMemo(List<Long> arr, long r) {

        Map<Long, Long> memonext = new HashMap<>();
        Map<Long, Long> memoprevious = new HashMap<>();

        int arrsize = arr.size();
        for (long v: arr) {
            memonext.put(v, memonext.getOrDefault(v, 0L)+1);
        }

        long response = 0;
        for (int i = 0; i < arrsize; i++) {
            long leftVal = 0;
            long rightVal = 0;
            long current = arr.get(i);
            memonext.put(current, memonext.getOrDefault(current,0L)-1);

            if (memoprevious.containsKey(current/r) && current % r == 0)
               leftVal = memoprevious.get(current/r);

            if (memonext.containsKey(current*r))
                rightVal= memonext.get(current*r);

            response += rightVal*leftVal;
            memoprevious.put(current, memoprevious.getOrDefault(current, 0L)+1);
        }
        return response;
        }


    public static void main(String[] args) {

        List<Long> arr3 = new ArrayList<>(Arrays.asList(1L, 5L, 5L, 25L, 125L));
        long r3 = 5;
        System.out.println(countTripletsMemo(arr3, r3));

        List<Long> arr1 = new ArrayList<>(Arrays.asList(1L,2L,2L,4L));
        long r1 = 2;
        System.out.println(countTripletsMemo(arr1, r1));

        List<Long> arr2 = new ArrayList<>(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L));
        long r2 = 3;
        System.out.println(countTripletsMemo(arr2, r2));
    }
}
