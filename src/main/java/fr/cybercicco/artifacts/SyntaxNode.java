package fr.cybercicco.artifacts;

public abstract class SyntaxNode {

    protected SyntaxKind kind;

    public SyntaxKind getKind() {
        return kind;
    }

    public void setKind(SyntaxKind kind) {
        this.kind = kind;
    }
}
