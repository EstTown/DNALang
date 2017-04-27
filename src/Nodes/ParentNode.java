package Nodes;

/*
This is a typical node, with two children, without its
own content. Content will be contained within leafnodes.
 */

public class ParentNode extends Node{


    public ParentNode(){};
    public ParentNode(String name){
        this.name = name;
    }

    private ParentNode leftmostChild;
    private LeafNode leftMostLeaf;

    public Node getLeftMostChild(){
        if (this.parentNode != null)
            return this.parentNode;
        else
            return this.leftMostLeaf;
    }

    public void setLeftMostChild(ParentNode node){
        this.leftmostChild = node;
        this.leftMostLeaf = null;
    }

    public void setLeftmostChild(LeafNode node){
        this.leftMostLeaf = node;
        this.leftmostChild = null;
    }


    //Call to add a child - this allows for an unlimited number of children
    public Node AddChild(Node nodeTobeAdded){
         return recRightSiblingTraversal(this, nodeTobeAdded);
    }

    public Node AddSibling(Node nodeToBeAdded){
        return recRightSiblingTraversal(this.parentNode, nodeToBeAdded);
    }

    //We're adding a parentnode
    private Node recRightSiblingTraversal (ParentNode parent, Node nodeToBeAdded){
        //If this is node has no children, just add it
        if (this.leftmostChild == null && this.leftMostLeaf == null){
            if (nodeToBeAdded instanceof LeafNode){
                this.leftMostLeaf = LeafNode.class.cast(nodeToBeAdded);
            }
            else {
                this.leftmostChild = ParentNode.class.cast(nodeToBeAdded);
            }
            return this.leftmostChild;
        }
        //If a right sibling doesn't exist, add it!
        else if (parent.leftmostChild.rightSibling == null){
            if (nodeToBeAdded instanceof LeafNode){
                parent.leftmostChild.rightSibling = LeafNode.class.cast(nodeToBeAdded);
            }
            else {
                parent.leftmostChild.rightSibling = ParentNode.class.cast(nodeToBeAdded);
            }
            parent.leftmostChild.rightSibling.mostLeftSibling = this.leftmostChild;
            //System.out.println(parent.leftmostChild.rightSibling.mostLeftSibling.name);
            return parent.leftmostChild.rightSibling;
        }
        //If all else fails, recursively call the next right sibling.
        else{
            return recNextRightSibling(parent.leftmostChild.rightSibling, nodeToBeAdded);
        }
    }


    private Node recNextRightSibling(Node node, Node nodeToBeAdded){
        if (node.rightSibling == null){
            node.rightSibling = nodeToBeAdded;
            if (this.leftmostChild != null)
                node.rightSibling.mostLeftSibling = this.leftmostChild;
            else
                node.rightSibling.mostLeftSibling = this.leftMostLeaf;
            return node.rightSibling;
        }
        else{
            return recNextRightSibling(node.rightSibling, nodeToBeAdded);
        }
    }

}