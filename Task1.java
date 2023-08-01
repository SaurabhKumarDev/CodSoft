// Task-1 : Number Game

import java.util.Random;
import java.util.Scanner;

public class Task1 { 

    //Global Variable
    static Scanner sc = new Scanner(System.in);

    //Number game Code
    public static void number_game (int random, int user_value, int attempt, int tAttempt) {
        
        // Calculation for scoring you
        float temp = (float)tAttempt;        
        float score = ((attempt+1) / temp) *100;
        int TAttempt = (int) score;

        // Some conditions
        if (attempt == 0 && random == user_value) {

            System.out.println("\nCongratulations, You Won the game");
            System.out.println("Score : "+TAttempt); 

        } 
        else if (attempt == 0) {

            System.out.println("\nGame Over");
            System.out.println("You loose the game");
            System.out.println("Try next Time");

        } 
        else {

            if(random == user_value) {
                System.out.println("\nCongratulations, You Won the game");
                System.out.println("Score : "+TAttempt);
            } else if(random >= user_value) {
                System.out.print("Enter Greater Value : ");
                user_value = sc.nextInt();
                number_game(random, user_value, attempt-1, tAttempt);
            } else {
                System.out.print("Enter lowest value : ");
                user_value = sc.nextInt();
                number_game(random, user_value, attempt-1, tAttempt);
            }

        }
    }

    public static void main(String[] args) {

        System.out.println("\n\n\tNUMBER GAME");

        //More Play
        int play = 0;

        //Implement the game
        do {
            //Built in class for Random value
            Random ran = new Random();

            // Created a Random Value which range is (0-99)
            int random = ran.nextInt(100);

            //Here we require range (1-100), So add 1 to the random value
            random+=1;

            //How many attempts Do you want
            System.out.print("\nNumber of Attempts : ");
            int attempt = sc.nextInt();

            //User first Value
            System.out.print("\nEnter Your Guessed Value : ");
            int user_value = sc.nextInt();

            //Call number_game
            number_game(random, user_value, attempt-1, attempt);

            //More Play
            System.out.print("\nDid you want to play more (1/0): ");
            play = sc.nextInt();

        } while (play == 1);

        sc.close();
    }
}