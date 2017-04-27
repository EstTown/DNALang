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

    public Node leftmostChild;



    //Call to add a child - this allows for an unlimited number of children
    public Node AddChild(Node nodeTobeAdded){
         return recRightSiblingTraversal(this, nodeTobeAdded);
    }

    //We're adding a parentnode
    private Node recRightSiblingTraversal (ParentNode parent, Node nodeToBeAdded){
        //If this is node has no children, just add it
        if (this.leftmostChild == null){
            this.leftmostChild = nodeToBeAdded;
            return this.leftmostChild;
        }
        //If a right sibling doesn't exist, add it!
        else if (parent.leftmostChild.rightSibling == null){
            parent.leftmostChild.rightSibling = nodeToBeAdded;
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
            return node.rightSibling;
        }
        else{
            return recNextRightSibling(node.rightSibling, nodeToBeAdded);
        }
    }
/*
    //Printing from this node, and down
    public void PrintTree(){
        System.out.println(this.name);

        System.out.println("Children:");
        recTreeTraversalPrint(this);
    }

    private void recTreeTraversalPrint(LeafNode node){
        if (node.rightSibling != null){
            System.out.println(node.rightSibling.name);
            recTreeTraversalPrint(node.rightSibling);
        }
    }

    private void recTreeTraversalPrint(Node node){
        if (node.rightSibling != null){
            System.out.println(node.rightSibling.name);
            recTreeTraversalPrint(node.rightSibling);
        }
    }
    */
}