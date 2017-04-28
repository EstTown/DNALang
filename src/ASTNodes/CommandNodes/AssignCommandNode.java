package ASTNodes.CommandNodes;

import Interfaces.ASTVisitor;
import Interfaces.NodeInterface;

//this node should have two children
public class AssignCommandNode extends CommandNode
{
    public String VariableName; //What variable to assign to
    public String ExpressionValue; //value to assign

}
