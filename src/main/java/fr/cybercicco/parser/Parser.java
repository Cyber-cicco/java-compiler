package fr.cybercicco.parser;

import fr.cybercicco.artifacts.*;
import fr.cybercicco.lexer.Lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe permettant de faire les traitements sur les différents tokens récupérés par le
 * lexer. Possède une méthode permettant de créer un arbre binaire d'opérateurs et de nombres
 * à partir des tokens récupérés du lexer.
 * */
public class Parser {

    /**Le texte que le parser va tenter de parser*/
    private String text;
    /**La position actuelle dans l'array de tokens*/
    private int _position;
    /**Le lexer permettant de transformer le texte en array de tokens*/
    private final Lexer lexer;

    /**L'array de tokens sur lequel le Parser va effectuer ses traitements*/
    private SyntaxToken[] _tokens;

    /**
     * Constructeur de la classe.
     * Récupère un texte, et initialise un Lexer qui va récupérer les différents
     * tokens de ce texte. Va ignorer les whitespaces et les erreurs de syntaxe.
     * */
    public Parser(String text) {
        this.text = text;
        this.lexer = new Lexer(this.text);
        List<SyntaxToken> tokens = new ArrayList<>();
        SyntaxToken token;
        do{
            token = lexer.nextToken();
            if(token.getKind() != SyntaxKind.WHITESPACE_TOKEN
            && token.getKind() != SyntaxKind.BAD_TOKEN){
                tokens.add(token);
            }
        } while( token.getKind() != SyntaxKind.ENDOFFILE_TOKEN);
        _tokens = (SyntaxToken[]) Arrays.stream(_tokens).toArray();
    }

    /**
     * Permet d'aller récupérer un token sans changer la position, pour aller vérfier le contenu
     * d'un token futur sans traiter les tokens entre les deux.
     * */
    private SyntaxToken peek(int offset){
        int index = _position + offset;
        if(index >= _tokens.length){
            return _tokens[_tokens.length - 1];
        }
        return _tokens[index];
    }

    /**
     * Permet de récupérer le token courant
     * */
    private SyntaxToken current(){
        return peek(0);
    }

    /**
     * Permet de récupérer le token actuel et d'incrémenter la position de façon à passer au
     * suivant
     * */
    private SyntaxToken nextToken(){
        SyntaxToken currentToken = current();
        _position++;
        return currentToken;
    }

    /**Permet de passer au token suivant et de le retourner si le token actuel est du type matché.
     * Sinon, crée et retourne un noveau token du type voulu sans texte ni valeur
     * */
    private SyntaxToken match(SyntaxKind syntaxKind){
        if(current().getKind() == syntaxKind) return nextToken();
        return new SyntaxToken(syntaxKind, current().getPosition(), null, null);
    }

    /**Permet de déterminer l'arbre binaire que l'on va utiliser ensuite pour le calcul
     * Si l'on prend l'expression suivante: 1 + 2 - 3
     * begin
     * left = 1
     * true
     * operatorToken = +
     * right = 2
     * left = {leftToken : 1, operatorToken : +, rightToken : 2}
     * true
     * operatorToken = -
     * right = 3
     * left = {leftToken : {leftToken : 1, operatorToken : +, rightToken : 2}, operator : -, right = 3}
     * end
     * */
    public ExpressionSyntax parse(){
        //On récupère un NumberExpressionSyntax. Si le token courant n'est pas un nombre, on ne passe
        //pas au suivant. Si c'est un nombre, on passe au token suivant.
        ExpressionSyntax left = parsePrimaryExpression();
        //Traitement à effectuer tant que le token actuel représente un opérateur mathématique
        //de type plus ou moins.
        while(current().getKind() == SyntaxKind.PLUS_TOKEN
                || current().getKind() == SyntaxKind.MINUS_TOKEN){
            SyntaxToken operatorToken = nextToken();
            ExpressionSyntax right = parsePrimaryExpression();
            left = new BinaryExpressionSyntax(operatorToken, left, right);
        }
        return left;
    }

    /**Permet de parser un nombre dans l'arbre binaire*/
    private ExpressionSyntax parsePrimaryExpression(){
        SyntaxToken numberToken = match(SyntaxKind.NUMBER_TOKEN);
        return new NumberExpressionSyntax(numberToken);
    }

}
