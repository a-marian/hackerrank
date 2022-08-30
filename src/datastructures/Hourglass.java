package datastructures;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Hourglass {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        int result = Integer.MIN_VALUE;
        int suma=0;
        // Write your code here
            for (int col = 0; col < 4 ;  col++){
                for (int row = 0; row < 4 ;  row++){
                                    suma= arr.get(row).get(col) +
                                            arr.get(row).get(col+1) +
                                            arr.get(row).get(col+2);

                                    suma += arr.get(row+1).get(col+1);

                                    suma += arr.get(row+2).get(col) +
                                              arr.get(row+2).get(col+1)+
                                              arr.get(row+2).get(col+2);

                                    result = suma > result?suma:result;
                }
            }
            return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Hourglass.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
