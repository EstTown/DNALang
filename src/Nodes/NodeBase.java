package Nodes;
import Interfaces.*;

import java.util.ArrayList;

public class NodeBase
{
    NodeBase parent;
    NodeBase leftmostsibling;
    NodeBase rightsibling;
    NodeBase leftmostchild;
    ArrayList<NodeBase> siblings;



    public NodeBase MakeSiblings(NodeBase y){




        return y;
    }

    public NodeBase AdoptChildren(NodeBase y){
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
