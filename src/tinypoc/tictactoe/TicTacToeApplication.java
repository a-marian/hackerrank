package tinypoc.tictactoe;

import java.util.Scanner;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean doYouWantToPlay = true;
        while (doYouWantToPlay){
            //Setting up out tokens an AI
            System.out.println("Welcome to the game. You are about to go against" +
                    " the paster of Tic Tac Toe. Are you ready? I hope so!\n But first ");
            System.out.println("Pick what character you want to be and which character I will be:");
            System.out.println();
            System.out.println("Enter a single character that will represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character tha will represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();
            //set up game
            System.out.println();
            System.out.println("We can start the game. To play, enter a number and your token shall be put in" +
                    "its place. \nThe numbers go 1-9. left to right. We shall see who will win this round.");

            TicTacToe.printIndexBoard();
            System.out.println();

            System.out.println("Let's play");
            while(game.gameOver().equals("notOver")) {
                if(game.currentMarker == game.userMarker){
                    //user turn
                    System.out.println("It's your turn Enter a spot for your token");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)){
                        System.out.println("Try again " + spot+ "is invalid. This spot is already taken" +
                                " or it is out of range");
                        spot = sc.nextInt();
                    }

                }else{
                    System.out.println("It's my turn!");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+aiSpot+"!");
                }
                //print out board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            //set up a new game depending on the response
            System.out.println("Do you want to play again? Enter Y if do." +
                    " Enter anything else if you are tired of me.");
            char playagain = sc.next().charAt(0);
            doYouWantToPlay = (playagain == 'Y');
            System.out.println();
            System.out.println();
            }
        }
}
