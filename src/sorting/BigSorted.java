package sorting;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BigSorted {


    public static List<String> bigSorting(List<String> unsorted){
        return unsorted.stream().sorted((a,b) ->{
                if(a.length() == b.length()){
                    return new BigInteger(a).compareTo(new BigInteger(b));
                }
                return a.length() - b.length();
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        numbers.add("31415926535897932384626433832795");
        numbers.add("1");
        numbers.add("3");
        numbers.add("10");
        numbers.add("3");
        numbers.add("5");
        //bigSorting(numbers);
        for (String n: bigSorting(numbers)) {
            System.out.print(n+ " ");
        }
    }
}
