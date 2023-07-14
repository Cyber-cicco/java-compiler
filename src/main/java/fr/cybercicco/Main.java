package fr.cybercicco;

import fr.cybercicco.parser.Evalulator;
import fr.cybercicco.parser.Parser;
import fr.cybercicco.parser.SyntaxTree;

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
            SyntaxTree tree =  parser.parse();
            System.out.println(tree.getRoot().toString(""));
            if(parser.getDiagnostics().size() != 0){
                parser.getDiagnostics().forEach(System.out::println);
                parser.getDiagnostics().clear();
            } else {
                Evalulator evalulator = new Evalulator(tree.getRoot());
                int result = evalulator.evaluate();
                System.out.println(result);
            }
        }
    }
}
