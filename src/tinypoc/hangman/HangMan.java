package tinypoc.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HangMan {

    String mysteryWord;
    StringBuilder currentGuess;
    ArrayList<Character> previousGuesses = new ArrayList<>();

    int mayTries = 6;
    int currentTry = 0;

    ArrayList<String> dictionary = new ArrayList<>();
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    public HangMan() throws IOException {
        initializeStreams();
        mysteryWord = pickWord();
        currentGuess = initializeCurrentGuess();
    }

    private StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length()+2; i++) {
            if(i % 2 == 0){
                current.append("_");
            } else{
                current.append(" ");
            }
        }
        return current;
    }
    private String pickWord() {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
        return  dictionary.get(wordIndex);
    }

    private void initializeStreams() throws IOException {
        try {
            File inFile = new File("dictionary.txt");
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (currentLine != null){
                dictionary.add(currentLine);
                currentLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e){
            System.out.println("Could not find init streams");
        }
    }

    public String getFormalCurrentGuess(){
        return "Current guess: "+ currentGuess.toString();
    }
    public boolean gameOver(){
        if (didWeWin()){
            System.out.println();
            System.out.println("Congrats! You guessed the right word!");
            return  true;
        }else if (didWeLose()){
            System.out.println();
            System.out.println("Sorry, yu lost. You spent all of your 6 tries. " +
                    "The word was "+ mysteryWord + ".");
            return true;
        }
        return false;
    }

    private boolean didWeLose() {
        return  currentTry >= 6;//maxtries;
    }

    private boolean didWeWin() {
        String guess = getCondensedCurrentGuess();
        return guess.equals(mysteryWord);
    }

    public String getCondensedCurrentGuess(){
        String guess =  currentGuess.toString();
        return guess.replace(" ", "");
    }

    public boolean isGuessAlready(char guess){
        return  previousGuesses.contains(guess);
    }

    public boolean playGuess(char guess){
        boolean isItAGoodGuess = false;
        for (int i = 0; i < mysteryWord.length(); i++) {
            if(mysteryWord.charAt(i) == guess){
                currentGuess.setCharAt(i*2, guess);
                isItAGoodGuess = true;
                previousGuesses.add(guess);
            }
        }
        if (!isItAGoodGuess) {
            currentTry++;
        }
        return isItAGoodGuess;
    }

    public String drawPicture(){
        System.out.println();
        switch (currentTry){
            case 0: return noPersonDraw();
            case 1: return addHeadDraw();
            case 2: return addBodyDraw();
            case 3: return addOneArmDraw();
            case 4: return  addSecondArmDraw();
            case 5: return addFirstLegDraw();
            default: return fullPersonDraw();
        }
    }

    private String noPersonDraw() {

        return " - - - - -\n"+
                "|        |\n"+
                "|        \n" +
                "|       \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addHeadDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|       \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addBodyDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        | \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addOneArmDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / |  \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addSecondArmDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addFirstLegDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \n" +
                "|\n" +
                "|\n";
    }

    private String fullPersonDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \\ \n" +
                "|\n" +
                "|\n";
    }

}
