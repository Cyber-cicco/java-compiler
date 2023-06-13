package fr.cybercicco.lexer;

public class Lexer {

    private String _text;
    private int _position;
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
        if(Character.isDigit(current())){
            int start = _position;
            while (Character.isDigit(current())){
                ++_position;
            }
            String text = _text.substring(start, _position);
            int value = Integer.parseInt(text);
            return new SyntaxToken(SyntaxKind.NUMBER_TOKEN, start, text, value);

        }
        if(Character.isWhitespace(current())){
            int start = _position;
            while (Character.isWhitespace(current())){
                ++_position;
            }
            String text = _text.substring(start, _position);
            return new SyntaxToken(SyntaxKind.WHITESPACE_TOKEN, start, text, null);
        }
        switch (current()){
            case '+':
                return new SyntaxToken(SyntaxKind.PLUS_TOKEN, _position++, "+", null);
            case '-':
                return new SyntaxToken(SyntaxKind.MINUS_TOKEN, _position++, "-", null);
            case '*':
                return new SyntaxToken(SyntaxKind.MULT_TOKEN, _position++, "*", null);
            case '/':
                return new SyntaxToken(SyntaxKind.DIV_TOKEN, _position++, "/", null);
            case '%':
                return new SyntaxToken(SyntaxKind.MODULO_TOKEN, _position++, "%", null);
            case '(':
                return new SyntaxToken(SyntaxKind.OPENPARENTHESIS_TOKEN, _position++, "(", null);
            case ')':
                return new SyntaxToken(SyntaxKind.CLOSEPARENTHESIS_TOKEN, _position++, ")", null);
        }
        return null;
    }
}
