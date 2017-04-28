package Nodes;

/*
This is a typical node, with two children, without its
own content. Content will be contained within leafnodes.
 */

public class ParentNode extends Node{

    public ParentNode(String name){
        this.name = name;
    }

    private ParentNode leftmostChild;
    private LeafNode leftMostLeaf;

    public Node getLeftMostChild(){
        if (this.leftmostChild != null)
            return this.leftmostChild;
        else if (this.leftMostLeaf != null)
            return this.leftMostLeaf;
        else
            return null;
    }
    public void setLeftMostChild(ParentNode node){
        this.leftmostChild = node;
        this.leftMostLeaf = null;
    }
    public void setLeftmostChild(LeafNode node){
        this.leftMostLeaf = node;
        this.leftmostChild = null;
    }

    public ParentNode AddChild(ParentNode nodeToBeAdded){
        if (this.getLeftMostChild() != null)
            //Add a sibling
            return this.getLeftMostChild().AddSibling(nodeToBeAdded);
        else
            //Create a leftmostchild
            return ParentNode.class.cast(recRightSiblingTraversal(this, nodeToBeAdded));
    }
    public LeafNode AddChild(LeafNode nodeToBeAdded){
        if (this.getLeftMostChild() != null)
            return this.getLeftMostChild().AddSibling(nodeToBeAdded);
        else
            return LeafNode.class.cast(recRightSiblingTraversal(this, nodeToBeAdded));
    }

    public Node AddSibling(Node nodeToBeAdded){
        return recRightSiblingTraversal(this.parentNode, nodeToBeAdded);
    }

    private Node recRightSiblingTraversal (ParentNode parent, Node nodeToBeAdded){
        //If this is node has no children, just add it
        if (this.getLeftMostChild() == null){
            if (nodeToBeAdded instanceof LeafNode){
                this.setLeftmostChild(LeafNode.class.cast(nodeToBeAdded));
                this.leftMostLeaf.parentNode = this;
            }
            else if (nodeToBeAdded instanceof  ParentNode){
                this.setLeftMostChild(ParentNode.class.cast(nodeToBeAdded));
                this.leftmostChild.parentNode = this;
            }
            return this.getLeftMostChild();
        }
        //If a right sibling doesn't exist, add it!
        else if (parent.leftmostChild.rightSibling == null){
            if (nodeToBeAdded instanceof LeafNode){
                parent.getLeftMostChild().rightSibling = LeafNode.class.cast(nodeToBeAdded);
            }
            else {
                parent.getLeftMostChild().rightSibling = ParentNode.class.cast(nodeToBeAdded);
            }
            parent.getLeftMostChild().rightSibling.mostLeftSibling = this.leftmostChild;
            parent.getLeftMostChild().rightSibling.parentNode = this;
            return parent.getLeftMostChild().rightSibling;
        }
        //If all else fails, recursively call the next right sibling.
        else{
            return recNextRightSibling(parent.getLeftMostChild().rightSibling, nodeToBeAdded);
        }
    }

    private Node recNextRightSibling(Node node, Node nodeToBeAdded){
        if (node.rightSibling == null){
            node.rightSibling = nodeToBeAdded;
            node.rightSibling.mostLeftSibling = this.getLeftMostChild();
            return node.rightSibling;
        }
        else{
            return recNextRightSibling(node.rightSibling, nodeToBeAdded);
        }
    }

    public void PrintTree(){
        System.out.println(this.name);
        System.out.println("_________________________");
        recPrinter(this.getLeftMostChild());
        System.out.println("_________________________");
    }

    private void recPrinter(Object node){
        if (node != null) {
            //Print self
            System.out.println(((Node) node).name);
            System.out.println("Parent  : " + ((Node) node).parentNode.name);
            System.out.println("Type    : " + ((Node) node).getClass());
            if (node instanceof LeafNode)
                System.out.println("Data    : " + ((Node) node).castToLeaf().content);
            System.out.println("-.-.-.-.-.-.-.-.-.-.-. ");

            if (node instanceof ParentNode){
                recPrinter(((ParentNode) node).getLeftMostChild());
            }

            //If node has a rightsibling, go there
            if (((Node) node).rightSibling != null){
                recPrinter(((Node) node).rightSibling);
            }

            //If node has no rightsibling, go to leftmost sibling
            if (((Node) node).rightSibling == null){
                recPrinter(((Node) node).mostLeftSibling);
            }
        }
    }
}