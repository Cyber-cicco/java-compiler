package fr.cybercicco.parser;

import fr.cybercicco.artifacts.BinaryExpressionSyntax;
import fr.cybercicco.artifacts.ExpressionSyntax;
import fr.cybercicco.artifacts.NumberExpressionSyntax;
import fr.cybercicco.artifacts.SyntaxKind;

public class Evalulator {
    private final ExpressionSyntax _root;

    public Evalulator(ExpressionSyntax root) {
        this._root = root;
    }

    public int evaluate(){
        return evaluateExpression(_root);
    }

    private int evaluateExpression(ExpressionSyntax node) {
        if (node.getClass().equals(NumberExpressionSyntax.class)) {
            return (int) ((NumberExpressionSyntax) node).getNumberToken().getValue();
        }
        if (node.getClass().equals(BinaryExpressionSyntax.class)){
            BinaryExpressionSyntax expression = (BinaryExpressionSyntax) node;
            int left = evaluateExpression(expression.getLeftToken());
            int right = evaluateExpression(expression.getRightToken());
            if(expression.getOperatorToken().getKind() == SyntaxKind.PLUS_TOKEN){
                return left + right;
            }
            if(expression.getOperatorToken().getKind() == SyntaxKind.MINUS_TOKEN){
                return left - right;
            }
            if(expression.getOperatorToken().getKind() == SyntaxKind.MULT_TOKEN){
                return left * right;
            }
            if(expression.getOperatorToken().getKind() == SyntaxKind.DIV_TOKEN){
                return left / right;
            }
            throw new RuntimeException("Unexpected Binary operator : " + expression.getOperatorToken().getKind());
        }
        throw new RuntimeException("Unexpected node : " + node.getKind());
    }
}
