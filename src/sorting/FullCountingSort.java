package sorting;

import java.util.*;


import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FullCountingSort {

        /*
         * Complete the 'countSort' function below.
         *
         * The function accepts 2D_STRING_ARRAY arr as parameter.
         */

        public static void countSort(List<List<String>> arr) {
            // Write your code here
            int n = arr.size();
            //***instantiate array of string builders**//
            StringBuffer[] buffer = new StringBuffer[100];
            for (int i = 0; i < 100; i++) {
                buffer[i]= new StringBuffer();
            }
            //****to speed up string to integer conversion****//
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i <= 99; i++){
                String s = Integer.toString(i);
                map.put(s, i);
            }
            int index = 0;

            for (int i = 0; i < arr.size()/2; i++) {
                index = map.get(arr.get(i).get(0));
                buffer[index].append("- ");
            }
            for (int i = arr.size()/2; i < arr.size(); i++) {
                index = map.get(arr.get(i).get(0));
                buffer[index].append(arr.get(i).get(1)+" ");
            }

            for (int i = 0; i < 100; i++) {
                System.out.print(buffer[i]);
            }

        }

    public static void countSortResume(List<List<String>> arr) {
        // Write your code here
        //***instantiate array of string builders**//
        StringBuilder[] buffer = new StringBuilder[100];
        int index = 0;

        for (int i = 0; i < arr.size(); i++) {
            if(i < arr.size()/2){
                index = Integer.parseInt(arr.get(i).get(0));
                buffer[index] = buffer[index] == null ? new StringBuilder("-"): buffer[index].append(" -");
            }else{
                index = Integer.parseInt(arr.get(i).get(0));
                buffer[index] = buffer[index] == null ? new StringBuilder(arr.get(i).get(1)):
                        buffer[index].append(" "+arr.get(i).get(1));
            }
        }

        for (int i = 0; i < buffer.length; i++) {
            if(buffer[i] != null){
                System.out.print(buffer[i].toString());
                System.out.print(" ");
            }
        }
    }


        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<String>> arr = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    arr.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

                countSort(arr);

            bufferedReader.close();
        }
    }

