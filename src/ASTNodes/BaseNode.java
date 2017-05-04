package ASTNodes;

import AST.Visitor;
import Interfaces.ASTVisitor;
import Interfaces.NodeInterface;

import java.util.ArrayList;

public abstract class BaseNode implements NodeInterface
{
    private BaseNode parent;
    private BaseNode leftmostsibling;
    private BaseNode rightsibling;
    private BaseNode leftmostchild;
    private Object content;

    ///////Private getters///////
    public BaseNode getParent(){
        return this.parent;
    }
    public BaseNode getLeftmostsibling(){
        return this.leftmostsibling;
    }
    public BaseNode getRightsibling(){
        return this.rightsibling;
    }
    public BaseNode getLeftmostchild(){
        return this.leftmostchild;
    }

    public BaseNode AddSibling(BaseNode nodeToBeAdded){
        return RecNextRightSibling(this, nodeToBeAdded);
    }

    public BaseNode AddChild(BaseNode nodeToBeAdded){
            return RecAddChild(this, nodeToBeAdded);
    }

    //Not done
    public BaseNode MakeSiblings(BaseNode node){
        return RecNextRightSibling(this, node);
    }

    //To be made
    public BaseNode AdoptChildren(BaseNode y){
        if(this.leftmostchild != null)
        {
            this.leftmostchild.MakeSiblings(y);
        }
        else
        {

        }
        return y;
    }

    public void PrintTree(){
        if(this != null)
        {
            System.out.println(this.getClass().getSimpleName());
            System.out.println("_________________________");
            recPrinter(this.leftmostchild);
            System.out.println("_________________________");
        }
    }


    ///////Private methods///////
    private void recPrinter(BaseNode node){
        if (node != null) {
            //Print self
            System.out.println("Type    : " +node.getClass().getSimpleName());
            System.out.println("Parent  : " + node.parent.getClass().getSimpleName());
            if (node.content != null)
                System.out.println("Content : " + node.content);
            System.out.println("-.-.-.-.-.-.-.-.-.-.-. ");

            if (node.leftmostchild != null){
                recPrinter(node.leftmostchild);
            }

            //If node has a rightsibling, go there
            if (node.rightsibling != null){
                recPrinter(node.rightsibling);
            }

            //If node has no rightsibling, go to leftmost sibling
            if (node.rightsibling == null){
                recPrinter(node.leftmostsibling);
            }
        }
    }

    //Helper for adding children
    private BaseNode RecAddChild(BaseNode parent, BaseNode nodeToBeAdded){
        //If this is node has no children, just add it
        if (this.leftmostchild == null){
            this.leftmostchild = nodeToBeAdded;
            this.leftmostchild.parent = this;
            return this.leftmostchild;
        }
        else if (parent.leftmostchild.rightsibling == null){
            parent.leftmostchild.rightsibling = nodeToBeAdded;
            parent.leftmostchild.rightsibling.leftmostsibling = this.leftmostsibling;
            parent.leftmostchild.rightsibling.parent = this;
            return parent.leftmostchild.rightsibling;
        }
        else return RecNextRightSibling(parent.leftmostchild.rightsibling, nodeToBeAdded);
    }

    //Helper adding siblings
    private BaseNode RecNextRightSibling(BaseNode node, BaseNode nodeToBeAdded){
        if (node == null){
            node.rightsibling = nodeToBeAdded;
            node.rightsibling.parent = this.parent;
            node.rightsibling.leftmostsibling = this.leftmostsibling;
            return node.rightsibling;
        }
        else {
            return RecNextRightSibling(node.rightsibling, nodeToBeAdded);
        }
    }

}
