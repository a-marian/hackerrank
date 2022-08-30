package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockValidString {

    public static String isValid(String s) {
        char firstValKey= s.charAt(0);
        HashMap<Character, Integer> countOccur = new HashMap<Character, Integer>();
        int repeatedVals = 0;
        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if(countOccur.containsKey(val)){
                countOccur.put(val, countOccur.get(val)+1);
                repeatedVals++;
            }else{
                countOccur.put(val, 1);
            }
        }
        String response = "YES";
        int  timesToDelete = s.length() - repeatedVals;

        if (timesToDelete == 0 || timesToDelete == 1){
             return  response;
        }

            int eval = countOccur.get(firstValKey);
            int countRemoves= 0;
        for (Map.Entry<Character,Integer> map: countOccur.entrySet()) {

                if(map.getValue() < eval){
                    if (map.getValue()+1 == eval || (map.getValue()-1) == 0){
                        countRemoves++;
                        response = "YES";
                    } else{
                        response = "NO";
                        break;
                    }

                }

                if(map.getValue() > eval ){
                    if (map.getValue()-1 == eval){
                        countRemoves++;
                        response = "YES";
                    }else {
                        response = "NO";
                        break;
                    }
                }
            if (countRemoves > 1){
                response="NO";
                break;
            }
            }
        return response;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        in.close();
        System.out.println(isValid(str));
    }


}
