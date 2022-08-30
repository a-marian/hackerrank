package dictionaries;

import java.util.*;


public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        Map<Integer, Integer> frequencies = new HashMap<>();
    
        List<Integer> freqResponse = new ArrayList<>();
        for (int i  = 0; i  < queries.size(); i ++) {
            List<Integer> command = queries.get(i);
            for (int j = 0; j < command.size(); j++) {
                int value =  command.get(1);
                if (command.get(j) == 1){
                    if (frequencies.containsKey(value)){
                        frequencies.put(value, frequencies.get(value)+1);
                    }else {

                        frequencies.put(value, 1);
                    }
                    break;
                }

                if (command.get(j) == 2){
                    if(frequencies.containsKey(value)){
                        frequencies.put(value,  frequencies.get(value)-1);
                    }
                    break;
                }

                if (command.get(j) == 3){
                    if (frequencies.containsValue(value)){
                        freqResponse.add(1);
                    }else{
                        freqResponse.add(0);
                    }
                    break;
                }

            }
        }

        return freqResponse;

    }

    public    static List<Integer> freqQueryComplexity(List<List<Integer>> queries) {

        Map<Integer, Integer> frequencies = new HashMap<>();

        List<Integer> freqResponse = new ArrayList<>();
        for (int i  = 0; i  < queries.size(); i ++) {
            List<Integer> command = queries.get(i);
                int value =  command.get(1);
                if (command.get(0) == 1){
                    if (frequencies.containsKey(value)){
                        frequencies.put(value, frequencies.get(value)+1);
                    }else {

                        frequencies.put(value, 1);
                    }
                    continue;
                }
                if (command.get(0) == 2){
                    if(frequencies.containsKey(value)){
                        frequencies.put(value,  frequencies.get(value)-1);
                    }
                    continue;
                }

                if (command.get(0) == 3){
                    if (frequencies.containsValue(value)){
                        freqResponse.add(1);
                    }else{
                        freqResponse.add(0);
                    }
                    continue;
                }
        }
        return freqResponse;
    }

    public    static List<Integer> freqQueryComplexityV2(List<List<Integer>> queries) {

        Map<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> freqResponse = new ArrayList<>();
        int[] quantities = new int[queries.size()+1];
        int frequency=0;

        for (List<Integer> query : queries) {
            int value =  query.get(1);
            switch (query.get(0)){
                case 1:
                    frequency= frequencies.getOrDefault(value, 0);
                    frequencies.put(value, frequency+1);
                    quantities[frequency]--;
                    quantities[frequency+1]++;
                    break;
                case 2:
                    frequency= frequencies.getOrDefault(value, 0);
                    if(frequency == 0) break;
                    if (frequency >= 1) frequencies.put(value,  frequency-1);
                    quantities[frequency]--;
                    quantities[frequency - 1]++;
                    break;
                case 3:
                    if (value >= quantities.length) freqResponse.add(0);
                    else freqResponse.add(quantities[value] > 0 ? 1:0);
                    break;
            }
        }
        return freqResponse;
    }

    public static void main(String[] args) {

        List<List<Integer>> set1 = new ArrayList<>(new ArrayList<>());
        String input = "1 5 1 6 3 2 1 10 1 10 1 6 2 5 3 2";
        int q = 8;
        set1.add(new ArrayList<>(Arrays.asList(1,5)));
        set1.add(new ArrayList<>(Arrays.asList(1,6)));
        set1.add(new ArrayList<>(Arrays.asList(3,2)));
        set1.add(new ArrayList<>(Arrays.asList(1,10)));
        set1.add(new ArrayList<>(Arrays.asList(1,10)));
        set1.add(new ArrayList<>(Arrays.asList(1,6)));
        set1.add(new ArrayList<>(Arrays.asList(2,5)));
        set1.add(new ArrayList<>(Arrays.asList(3,2)));


    /**    Stream.generate(() -> new ArrayList<Double>(Collections.nCopies(10, 0.0)))
                .limit(10)
                .collect(Collectors.toList()); **/

        List<Integer> answer = freqQueryComplexityV2(set1);

        for (Integer a: answer) {
            System.out.println(a);
        }

    }
}
