package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Starting game");
        System.out.println("H A N G M A N");

        String notUsed = "abcdefghijklmnopqrstuvwxyz";

        String[] words = new String[] { "computer", "mouse", "screen", "display", "language" };

        String randomWord = words[(int) (Math.random() * words.length)];

        System.out.println("The word has " + randomWord.length() + " letters.");

        char[] letters = new char[randomWord.length()];



        int lives = 3;

        Scanner scanner = new Scanner(System.in);

        while (lives > 0) {


            for (int i = 0; i < letters.length; i++) {
                letters[i] = '.';
            }


            System.out.print("Lives: ");

            for (int i = 0; i < lives; i++) {
                System.out.print("O");
            }

            System.out.println();

            System.out.println("Input: ");

            String input = scanner.nextLine();

            char letter = input.charAt(0);

            boolean isGuessCorrect = false;

            for (int i = 0; i < randomWord.length(); i++) {
                char l = randomWord.charAt(i);

                if (l == letter) {
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
