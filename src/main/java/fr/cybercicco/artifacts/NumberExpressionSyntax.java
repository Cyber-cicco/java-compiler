package fr.cybercicco.artifacts;

public class NumberExpressionSyntax extends ExpressionSyntax {


    private SyntaxToken numberToken;
    public NumberExpressionSyntax(SyntaxToken numberToken) {
        this.kind = SyntaxKind.NUMBER_EXPRESSION;
        this.numberToken = numberToken;
    }

    @Override
    public String toString(String indent) {
        return this.numberToken.toString(indent);
    }

    public SyntaxToken getNumberToken() {
        return numberToken;
    }

    public void setNumberToken(SyntaxToken numberToken) {
        this.numberToken = numberToken;
    }

    @Override
    public String toString() {
        return "NumberExpressionSyntax{" +
                "numberToken=" + numberToken +
                '}';
    }
}
