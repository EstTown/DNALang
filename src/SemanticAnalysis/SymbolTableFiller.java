package SemanticAnalysis;

import AST.Visitor;
import ASTNodes.BaseNode;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.ProgNode;

public class SymbolTableFiller extends Visitor
{
    @Override
    public void Visit(ProgNode node)
    {
        ProgNode.ProcessNode(node);
    }
}
