package recursion;

import java.util.ArrayList;
import java.util.List;

public class CrosswordPuzzle {

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        List<String> result = new ArrayList<>();
        String[] wordsarray= words.split(";");
        int cwsize= crossword.size();
        char[][] matrix = new char[cwsize][cwsize];
        //loading matrix puzzle
        for (int i = 0; i <  crossword.size(); i++) {
            String crossi = crossword.get(i);
            for (int j = 0; j < crossi.length(); j++) {
                matrix[i][j] = crossi.charAt(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> crossword= new ArrayList<>();
        String st1=  "+-++++++++";
        String st2=  "+-++++++++";
        String st3=  "+-++++++++";
        String st4=  "+-++++++++";
        String st5=  "+-++++++++";
        String st6=  "+------+++";
        String st7=  "+-+++-++++";
        String st8=  "+++++-++++";
        String st9=  "+++++-++++";
        String st10= "++++++++++";
        crossword.add(st1);
        crossword.add(st2);
        crossword.add(st3);
        crossword.add(st4);
        crossword.add(st5);
        crossword.add(st6);
        crossword.add(st7);
        crossword.add(st8);
        crossword.add(st9);
        crossword.add(st10);

        String words="AGRA;NORWAY;ENGLAND;GWALIOR";

        crosswordPuzzle(crossword, words);


    }
}
