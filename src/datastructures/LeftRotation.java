package datastructures;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static  List<Integer> rotateLeft(int d, List<Integer> arr){
        if (d > 0){
            int n = arr.size();
            Integer first = arr.get(0);
            for(int i=0; i < arr.size()-1; i++ ){
                arr.set(i, Integer.valueOf(arr.get(i+1).intValue()));
            }
            arr.set(n-1, first );
            arr.subList(0,n-2).add(first);
            rotateLeft(d-1, arr);
        }
        return  arr;
    }
}
public class LeftRotation {




    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.rotateLeft(d, arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
