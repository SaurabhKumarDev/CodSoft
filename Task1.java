import java.util.Random;
import java.util.Scanner;

public class Task1 { 

    //Global Variable
    //Scanner class = Allow to take input from user
    static Scanner sc = new Scanner(System.in);

    //Number game Code
    public static void number_game (int random, int user_value, int n) {
        if(n == 0) {
            System.out.println("\nGame Over");
            System.out.println("You loose the game");
            System.out.println("Try next Time");

        } else {
            if(random == user_value) {
                System.out.println("\nCongratulations, You Won the game");

            } else if(random >= user_value) {
                System.out.print("Enter Greater Value : ");
                user_value = sc.nextInt();
                number_game(random, user_value, n-1);

            } else {
                System.out.print("Enter lowest value : ");
                user_value = sc.nextInt();
                number_game(random, user_value, n-1);

            }
        }
    }

    public static void main(String[] args) {

        //Built in class for Random value
        Random ran = new Random();

        // Created a Random Value which range is (0-99)
        int random = ran.nextInt(100);

        //Here we require range (1-100), So add 1 to the random value
        random+=1;


        System.out.println("\n\nNUMBER GAME");

        //More play
        int play = 0;

        //Implement the game
        do {
            //How many attempts Do you want
            System.out.print("\nNumber of Attempts : ");
            int attempt = sc.nextInt();

            //User first Value
            System.out.print("\nEnter Your Guessed Value : ");
            int user_value = sc.nextInt();

            //Call number_game
            number_game(random, user_value, attempt-1);

            //More Play
            System.out.print("\nDid you want to play more (1/0): ");
            play = sc.nextInt();

        } while (play == 1);

        sc.close();
    }
}