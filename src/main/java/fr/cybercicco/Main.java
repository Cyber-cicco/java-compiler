package fr.cybercicco;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            var line = scanner.nextLine();
            if(line.isEmpty() || line.isBlank()){
                return;
            }
            if(line.equals("ui")){
                System.out.println("uiiiiiiiii");
            } else {
                System.out.println("Input invalide");
            }
        }
    }
}