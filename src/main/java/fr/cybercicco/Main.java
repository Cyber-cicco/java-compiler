package fr.cybercicco;

import fr.cybercicco.artifacts.ExpressionSyntax;
import fr.cybercicco.parser.Parser;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            var line = scanner.nextLine();
            Parser parser = new Parser(line);
            if(line.isEmpty() || line.isBlank()){
                return;
            }
            ExpressionSyntax expression =  parser.parse();
            System.out.println(expression.toString(""));
        }
    }
}