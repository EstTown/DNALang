package AST;

import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;

public class PrettyPrinter extends Visitor
{

    @Override
    public void Visit(ProgNode progNode)
    {
        progNode.getLeftmostchild().Accept(this); //this visits child node. Dunno how work
		getNext(progNode.getLeftmostchild());

		//progNode.getLeftmostchild().getRightsibling().Accept(this);
		//progNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);

		//System.out.println("We are at a prognode/root");
    }

    private void getNext(BaseNode node)
	{
    	if (node.getRightsibling() != null) {
			node.getRightsibling().Accept(this);
			getNext(node.getRightsibling());
		}
	}

	private BaseNode getNextRightSibling(BaseNode node)
	{
		if (node.getRightsibling() != null) {
			return node.getRightsibling();
		}
		else
			return getNextRightSibling(node.getRightsibling());
	}

	//region DeclareFunction Nodes
	@Override
	public void Visit(DeclareFunctionNode declareFunctionNode)
	{
		//Return type
		declareFunctionNode.getLeftmostchild().Accept(this);
		System.out.print(" ");
		//Identifier
		declareFunctionNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("(");
		//Func params...
		//....
		//....
		System.out.print(") \n { \n");
		//block
		//....
		//....
		System.out.print("\n } \n");
	}
	//endregion

	//region DeclareVar Nodes
	@Override
	public void Visit(DeclareVarNode varNode)
	{
		//Type
    	varNode.getLeftmostchild().Accept(this);
		//Identifier
		varNode.getLeftmostchild().getRightsibling().Accept(this);
    	System.out.print(" = ");
    	//Righthand expression
		varNode.getLeftmostchild().Accept(this);
		System.out.print("; \n");
	}
	//endregion

	//region Command Nodes
	@Override
	public void Visit(AssignCommandNode assignCommandNode)
	{
		//Identifier and equal symbol
		assignCommandNode.getLeftmostchild().Accept(this);
		System.out.print(" = ");
		//Right hand expression
		assignCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("; ");
	}

	@Override
	public void Visit(BreakCommandNode breakCommandNode)
	{
		System.out.print("break;");
	}

	@Override
	public void Visit(CallCommandNode callCommandNode)
	{
		callCommandNode.getLeftmostchild().Accept(this);
		System.out.print("(");
		callCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("); \n");
	}

	@Override
	public void Visit(ForCommandNode forCommandNode)
	{
		System.out.print("for (");
		forCommandNode.getLeftmostchild().Accept(this);
		System.out.print("; ");
		forCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("; ");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
		System.out.print(")");
		System.out.println("\n { \n");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().getRightsibling().Accept(this);
		System.out.println("\n } \n");
	}

	@Override
	public void Visit(IfCommandNode ifCommandNode)
	{

		System.out.print("if (");
		//bool expression
		ifCommandNode.getLeftmostchild().Accept(this);
		System.out.print(") \n");
		//then
		System.out.print("{ \n");
		if (ifCommandNode.getLeftmostchild().getRightsibling() != null)
			ifCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("} \n");
	}
/*
Redundant... apparently... CallCommandNode takes care of this instead...
	@Override
	public void Visit(PrintCommandNode printCommandNode)
	{
		System.out.print("print(");
		printCommandNode.getLeftmostchild().Accept(this);
		System.out.print("); \n");
	}
*/
	@Override
	public void Visit(ReturnCommandNode returnCommandNode)
	{
		System.out.print("return");
		if (returnCommandNode.getLeftmostchild() != null) {
			System.out.print(" ");
			returnCommandNode.getLeftmostchild().Accept(this);
		}
		else
			System.out.print("; \n");
	}

	@Override
	public void Visit(SequentialCommandNode sequentialCommandNode)
	{

	}

	@Override
	public void Visit(WhileCommandNode whileCommandNode)
	{
		System.out.print("while (");
		whileCommandNode.getLeftmostchild().Accept(this);
		System.out.print(") \n");
		System.out.print("{ \n");
		whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("} \n");
	}
	//endregion

	//region Terminal Nodes
	@Override
	public void Visit(AminoLiteralNode aminoLiteralNode)
	{
		System.out.print(aminoLiteralNode.content);
	}

	@Override
	public void Visit(BoolLiteralNode boolLiteralNode)
	{
		System.out.print(boolLiteralNode.content);
	}

	@Override
	public void Visit(CodonLiteralNode codonLiteralNode)
	{
		System.out.print(codonLiteralNode.content);
	}

	@Override
	public void Visit(DNALiteralNode dnaLiteralNode)
	{
		System.out.println(dnaLiteralNode.content);
	}

	@Override
	public void Visit(IdentifierNode idNode)
	{
		System.out.print(idNode.content);
	}

    @Override
	public void Visit(IntegerLiteralNode intNode)
	{
		System.out.print(intNode.content);
	}

	@Override
	public void Visit(RNALiteratalNode rnaLiteratalNode)
	{
		System.out.println(rnaLiteratalNode.content);
	}
	//endregion

	//region Expression Nodes
	@Override
	public void Visit(AndNode andNode)
	{
		andNode.getLeftmostchild().Accept(this);
		System.out.print(" && ");
		andNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ComparisonNode comparisonNode)
	{
		comparisonNode.getLeftmostchild().Accept(this);
		System.out.print(" == ");
		comparisonNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterOrEqualNode greaterOrEqualNode)
	{
		greaterOrEqualNode.getLeftmostchild().Accept(this);
		System.out.print(" >= ");
		greaterOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterThanNode greaterThanNode)
	{
		greaterThanNode.getLeftmostchild().Accept(this);
		System.out.print(" > ");
		greaterThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessOrEqualNode lessOrEqualNode)
	{
		lessOrEqualNode.getLeftmostchild().Accept(this);
		System.out.print(" <= ");
		lessOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessThanNode lessThanNode)
	{
		lessThanNode.getLeftmostchild().Accept(this);
		System.out.print(" < ");
		lessThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ModNode modNode)
	{
		modNode.getLeftmostchild().Accept(this);
		System.out.print(" % ");
		modNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(NotEqualNode notEqualNode)
	{
		notEqualNode.getLeftmostchild().Accept(this);
		System.out.print(" != ");
		notEqualNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(OrNode orNode)
	{
		orNode.getLeftmostchild().Accept(this);
		System.out.print(" && ");
		orNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(PlusNode plusNode)
	{
		plusNode.getLeftmostchild().Accept(this);
		System.out.print(" + ");
		plusNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(MinusNode minusNode)
	{
		minusNode.getLeftmostchild().Accept(this);
		System.out.print(" - ");
		minusNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(MultNode multNode)
	{
		multNode.getLeftmostchild().Accept(this);
		System.out.print(" * ");
		multNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(DivNode divNode)
	{
		divNode.getLeftmostchild().Accept(this);
		System.out.print(" / ");
		divNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}
	//endregion


}
