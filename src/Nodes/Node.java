package Nodes;


/*
This is the base node, it's not meant to be used,
but merely meant as a means for abstraction.
Parent node, and Leaf node both inherit from this.
 */
public class Node<T>{

    public final static LeafNode makeLeaf() {
        return new LeafNode();
    }
    public String name;
    public Node rightSibling;
    public Node mostLeftSibling;
    public ParentNode parentNode;
}
