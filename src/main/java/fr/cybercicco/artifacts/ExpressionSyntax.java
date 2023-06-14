package fr.cybercicco.artifacts;

/**
 * Représente une Expression pouvant se trouver dans l'arbre
 * binaire d'un calcul mathématique.
 * Un calcul mathématique peut être représenté par un arbre binaire
 * ou chaque noeud peut être représenté de deux façons:
 * un opérateur ou un nombre
 * Toute feuille finale de l'arbre binaire doit être un nombre, ce qui
 * implique que l'arbre binaire peut être représenté avec deux entités:
 * une A qui représente un nombre, et une autre B qui représente un opérateur
 * et ses deux enfants, qui ne peuvent être que de type A ou B.
 * Cette classe abstraite est donc le type dont vont hériter les deux éléments A
 * et B, de façon à représenter cette structure de l'arbre binaire.
 * */
public abstract class ExpressionSyntax extends SyntaxNode {

}
