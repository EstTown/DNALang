package SemanticAnalysis;

import AST.Visitor;
import ASTNodes.BaseNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.ProgNode;

public class SymbolTableFiller extends Visitor
{
    @Override
    public void Visit(BaseNode baseNode)
    {

    }

    @Override
    public void Visit(ProgNode progNode) {

        this.visitChildren(progNode);
    }

    @Override
    public void Visit(DeclareVarNode declareVarNode) {
        System.out.println("SymbolTableFiller at declare var node");
        visitChildren(declareVarNode);
    }
}
