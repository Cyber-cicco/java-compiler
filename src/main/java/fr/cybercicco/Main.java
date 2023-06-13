package fr.cybercicco;

import fr.cybercicco.lexer.Lexer;
import fr.cybercicco.lexer.SyntaxKind;
import fr.cybercicco.lexer.SyntaxToken;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            var line = scanner.nextLine();
            Lexer lexer = new Lexer(line);
            if(line.isEmpty() || line.isBlank()){
                return;
            }
            while(true){
                SyntaxToken token = lexer.nextToken();
                if(token.getKind() == SyntaxKind.ENDOFLINE_TOKEN){
                    break;
                }
                System.out.println(token);
            }
        }
    }
}