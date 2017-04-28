package Nodes;

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

    public ParentNode castToParent(){
        return ((ParentNode) this);
    }
    public LeafNode castToLeaf(){
        return ((LeafNode) this);
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
}
