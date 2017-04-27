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
            return ParentNode.class.cast(recNextRightSibling(this, nodeToBeAdded));
        else
            return ParentNode.class.cast(recRightSiblingTraversal(this, nodeToBeAdded));
    }

    public LeafNode AddChild(LeafNode nodeToBeAdded){
        if (this.getLeftMostChild() != null)
            return LeafNode.class.cast(recNextRightSibling(this, nodeToBeAdded));
        else
            return LeafNode.class.cast(recRightSiblingTraversal(this, nodeToBeAdded));
    }

    /*
    //Call to add a child - this allows for an unlimited number of children
    public Node AddChild(Node nodeTobeAdded){
        return recRightSiblingTraversal(this, nodeTobeAdded);
    }
    */

    public Node AddSibling(Node nodeToBeAdded){
        return recRightSiblingTraversal(this.parentNode, nodeToBeAdded);
    }

    //We're adding a parentnode
    private Node recRightSiblingTraversal (ParentNode parent, Node nodeToBeAdded){
        //If this is node has no children, just add it
        if (this.getLeftMostChild() == null){
            if (nodeToBeAdded instanceof LeafNode){
                //this.leftMostLeaf = LeafNode.class.cast(nodeToBeAdded);
                this.setLeftmostChild(LeafNode.class.cast(nodeToBeAdded));
            }
            else if (nodeToBeAdded instanceof  ParentNode){
                //this.leftmostChild = ParentNode.class.cast(nodeToBeAdded);
                this.setLeftMostChild(ParentNode.class.cast(nodeToBeAdded));
            }
            return this.leftmostChild;
        }
        //If a right sibling doesn't exist, add it!
        else if (parent.leftmostChild.rightSibling == null){
            if (nodeToBeAdded instanceof LeafNode){
                //parent.leftmostChild.rightSibling = LeafNode.class.cast(nodeToBeAdded);
                parent.getLeftMostChild().rightSibling = LeafNode.class.cast(nodeToBeAdded);
            }
            else {
                //parent.leftmostChild.rightSibling = ParentNode.class.cast(nodeToBeAdded);
                parent.getLeftMostChild().rightSibling = ParentNode.class.cast(nodeToBeAdded);
            }
            //parent.leftmostChild.rightSibling.mostLeftSibling = this.leftmostChild;
            parent.getLeftMostChild().rightSibling.mostLeftSibling = this.leftmostChild;
            //System.out.println(parent.leftmostChild.rightSibling.mostLeftSibling.name);
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

    public void PrintTree(){
        System.out.println(this.name);
        System.out.println("++++++++");
        recPrinter(this.getLeftMostChild());
        System.out.println("++++++++");
    }

    private void recPrinter(Object node){
        System.out.println("---------");
        if (node != null) {
            //Print self
            System.out.println(((Node) node).name);

            //If node has a rightsibling, go there
            if (((Node) node).rightSibling != null){
                recPrinter(((Node) node).rightSibling);
            }

            //If node has no rightsibling, go to leftmost sibling
            if (((Node) node).rightSibling == null){

                recPrinter(((Node) node).mostLeftSibling);
            }


        }

            /*if (node instanceof ParentNode)
            System.out.println(((ParentNode) node).getLeftMostChild().name);
            else if (node instanceof LeafNode){
                System.out.println((LeafNode) node).;
            }
        }
        else{

        }*/

    }


}