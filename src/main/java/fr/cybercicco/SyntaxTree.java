package fr.cybercicco;

import fr.cybercicco.artifacts.ExpressionSyntax;
import fr.cybercicco.artifacts.SyntaxToken;

public class SyntaxTree {
    private ExpressionSyntax root;
    private SyntaxToken endOfFileToken;
    private String[] _diagnostics;

    public SyntaxTree(ExpressionSyntax root, SyntaxToken endOfFileToken, String[] _diagnostics) {
        this.root = root;
        this.endOfFileToken = endOfFileToken;
        this._diagnostics = _diagnostics;
    }

    public ExpressionSyntax getRoot() {
        return root;
    }

    public SyntaxToken getEndOfFileToken() {
        return endOfFileToken;
    }

    public String[] get_diagnostics() {
        return _diagnostics;
    }
}
