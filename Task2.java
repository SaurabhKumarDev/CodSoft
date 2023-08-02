// WORD COUNTER

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {

    // Global 
    static Scanner scanner = new Scanner(System.in);
    static File myFile = new File("text.txt");

    //Message for user to use in convenient way
    static void msg() {
        System.out.println("\n\t WORD COUNTER");
        System.out.println("Which text do you want to count : ");
        System.out.println("1. System Input(Press 1)");
        System.out.println("2. Text file(Press 2)\n");
        System.out.print("Operation : ");
    }
    static void msg1() {
        System.out.println("\n1. Write in text file");
        System.out.println("2. Read text file");
        System.out.print("\nSelect : ");
    }

    // Operation Select
    static int Operation() {
        int op = scanner.nextInt();
        if (op == 1) {
            return 1;
        } else if (op == 2) {
            return 2;
        } else {
            System.out.println("\nEnter Correct Value");
            System.out.println("Try again");
        }
        return -1;
    }

    // Operation 1 : Read user Input's and Count Word
    static int wordCounter(String text) {
        int count = 0;

        for(int i=0; i<text.length(); i++) {
            if(text.charAt(i) == ' ') {
                count++;
            }
        }

        if(text.isEmpty()) {
            return 0;
        } else if (count >= 1) {
            return count+1;
        } else if (text.charAt(0) != ' ') {
            return 1;
        }
        return -1;
    }

    // Operation 2 
    // 2.1 : File checking
    static void file() {
        try {
            if(myFile.createNewFile()) {
                System.out.println("\nFile created Successfully ");
            }
        } catch (IOException e) {
            System.out.println("Error Occur : During File Creation");
            e.printStackTrace();
        }
    }

    // 2.2 : Write in file
    static void writeFile() {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter myFiles = new FileWriter(myFile);

            String str = sc.nextLine();
            myFiles.write(str);
            myFiles.close();

            char ask = 'n';
            System.out.print("Want to ask Word(y/n) : ");
                ask = sc.next().charAt(0);
            if(ask == 'y') {
                ReadFile();
            } 

            sc.close();
            
        } catch (IOException e) {
            System.out.println("Error occur : Writing File");
            e.printStackTrace();
        }
    }

    // 2.3 : Count Word of external text file
    static void ReadFile() {
        try {
            int line = 0, fResult = 0;
            Scanner fileReader = new Scanner(myFile);
            while(fileReader.hasNextLine()) {

                String text = fileReader.nextLine();
                line++;

                int temp = 0;
                do {
                    temp = wordCounter(text);
                    fResult += temp;
                } while (wordCounter(text) == 0);

            }
            System.out.println("Lines : "+line);
            System.out.println("Words : "+fResult);
            fileReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error Occur : Read File ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);                 
        // Message
        msg();                                                    
        // Operation
        int ops = Operation();                                    

        if(ops == 1) {
            // For Better Look
            System.out.println();                                 

            String text = scanner.nextLine();                     
            System.out.println("Word : "+wordCounter(text));      
        } else if(ops == 2) {
            // Creation of file
            file();                                            
            // Message 1 function   
            msg1();                                            

            int op = scanner.nextInt();
            System.out.println();

            switch (op) {
                case 1 -> writeFile();
                case 2 -> ReadFile();
                default -> System.out.println("Choose Correct option as mentioned\nTry again");
            }

        }

        scanner.close();
    }
}