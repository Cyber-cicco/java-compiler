package fr.cybercicco.lexer;

import fr.cybercicco.artifacts.SyntaxKind;
import fr.cybercicco.artifacts.SyntaxToken;

import java.util.ArrayList;
import java.util.List;

/**Classe permettant de tokéniser un texte rentré en input
 * Tokeniser un texte consiste à récupérer les suites de caractères que notre
 * langage va considérer signifiantes pour ensuite renvoyer un token.
 * Les tokens seronts des chaines typées que le Lexer pourra utiliser pour faire
 * des opérations sur les tokens.
 * */
public class Lexer {

    /**Texte à tokenier*/
    private String _text;
    /**Position actuelle dans le texte*/
    private int _position;
    /**Liste d'erreurs survenues lors du parsing des tokens.*/
    private List<String> _diagnostics = new ArrayList<>();
    public Lexer(String _text){
        this._text = _text;
    }

    private char current(){
        if(_position >= _text.length()){
            return '\0';
        }
        return _text.charAt(_position);
    }

    public SyntaxToken nextToken(){
        if(_position >= _text.length()){
            return new SyntaxToken(SyntaxKind.ENDOFFILE_TOKEN, _position, "\0", null);
        }
        if(Character.isDigit(current())){
            int start = _position;
            while (Character.isDigit(current())){
                ++_position;
            }
            String text = _text.substring(start, _position);
            try{
                int value = Integer.parseInt(text);
                return new SyntaxToken(SyntaxKind.NUMBER_TOKEN, start, text, value);
            } catch (NumberFormatException e){
                _diagnostics.add("ERROR : invalid string input for number of type i32 : '" + text + "'");
                return new SyntaxToken(SyntaxKind.BAD_TOKEN, start, text, null);
            }

        }
        if(Character.isWhitespace(current())){
            int start = _position;
            while (Character.isWhitespace(current())){
                ++_position;
            }
            String text = _text.substring(start, _position);
            return new SyntaxToken(SyntaxKind.WHITESPACE_TOKEN, start, text, null);
        }
        switch (current()) {
            case '+' -> {return new SyntaxToken(SyntaxKind.PLUS_TOKEN, _position++, "+", null);}
            case '-' -> {return new SyntaxToken(SyntaxKind.MINUS_TOKEN, _position++, "-", null);}
            case '*' -> {return new SyntaxToken(SyntaxKind.MULT_TOKEN, _position++, "*", null);}
            case '/' -> {return new SyntaxToken(SyntaxKind.DIV_TOKEN, _position++, "/", null);}
            case '%' -> {return new SyntaxToken(SyntaxKind.MODULO_TOKEN, _position++, "%", null);}
            case '(' -> {return new SyntaxToken(SyntaxKind.OPENPARENTHESIS_TOKEN, _position++, "(", null);}
            case ')' -> {return new SyntaxToken(SyntaxKind.CLOSEPARENTHESIS_TOKEN, _position++, ")", null);}
            default ->{
                _diagnostics.add("ERROR : bad charcacter input '" + current() + "'");
                return new SyntaxToken(SyntaxKind.BAD_TOKEN, _position++, _text.substring(_position - 1, _position), null);
            }
        }
    }

    public List<String> getDiagnostics() {
        return _diagnostics;
    }
}
