package dynamicProgramming;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.TreeSet;

import static dynamicProgramming.ManchesterAlgo.insertBogusToString;

//Given a string s, return the longest palindromic substring in s.
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int ssize = s.length();
        if (ssize == 0) return "";
        if (ssize == 1) return s;

        ssize = 2 * ssize + 1; // Position count
        int[] left = new int[ssize + 1]; // LPS Length Array
        left[0] = 0;
        left[1] = 1;
        int center = 1; // centerPosition
        int right = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;

        for (i = 2; i < ssize; i++) {
            iMirror = 2 * center - i;
            left[i] = 0;
            diff = right - i;

            if (diff > 0)
                left[i] = Math.min(left[iMirror], diff);

            while (((i + left[i]) + 1 < ssize && (i - left[i]) > 0) &&
                    (((i + left[i] + 1) % 2 == 0) || (s.charAt((i + left[i] + 1) / 2) == s.charAt((i - left[i] - 1) / 2)))) {
                left[i]++;
            }

            if (left[i] > maxLPSLength) // Track maxLPSLength
            {
                maxLPSLength = left[i];
                maxLPSCenterPosition = i;
            }

            if (i + left[i] > right) {
                center = i;
                right = i + left[i];
            }
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        return s.substring(start, end + 1);
       }

    public static String manchesterAlgorithm(String text){
        char[] textBogus = insertBogusToString(text);
        int[] palindromeRadio = new int[2*text.length()+1];
        int center = 0;
        int radius = 0;
        char[] response = new char[text.length()];
        //Hashtable<Integer, Str> treeSet = new TreeSet();

        while(center < textBogus.length){

            while (center - (radius+1) >= 0 && (center+(radius+1) < textBogus.length)
                    && (textBogus[center-(radius+1)] == textBogus[center+(radius+1)])){
                Arrays.fill(response, '*');
                int  responseCont = 0;
                response[responseCont] = text.charAt(responseCont) ;
                responseCont++;
                radius+=1;
            }

            palindromeRadio[center]= radius;
            int oldCenter= center;
            int oldRadius=radius;
            center= center+1;
            radius=0;
            while (center <= oldCenter+oldRadius){

                int mirroredCenter= oldCenter - (center - oldCenter);
                int maxMirroredRadious= oldCenter + oldRadius -center;
                if(palindromeRadio[mirroredCenter] < maxMirroredRadious){

                    palindromeRadio[center] = palindromeRadio[mirroredCenter];
                    center= center+1;
                } else if (palindromeRadio[mirroredCenter] > maxMirroredRadious) {
                    palindromeRadio[center] = maxMirroredRadious;
                    center = center+1;

                } else {
                    radius = maxMirroredRadious;
                    break;
                }
            }


        }
        return response.toString();

    }


    public static void main(String[] args) {
        String result =manchesterAlgorithm("abacaba");
        System.out.println(result);
    }

}
