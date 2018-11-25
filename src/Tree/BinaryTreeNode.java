package Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Labing
 */
public class BinaryTreeNode
{ 
    // package visible data members
    Object element;
    BinaryTreeNode leftChild; // left subtree
    BinaryTreeNode rightChild; // right subtree
    
    // constructors
    public BinaryTreeNode() {
    }

    public BinaryTreeNode(Object theElement) {
        element = theElement;
    }

    public BinaryTreeNode(Object theElement, BinaryTreeNode theleftChild, BinaryTreeNode therightChild) {
        element = theElement;
        leftChild = theleftChild;
        rightChild = therightChild;
    }
    
    // output method
    public String toString() {
        return element.toString();
    }
}
