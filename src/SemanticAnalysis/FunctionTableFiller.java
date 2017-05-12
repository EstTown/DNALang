package SemanticAnalysis;

import AST.Visitor;
import ASTNodes.BaseNode;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.ProgNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionTableFiller extends Visitor
{
    @Override
    public void Visit(DeclareFunctionNode node)
    {
        ProgNode.EnterSymbol(node.functionName, node);

        visitChildren(node);
    }


    @Override
    public void Visit(ProgNode node)
    {
        ProgNode.OpenScope();
        visitChildren(node);
    }

}
