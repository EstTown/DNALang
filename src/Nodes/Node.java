package Nodes;


/*
This is the base node, it's not meant to be used,
but merely meant as a means for abstraction.
Parent node, and Leaf node both inherit from this.
 */
public class Node{

    public String name;
    public Node rightSibling;
    public Node mostLeftSibling;
    public ParentNode parentNode;

    public ParentNode AddSibling(ParentNode nodeToBeAdded){
        return ParentNode.class.cast(recNextRightSibling(this, nodeToBeAdded));
    }

    public LeafNode AddSibling(LeafNode nodeToBeAdded){
        return LeafNode.class.cast(recNextRightSibling(this, nodeToBeAdded));
    }

    private Node recNextRightSibling(Node node, Node nodeToBeAdded){
        if (node.rightSibling == null){
            node.rightSibling = nodeToBeAdded;
            node.rightSibling.parentNode = this.parentNode;
            node.rightSibling.mostLeftSibling = this.mostLeftSibling;
            return node.rightSibling;
        }
        else {
            return recNextRightSibling(node.rightSibling, nodeToBeAdded);
        }
    }

   /*
    private void makeSiblingsWith(Node node){
        if (this.rightSibling == null){
            this.rightSibling = node;
            return;
        }
        else{
            makeSiblingsWith(this, node);
        }
    }

    private void makeSiblingsWith(Node node, Node node2){
        if (node.rightSibling == null){
            node.rightSibling = node2;
            return;
        }
        else{
            makeSiblingsWith(node.rightSibling, node2);
        }
    }
    */

}
