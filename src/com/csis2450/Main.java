/*
------------
    |     |
    O     |
   /|\    |
   / \    |
          |
 */
package com.csis2450;

public class Main {
    /************
     *  Fields  *
     ***********/
    private static String wordToGuess = "Orange";
    private static int numOfGuess = 0;

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
        game();
    }

    /**************************
    *         Methods         *
    ***************************/
    //game
    private static void game(){
        boolean[] correctGuess = new boolean[wordToGuess.length()];

        //Game Loop
        do{
            drawHangman(correctGuess);
        } while(!allTrue(correctGuess) && numOfGuess<=6);
    }

    private static void drawHangman(boolean[] cor) {
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
                System.out.println("          | ");
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
        System.out.println("           | \n");
        for(int i=0;i<cor.length;i++){
            if(cor[i])
                System.out.print(" "+wordToGuess.charAt(i)+" ");
            else
                System.out.print(" _ ");
            cor[i]=true;
        }
        System.out.println();
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


}
