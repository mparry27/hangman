/*
------------
    |     |
    O     |
   /|\    |
   / \    |
          |
 */
package com.csis2450;

import java.util.Scanner;

public class Main {
    /************
     *  Fields  *
     ***********/
    private static String wordToGuess = "Purple";
    private static int numOfGuess = 0;

    /************************
     *         Main         *
     ***********************/
    public static void main(String[] args){
        //Check if the argument passed is a valid word
        //If not, use the default word
        try {
            if (args[0].matches("[a-zA-Z]+\\.?"))
                wordToGuess = args[0];
            else {
                System.out.println("Invalid word! Using default word");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        wordToGuess = wordToGuess.toUpperCase();
        game();
    }

    /**************************
    *         Methods         *
    ***************************/
    //game
    private static void game(){
        boolean[] correctGuess = new boolean[wordToGuess.length()];
        Scanner sc = new Scanner(System.in);

        //Game Loop
        do{
            drawHangman();
            for(int i=0;i<correctGuess.length;i++){
                if(correctGuess[i])
                    System.out.print(" "+wordToGuess.charAt(i)+" ");
                else
                    System.out.print(" _ ");

            }
            System.out.print("\n\n Please guess a letter: ");
            char guess = Character.toUpperCase(sc.next().charAt(0));
            boolean foundChar = false;
            for (int i = 0; i < correctGuess.length; i++) {
                if (guess == wordToGuess.charAt(i)) {
                    correctGuess[i] = true;
                    foundChar = true;
                }
            }
            if (!foundChar)
                numOfGuess++;
        } while(!allTrue(correctGuess) && numOfGuess<6);

        if(allTrue(correctGuess)) {
            drawHangman();
            for(int i=0;i<wordToGuess.length();i++){
                System.out.print(" "+wordToGuess.charAt(i)+" ");
            }
            System.out.println("\n\nYOU WIN!");
        }
        else {
            drawHangman();
            for(int i=0;i<wordToGuess.length();i++){
                System.out.print(" "+wordToGuess.charAt(i)+" ");
            }
            System.out.println("\n\nYOU LOSE!");
        }

    }

    //Draws the hangman depending on the number of incorrect guesses
    private static void drawHangman() {
        clearScreen();
        System.out.println("-------------");
        System.out.println("     |     | ");
        switch(numOfGuess) {
            case 1:
                System.out.println("     O     | ");
                System.out.println("           | ");
                System.out.println("           | ");
                break;
            case 2:
                System.out.println("     O     | ");
                System.out.println("     |     | ");
                System.out.println("           | ");
                break;
            case 3:
                System.out.println("     O     | ");
                System.out.println("    /|     | ");
                System.out.println("           | ");
                break;
            case 4:
                System.out.println("     O     | ");
                System.out.println("    /|\\    | ");
                System.out.println("           | ");
                break;
            case 5:
                System.out.println("     O     | ");
                System.out.println("    /|\\    | ");
                System.out.println("    /      | ");
                break;
            case 6:
                System.out.println("     O     | ");
                System.out.println("    /|\\    | ");
                System.out.println("    / \\    | ");
                break;
            default:
                System.out.println("           | ");
                System.out.println("           | ");
                System.out.println("           | ");
                break;
        }
        System.out.println("           | ");
        System.out.println("Lives: " + (6-numOfGuess));
    }

    //@author Peter Walser
    //Checks boolean array if all values are true
    //@returns false if they are not all true
    //@passes in boolean array
    private static boolean allTrue (boolean[] values) {
        for (boolean value : values) {
            if (!value)
                return false;
        }
        return true;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
