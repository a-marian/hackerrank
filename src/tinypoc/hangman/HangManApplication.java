package tinypoc.hangman;

import java.util.Scanner;

public class HangManApplication {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to tinypoc.hangman! I will pick a word and you will " +
                "try to guess it character " +
                "by character" +
                "\n If you guess wrong 6 times, then I win. If you can guess it before then, you win. " +
                "Areyou ready? I hope because I am.");
        System.out.println();
        System.out.println("I have picked my word. Below is the picture and " +
                "below is your current guess, which starts off as nothing.\n " +
                "Every time you guess incorrectly. I add a body part to the picture.\n" +
                "When there is a full person, you lose.");

        boolean doYouWantToPlay = true;
        while (doYouWantToPlay){
            //setting up game
            System.out.println("Alright! let's play!");
            HangMan hangMan = new HangMan();
            do{
                System.out.println();
                System.out.println(hangMan.drawPicture());
                System.out.println();
                System.out.println(hangMan.getFormalCurrentGuess());
                System.out.println(hangMan.mysteryWord);
                char guess = (sc.next().toLowerCase().charAt(0));
                System.out.println();

                //check if the character is guessed already
                while(hangMan.isGuessAlready(guess)){
                    System.out.println("Try again! You've already guessed that character.");
                    guess = (sc.next().toLowerCase().charAt(0));
                }
                if(hangMan.playGuess(guess)){
                    System.out.println("Great guess! That is the character in the word");
                } else {
                    System.out.println("Unfortunately that character isn't ");
                }
            }
            while(!hangMan.gameOver());
            //keep playing again or not?
            System.out.println();
            System.out.println("Do you wat to play another game. Enter Y if you do");
            Character response = (sc.next().toUpperCase().charAt(0));
            doYouWantToPlay = (response == 'Y');

        }
    }
}
