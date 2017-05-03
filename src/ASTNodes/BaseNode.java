package ASTNodes;

import Interfaces.ASTVisitor;
import Interfaces.NodeInterface;

import java.util.ArrayList;

public abstract class BaseNode extends Object implements NodeInterface
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

    public BaseNode MakeFamily(BaseNode parent, BaseNode... children){
    	//Add children to parent
    	for (BaseNode x: children){
    		parent.AddChild(x);
		}
		//Add parent (family)
    	return this.AddChild(parent);
	}

    //Not done
    public BaseNode MakeSiblings(BaseNode node){
    	//remove old references, recursively travel through siblings
		recMakeSiblingsHelper(node.leftmostsibling, node);

    	//add child, via parent
        return RecNextRightSibling(this, node);
    }

    private void recMakeSiblingsHelper(BaseNode node, BaseNode nodeToBeRemoved){
    	//Find and destroy reference to node
		if (node == nodeToBeRemoved)
			node.rightsibling = null;
		else
			recMakeSiblingsHelper(node, nodeToBeRemoved);
	}

    //To be made
    public void AdoptChildren(BaseNode nodeToBeAdopted){
        if(this.leftmostchild != null)
            this.leftmostchild.MakeSiblings(nodeToBeAdopted);
        else
        {
        	//Adopts all children of nodeToBeAdopted's parent, starting from leftmostsibling
			this.AddChild(nodeToBeAdopted.leftmostsibling);
        }
    }

    private BaseNode recAdoptChildrenHelper(BaseNode node){
    	if (node.rightsibling != null){
    		this.AddChild(node);
    		return recAdoptChildrenHelper(node.rightsibling);
    	}
    	return this.leftmostchild;
	}

    public void PrintTree(){
        if(this != null)
        {
            System.out.println(this.getClass().getSimpleName());
            System.out.println("____________________________________________________________________");
            recPrinter(this.leftmostchild);
            System.out.println("____________________________________________________________________");
        }
    }

    ///////Private methods///////
    private void recPrinter(BaseNode node){
        if (node != null) {
            //Print the node
            String format = "%-10.10s %-30.30s  %-30.30s%n";
            System.out.printf(format, "Type: ",node.getClass().getSimpleName(), System.identityHashCode(node));
            System.out.printf(format, "Parent: ", node.parent.getClass().getSimpleName(), System.identityHashCode(node.parent));
            if (node.content != null)
                System.out.printf(format, "Content: ", node.content);
            if (node.rightsibling != null)
                System.out.printf(format, "R sib: ", node.rightsibling.getClass().getSimpleName(), System.identityHashCode(node.rightsibling));
            if (node.leftmostsibling != null)
                System.out.printf(format, "LM sib: ", node.leftmostsibling.getClass().getSimpleName(), System.identityHashCode(node.leftmostsibling));
            if (node.leftmostchild != null)
                System.out.printf(format, "LM child: ", node.leftmostchild.getClass().getSimpleName(), System.identityHashCode(node.leftmostchild));
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
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
