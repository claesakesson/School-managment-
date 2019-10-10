package se.ecutb.claes.akesson.model;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);


    public static String getString(){
        return scanner.nextLine();
    }

    public static int getInt(){
        boolean valid = false;
        int number = 0;
        while (!valid){
            try{
                number = Integer.parseInt(getString().trim());
                valid = true;
            }catch (NumberFormatException exceptionName){
                System.out.println("Invalid input");
            }
        }return number;
    }
}
