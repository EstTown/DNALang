package ASTNodes;

import Interfaces.ASTVisitor;
import Interfaces.NodeInterface;

import java.util.ArrayList;

public abstract class BaseNode implements NodeInterface
{
    BaseNode parent;
    BaseNode leftmostsibling;
    BaseNode rightsibling;
    BaseNode leftmostchild;

    //ArrayList<BaseNode> siblings;


    public BaseNode MakeSiblings(BaseNode y){

        return y;
    }

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
}
