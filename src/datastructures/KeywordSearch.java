package datastructures;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordSearch {

        //Having a list of keyword in a list and data coming from source which will be a list too
        //I would like to find if any of keywords exissts in the data list, if yes add those keywords to another target list.


    public static void main(String[] args) {

        List<String> keywords = new ArrayList(Arrays.asList("FIRSTNAME", "LASTNAME", "CURRENCY", "FUND"));
        List<String> dataList = new ArrayList(Arrays.asList("HUSBANDFIRSTNAME", "HUSBANDLASTNAME", "WIFEFIRSTNAME", "SOURCECURRENCY", "CURRENCYRATE"));
        Set<String> targetSet = new HashSet();

        String pattern = String.join("|", keywords );
        for (String data : dataList) {
            Matcher matcher = Pattern.compile(pattern).matcher(data);
            if(matcher.find()){
                targetSet.add(matcher.group());
            }
        }

        System.out.println(targetSet);
    }
}
