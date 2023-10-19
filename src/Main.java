import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int points = 0;
        Random rnd = new Random();
        int die1;
        int die2;
        rnd = new Random();
        boolean redo = true;
        boolean gameOver = false;
        boolean done = false;
        int crapsRoll = 0;
        String question;

        while (redo) {
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;

            System.out.println("You rolled " + die1 + " and " + die2 + " which means your total is " + crapsRoll);
            if (points > 0) {
                if(crapsRoll == 7) {
                    System.out.println("Got a 7 and lost.");
                    gameOver = true;
                }
                else if (crapsRoll == points) {
                    System.out.println("Got a " + crapsRoll + " and won.");
                    gameOver = true;
                }
            } else if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                redo = false;
                gameOver = true;
                System.out.println("Got a " + crapsRoll + " and lost.");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                redo = false;
                gameOver = true;
                System.out.println("Got a " + crapsRoll + " and won.");
            } else {
                points = crapsRoll;
                System.out.println("Got a " + crapsRoll + " and must roll it again before getting a 7 to win.");
            }
            if (gameOver) {
                do {
                    System.out.print("Play Again? Y/N ");
                    if (in.hasNext()) {
                        question = in.next();
                        if (question.equals("Y") || question.equals("y")) {
                            points = 0;

                            redo = true;
                            gameOver = false;
                            done = true;
                        } else if (question.equals("N") || question.equals("n")) {
                            redo = false;
                            gameOver = true;
                            done = true;
                        }
                    }
                } while (!done);
            }
        }
        }
    }