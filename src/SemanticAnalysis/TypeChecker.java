package SemanticAnalysis;

import AST.*;
import ASTNodes.BaseNode;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.ProgNode;


public class TypeChecker extends Visitor
{
    @Override
    public void Visit(ProgNode node)
    {
        ProgNode.ProcessNode(node);
    }
}
