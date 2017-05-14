package SemanticAnalysis;

import AST.Visitor;
import ASTNodes.BaseNode;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.Error;
import ASTNodes.ProgNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionTableFiller extends Visitor
{
    @Override
    public void Visit(DeclareFunctionNode node)
    {
        if(!ProgNode.DeclaredLocally(node.functionName))
        {
            ProgNode.EnterSymbol(node.functionName, node);
        }
        else
        {
            ProgNode.errorList.add(new Error("Function with name "+node.functionName+" is already declared", node.line, node.pos));
        }

        visitChildren(node);
    }


    @Override
    public void Visit(ProgNode node)
    {
        ProgNode.OpenScope();
        visitChildren(node);
    }

}
