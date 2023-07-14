package fr.cybercicco.artifacts;

public class ParenthesiseExpressionSyntax extends ExpressionSyntax{

    private SyntaxToken openParenthesisToken;
    private SyntaxToken closeParenthesisToken;
    private ExpressionSyntax expression;

    private SyntaxKind kind = SyntaxKind.PARENTHESIS_EXPRESSION;

    public ParenthesiseExpressionSyntax(SyntaxToken openParenthesisToken, ExpressionSyntax expression, SyntaxToken closeParenthesisToken) {
        this.openParenthesisToken = openParenthesisToken;
        this.closeParenthesisToken = closeParenthesisToken;
        this.expression = expression;
    }

    public ExpressionSyntax getExpression() {
        return expression;
    }

    @Override
	public String toString(String indent) {
        return null;
	}

}
