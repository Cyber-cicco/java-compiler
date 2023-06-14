package fr.cybercicco.artifacts;

/**
 * Représente un noeud dans un niveau dans un arbre binaire,
 * composé de deux nombres et d'un opérateur.
 * left : nombre de gauche, ou BinaryExpressionSyntax
 * opérateur : opérateur mathématique
 * right : nombre de droite, ou BinaryExpressionSyntax.
 * */
public class BinaryExpressionSyntax extends ExpressionSyntax{
    private SyntaxToken operatorToken;
    private ExpressionSyntax leftToken;
    private ExpressionSyntax rightToken;

    public BinaryExpressionSyntax(SyntaxToken operatorToken, ExpressionSyntax leftToken, ExpressionSyntax rightToken) {
        this.operatorToken = operatorToken;
        this.leftToken = leftToken;
        this.rightToken = rightToken;
        this.kind = SyntaxKind.BINARY_EXPRESSION;
    }

    public String toString(String indent) {
        String additionalIndent = "    ";
        return  indent
                + this.kind
                + " \n"
                + this.leftToken.toString(indent + additionalIndent)
                + " \n"
                + this.operatorToken.toString(indent + additionalIndent)
                + " \n"
                + this.rightToken.toString(indent + additionalIndent);
    }
}
