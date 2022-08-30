package datastructures;

import java.util.*;

public class TwoEqualGivenValue {

    public static String getTwoValuesEqualGivenValue(int value, List<Integer> array){
        String  result="";
        ////one way to solve
       // for (int i = 0; i < array.size(); i++) {
       //     int a = array.get(i);
       //     for (int j = i+1; j < array.size(); j++) {
       //        if(a + array.get(j) == value)
         //     result =   result.concat(a+" + "+ array.get(j)+"="+value+", ");
       //     }
       // }
        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(array);
        for (int i = 1; i < array.size(); i++) {
            int resta = value - array.get(i);
          if(  numbers.contains(resta)) {
              result = result.concat(array.get(i) + " ,  ");
          }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int arraySize = sc.nextInt();
         int givenValue = sc.nextInt();

        List<Integer> arrayValues = new ArrayList<>();
        for (int i = 0; i < arraySize ; i++) {
            //Returned hash code value for this object
            //int hashValue = value.hashCode(givenValue - value);
           // System.out.println("Hash code Value for object is: " + hashValue);
            arrayValues.add(sc.nextInt());
        }

        System.out.println(getTwoValuesEqualGivenValue(givenValue, arrayValues));
    }
}

class MarianNumber{
    int value;
    int hash ;

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
