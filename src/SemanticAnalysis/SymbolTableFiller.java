package SemanticAnalysis;

import AST.Visitor;
import ASTNodes.BaseNode;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.ProgNode;

public class SymbolTableFiller extends Visitor
{
    @Override
    public void Visit(DeclareFunctionNode node)
    {

        
        //should be able to type check return value with declared function type
    }
}
