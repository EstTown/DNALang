package ASTNodes.DeclareVarNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class DeclareArrayNode extends BaseNode
{
	@Override
	public void Accept(Visitor nodevisitor) {
		nodevisitor.Visit(this);
	}
}
