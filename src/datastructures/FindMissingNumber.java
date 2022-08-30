package datastructures;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FindMissingNumber  {


        public static int findMissingNumber(int totalNumbers, List<Integer> numbers) {
            // sort values in list
          // List<Integer> numbersList = numbers.stream().sorted().collect(toList());
             Integer sum_elements = 0;
            //for (Integer a: numbersList) {
            //    sum_elements += a;
            //}
            //getting the total sum elements by lambda
            sum_elements = numbers.stream().reduce(0,Integer::sum);
            int n = numbers.size() +1;
            int actual_sum = (n* (n +1))/2;
            return actual_sum - sum_elements;
        }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int totalNumbers = sc.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < totalNumbers; i++) {
            numbers.add(sc.nextInt());
        }

        int rest = findMissingNumber(totalNumbers, numbers);

            System.out.println(rest);
    }

}
