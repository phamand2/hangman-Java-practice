package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Starting game");
        System.out.println("H A N G M A N");

        String notUsed = "abcdefghijklmnopqrstuvwxyz";


        // Create an array of words
        String[] words = new String[] { "dog", "cat", "bird", "turtle", "fish" };

        // Generate a word by accessing a random given index
        String randomWord = words[(int) (Math.random() * words.length)];

        System.out.println("The category is type of animals.");
        System.out.println("The word has " + randomWord.length() + " letters.");

        // Create a new char array by assigning each char given by the length of the given randomWord.
        char[] letters = new char[randomWord.length()];


        // Starting lives
        int lives = 3;

        Scanner scanner = new Scanner(System.in);

        while (lives > 0) {

            // Loop through the letters array and reassign it a "."
            for (int i = 0; i < letters.length; i++) {
                letters[i] = '.';
            }


            System.out.print("Lives: ");

            // Loop through the lives count and print out the lives
            for (int i = 0; i < lives; i++) {
                System.out.print("O");
            }

            System.out.println();

            System.out.println("Input: ");

            String input = scanner.nextLine();

            // Store the input value from position 0
            char letter = input.charAt(0);


            boolean isGuessCorrect = false;


            for (int i = 0; i < randomWord.length(); i++) {
                // Loop - Create a new variable and get the value of the given randomWord
                char l = randomWord.charAt(i);


                // Check if the user input stored in "letter" equals to any of the variable "l"
                if (l == letter) {
                    // Reassign the letters array by the matching index to the correct char
                    // Ex: Original letters[] ==> {".",".","."}
                    // If "c" was correct then the new letters[] ==> {"c",".","."}
                    letters[i] = l;
                    System.out.println("Guess is correct!");
                    isGuessCorrect = true;
                }
            }

            if (!isGuessCorrect) {
                System.out.println("Guess is wrong");
                lives = lives - 1;
            }

            boolean isGameFinished = true;

            System.out.print("Word: ");


            // check to see if the game is finished if the letters array still have a "."
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == '.') {
                    isGameFinished = false;
                }

                System.out.print(letters[i]);
            }

            System.out.println();

            notUsed = notUsed.replace(letter, '.');

            System.out.println("Not used: " + notUsed);

            System.out.println("--------------------------");

            if (isGameFinished) {
                System.out.println("Yes! The secret word is " + randomWord + " You have won!");
                break;
            }
        }

        if (lives == 0) {
            System.out.println("You lost! The word was: " + randomWord);
        }

        System.out.println("Exiting game");
    }
}
