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

	//region Block Nodes
	@Override
	public void Visit(BlockNode blockNode)
	{
		System.out.print("{\n");
		blockNode.getLeftmostchild().Accept(this);
		blockNodeHelper(blockNode.getLeftmostchild());
		//getNext(blockNode);
		System.out.print("\n}");
	}

	private void blockNodeHelper(BaseNode node)
	{
		if (node.getRightsibling()!= null)
		{
			node.getRightsibling().Accept(this);
			blockNodeHelper(node.getRightsibling());
		}
	}

	//endregion

	//region DeclareFunction Nodes
	@Override
	public void Visit(DeclareFunctionNode declareFunctionNode)
	{
		//Return type
		System.out.print(declareFunctionNode.content);
		System.out.print(" ");
		//Identifier
		declareFunctionNode.getLeftmostchild().Accept(this);
		System.out.print("(");
		declareFunctionNode.getLeftmostchild().getRightsibling().Accept(this);

		//declareFunctionNode.getLeftmostchild().getRightsibling()
		getNext(declareFunctionNode.getLeftmostchild().getRightsibling());

		//There's an error somewhere, 'cause the return stm is printed outside the block
	}
	//endregion

	//region DeclareVar Nodes
	@Override
	public void Visit(DeclareVarNode varNode)
	{
		//Type
		System.out.print(varNode.content + " ");
		//Assignment
		varNode.getLeftmostchild().Accept(this);
		if (varNode.getParent().getClass().getSimpleName().equals("BlockNode")){
			System.out.println();
		}
		else if (varNode.getParent().getClass().getSimpleName().equals("DeclareFunctionNode")){
			System.out.print(", ");
		}
		else
			System.out.println();
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

		if (assignCommandNode.getParent().getClass().getSimpleName().equals("ForCommandNode")){
			System.out.print("; ");
		}
		else
			System.out.print(";\n");
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
		forCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("; ");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
		System.out.print(")");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(IfCommandNode ifCommandNode)
	{
		System.out.println();
		System.out.print("if (");
		//bool expression
		ifCommandNode.getLeftmostchild().Accept(this);
		System.out.print(")");

		//block
		if (ifCommandNode.getLeftmostchild().getRightsibling() != null)
			ifCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(IfElseCommandNode ifElseCommandNode)
	{
		System.out.println();
		System.out.print("if (");
		//bool expression
		ifElseCommandNode.getLeftmostchild().Accept(this);
		System.out.print(") \n");
		//block1
		getNext(ifElseCommandNode.getLeftmostchild().getRightsibling());
		System.out.print("\nelse\n");
		//block2
		ifElseCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(PrintCommandNode printCommandNode)
	{
		System.out.print("print(");
		printCommandNode.getLeftmostchild().Accept(this);
		System.out.print("); \n");
	}

	@Override
	public void Visit(ReturnCommandNode returnCommandNode)
	{
		System.out.print("return");
		if (returnCommandNode.getLeftmostchild() != null) {
			System.out.print(" ");
			returnCommandNode.getLeftmostchild().Accept(this);
		}
		System.out.print("; \n");
	}

	@Override
	public void Visit(WhileCommandNode whileCommandNode)
	{
		System.out.println();
		System.out.print("while (");
		whileCommandNode.getLeftmostchild().Accept(this);
		whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
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
		System.out.print(dnaLiteralNode.content);
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
		System.out.print(rnaLiteratalNode.content);
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
	public void Visit(NotNode notNode){
		System.out.print("!");
		notNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(NotEqualNode notEqualNode)
	{
		notEqualNode.getLeftmostchild().Accept(this);
		System.out.print(" != ");
		notEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(EqualNode equalNode)
	{
		equalNode.getLeftmostchild().Accept(this);
		System.out.print(" == ");
		equalNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(OrNode orNode)
	{
		orNode.getLeftmostchild().Accept(this);
		System.out.print(" || ");
		getNextRightSibling(orNode.getLeftmostchild()).Accept(this);
	}

	@Override
	public void Visit(PlusNode plusNode)
	{
		System.out.print("(");
		plusNode.getLeftmostchild().Accept(this);
		System.out.print(" + ");
		//plusNode.getLeftmostchild().getRightsibling().Accept(this);
		getNextRightSibling(plusNode.getLeftmostchild()).Accept(this);
		//System.out.print(";\n");
		System.out.print(")");
	}

	@Override
	public void Visit(MinusNode minusNode)
	{
		System.out.print("(");
		minusNode.getLeftmostchild().Accept(this);
		System.out.print(" - ");
		getNextRightSibling(minusNode.getLeftmostchild()).Accept(this);
		System.out.print(")");
	}

	@Override
	public void Visit(MultNode multNode)
	{
		System.out.print("(");
		multNode.getLeftmostchild().Accept(this);
		System.out.print(" * ");
		getNextRightSibling(multNode.getLeftmostchild()).Accept(this);
		System.out.print(")");
	}

	@Override
	public void Visit(DivNode divNode)
	{
		System.out.print("(");
		divNode.getLeftmostchild().Accept(this);
		System.out.print(" / ");
		getNextRightSibling(divNode.getLeftmostchild()).Accept(this);
		System.out.print(")");
	}

	@Override
	public void Visit(ComplementaryNode complementaryNode){
		System.out.print("comp: ");
		complementaryNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(ReverseNode reverseNode){
		System.out.print("rev: ");
		reverseNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(LengthNode lengthNode){
		System.out.print("len: ");
		lengthNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(ContainsNode containsNode){
		containsNode.getLeftmostchild().Accept(this);
		System.out.print(" contains: ");
		containsNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(CountNode countNode){
		System.out.print("count ");
		countNode.getLeftmostchild().Accept(this);
		System.out.print(" in ");
		countNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(PositionNode positionNode){
		System.out.print("position of ");
		positionNode.getLeftmostchild().Accept(this);
		System.out.print(" in ");
		positionNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(RemoveNode removeNode){
		System.out.print("remove ");
		removeNode.getLeftmostchild().Accept(this);
		System.out.print(" from ");
		removeNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";\n");
	}

	@Override
	public void Visit(ConvertNode convertNode){
		convertNode.getLeftmostchild().Accept(this);
		System.out.print(" as ");
		System.out.print(convertNode.content);

	}


	//endregion


	@Override
	public void Visit(BaseNode baseNode) {

	}
}
