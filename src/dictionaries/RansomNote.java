package dictionaries;

import java.util.*;
/**
 public static void checkMagazine(List<String> magazine, List<String> note) {
 String response = "No";
 int count = 0;
 Map<String, Integer> map = new HashMap<>();
 for (int i = 0; i < note.size(); i++) {
 String notew = note.get(i);
 for (int j = 0; j < magazine.size(); j++) {
 if(notew.equals(magazine.get(j))){
 if (map.containsKey(notew)){
 map.put(notew, count--);
 } else {
 map.put(notew, count++);
 }
 magazine.remove(j);
 break;
 }
 }
 }
 response =  (count == note.size()) ? "Yes" : "No";
 System.out.println(response);
 }

 **/

public class RansomNote {

    public static void checkMagazine(List<String> magazine, List<String> note){
        String response = "No";
        Map<String, Integer> map = new HashMap<>();

        for (int j = 0; j < magazine.size(); j++) {
            if(map.containsKey(magazine.get(j))){
                map.put(magazine.get(j), map.get(magazine.get(j))+1);
            } else {
                map.put(magazine.get(j), 1);
            }
        }

        for (int i = 0; i < note.size(); i++) {
            if(map.containsKey(note.get(i)) && map.get(note.get(i)) >= 1){
                map.put(note.get(i), map.get(note.get(i))-1);
                response = "Yes";
            }else {
                response="No";
                System.out.println(response);
                return;
            }

        }

        System.out.println(response);
    }


    public static void main(String[] args) {
        List<String> magazineYES = new ArrayList<>(Arrays.asList("give", "me", "one", "grand", "today", "night"));
        List<String> noteYES = Arrays.asList("give", "one", "grand", "today");

        List<String> magazineNO = new ArrayList<>(Arrays.asList("two", "times", "three", "is", "not", "four"));
        List<String> noteNO = Arrays.asList("two", "times", "two", "is", "four");

        //positive case
        checkMagazine(magazineYES, noteYES);
        //negative case
        checkMagazine(magazineNO, noteNO);
    }
}
