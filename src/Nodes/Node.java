package Nodes;

import org.omg.CORBA.Object;

/*
This is the base node, it's not meant to be used,
but merely meant as a means for abstraction.
Parent node, and Leaf node both inherit from this.
 */
public class Node extends ParentNode{

    public Node(String name){
        this.name = name;
    }
    public Node(String name, java.lang.Object content){
        this.name = name;
        this.content = content;
    }

    public java.lang.Object content;
    public String name;
    public Node rightSibling;
    public Node mostLeftSibling;
}
