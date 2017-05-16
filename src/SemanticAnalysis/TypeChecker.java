package SemanticAnalysis;

import AST.Visitor;
import ASTNodes.BaseNode;
import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.CommandNodes.AssignCommandNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.Error;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.*;

import java.beans.Expression;


public class TypeChecker extends Visitor
{
    private static String INTTYPE = "int";
    private static String BOOLTYPE = "bool";
    private static String DNATYPE = "dna";
    private static String RNATYPE = "rna";
    private static String CODONTYPE = "codon";
    private static String PROTEINTYPE = "protein";
    private static String DEFAULTTYPE= "default";
    private class BinaryExpressionTypes
    {
        private String type1;
        private String type2;

        private BinaryExpressionTypes(ExpressionNode node)
        {
            this.type1 = node.getLeftmostchild().type;
            this.type2 = node.getLeftmostchild().getRightsibling().type;
        }
        private boolean AreBothTypesBool()
        {
            if(type1.equals(BOOLTYPE) && type2.equals(BOOLTYPE)) {return true;}
            return false;
        }
        private boolean AreBothTypesInt()
        {
            if(type1.equals(INTTYPE) && type2.equals(INTTYPE)) {return true;}
            return false;
        }
    }
    private void DoSimpleBoolCheck(ExpressionNode node, String operation)
    {
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);
        if(!types.AreBothTypesBool())
        {
            ProgNode.errorList.add(new Error("Cannot "+operation+" "+types.type2+" and "+types.type1, node.line, node.pos));
            node.type = DEFAULTTYPE;
        }
        node.type = BOOLTYPE;
    }
    private void DoSimpleIntCheck(ExpressionNode node, String operation)
    {
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);
        if(!types.AreBothTypesInt())
        {
            ProgNode.errorList.add(new Error("Cannot "+operation+" "+types.type2+" and "+types.type1, node.line, node.pos));
            node.type = DEFAULTTYPE;
        }
        node.type = INTTYPE;
    }
    private void DoComplexCheck(ExpressionNode node, String operation, String nodetype)
    {
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(types.type1.equals(types.type2) && !types.type1.equals(CODONTYPE) && !types.type1.equals(INTTYPE) && !types.type1.equals(BOOLTYPE))
        {
            node.type = nodetype;
        }
        //the following else if, covers some unnecessary cases from the previous if, but that is okay
        else if(types.type1.equals(DNATYPE) || types.type1.equals(RNATYPE) || types.type1.equals(CODONTYPE) &&
                types.type2.equals(DNATYPE) || types.type2.equals(RNATYPE) || types.type2.equals(PROTEINTYPE))
        {
            node.type = nodetype;
        }
        else
        {
            ProgNode.errorList.add(new Error("Cannot "+operation+types.type1+" in "+types.type2, node.line, node.pos));
            node.type = nodetype;
        }
    }

    @Override
    public void Visit(ProgNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(BlockNode node)
    {
        if(node.HasNotBeenChecked)
        {
            visitChildren(node);
        }
    }

    @Override
    public void Visit(PlusNode node)
    {
        visitChildren(node);

        String type1 = node.getLeftmostchild().type;
        String type2 = node.getLeftmostchild().getRightsibling().type;

        System.out.println("PlusNode type1: "+type1);
        System.out.println("PlusNode type2 "+type2);

        /*type check plusnode*/
        if(type1.equals(type2) && !type1.equals(BOOLTYPE) && !type2.equals(BOOLTYPE) && !type1.equals(CODONTYPE)) //basic cases
        {
            node.type = type1;
        }
        else if(type1.equals(DNATYPE) && type2.equals(RNATYPE) || type2.equals(CODONTYPE))
        {
            node.type = type1;
        }
        else if (type1.equals(RNATYPE) && type2.equals(CODONTYPE))
        {
            node.type = type1;
        }
        else if (type1.equals(PROTEINTYPE) && type2.equals(DNATYPE) || type2.equals(RNATYPE) || type2.equals(CODONTYPE))
        {
            node.type = type1;
        }
        else
        {
            ProgNode.errorList.add(new Error("Cannot add " + type1 + " and " + type2, node.line, node.pos));
            node.type = DEFAULTTYPE;
        }
    }

    @Override
    public void Visit(DeclareVarNode node) {
        super.Visit(node);
    }

    @Override
    public void Visit(NotNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(IdentifierNode node)
    {
        BaseNode temp = ProgNode.symbolTable.peek().get(node.content.toString());
        if(temp != null)
        {
            node.type = ProgNode.symbolTable.peek().get(node.content.toString()).content.toString(); //content should be the type information
        }
        else
        {
            node.type = DEFAULTTYPE;
        }
    }

    @Override
    public void Visit(AminoLiteralNode node)
    {
        //don't visitchildren on literals, since they should always be leaf nodes
        node.type = PROTEINTYPE;
    }

    @Override
    public void Visit(BoolLiteralNode node) {
        node.type = BOOLTYPE;
    }

    @Override
    public void Visit(CodonLiteralNode node) {
        node.type = CODONTYPE;
    }

    @Override
    public void Visit(DNALiteralNode node) {
        node.type = DNATYPE;
    }

    @Override
    public void Visit(IntegerLiteralNode node) {
        node.type = INTTYPE;
    }

    @Override
    public void Visit(RNALiteratalNode node) {
        node.type = RNATYPE;
    }

    @Override
    public void Visit(AssignCommandNode node)
    {
        //cannot quite remember what assignments are legal
        visitChildren(node);

        String type1 = node.getLeftmostchild().type;
        String type2 = node.getLeftmostchild().getRightsibling().type;

        System.out.println("type1: "+type1);
        System.out.println("type2: "+type2);

        if(!type1.equals(type2))
        {
            ProgNode.errorList.add(new Error("cannot assign "+type2+" to "+type1, node.line, node.pos));
        }
    }

    @Override
    public void Visit(MinusNode node)
    {
        visitChildren(node);
        DoSimpleIntCheck(node, "subtract");
    }

    @Override
    public void Visit(MultNode node) {
        visitChildren(node);
        DoSimpleIntCheck(node, "multiply");
    }

    @Override
    public void Visit(DivNode node) {
        visitChildren(node);
        DoSimpleIntCheck(node, "divide");
    }

    @Override
    public void Visit(ModNode node) {
        visitChildren(node);
        DoSimpleIntCheck(node, "modulo");
    }

    @Override
    public void Visit(OrNode node) {
        visitChildren(node);
        DoSimpleBoolCheck(node, "compare");
    }

    @Override
    public void Visit(AndNode node) {
        visitChildren(node);
        DoSimpleBoolCheck(node, "compare");
    }

    /* the following two ndoes have special cases */
    @Override
    public void Visit(EqualNode node) {
        super.Visit(node);
    }

    @Override
    public void Visit(NotEqualNode node) {
        super.Visit(node);
    }

    /*special expressions */

    @Override
    public void Visit(ConvertNode node) {
        visitChildren(node);

        //get type of what is to be converted
        String type1 = node.getLeftmostchild().type;
        //get what identifier or literal has to be converted to
        String type2 = node.content.toString();

        if(type1.equals(INTTYPE) || type1.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Cannot convert "+type1, node.line, node.pos));
            node.type = DEFAULTTYPE;
        }
        else if(type1.equals(type2))
        {
            //should give warning, because this would make no sense
        }
        else if(type1.equals(DNATYPE) && type2.equals(RNATYPE) || type2.equals(PROTEINTYPE))
        {
            node.type = type2;
        }
        else if(type1.equals(RNATYPE) && type2.equals(PROTEINTYPE) || type2.equals(DNATYPE))
        {
            node.type = type2;
        }
        else if(type1.equals(CODONTYPE) && type2.equals(PROTEINTYPE) || type2.equals(DNATYPE) || type2.equals(RNATYPE))
        {
            node.type = type2;
        }
        else
            {
                ProgNode.errorList.add(new Error("Cannot convert "+type1 +" to "+type2));
                node.type = DEFAULTTYPE;
            }
    }

    @Override
    public void Visit(ComplementaryNode node) {
        visitChildren(node);

        String type1 = node.getLeftmostchild().type;
        if(!type1.equals(DNATYPE))
        {
            ProgNode.errorList.add(new Error("Cannot find complementary of "+type1, node.line, node.pos));
            node.type = DNATYPE; //result type should always be dna, even after operation
        }
        else
        {
            node.type = DNATYPE;
        }
    }

    @Override
    public void Visit(ReverseNode node) {
        visitChildren(node);

        String type1 = node.getLeftmostchild().type;
        if(type1.equals(BOOLTYPE) || type1.equals(INTTYPE))
        {
           ProgNode.errorList.add(new Error("Cannot reverse "+type1, node.line, node.pos));
           node.type = DEFAULTTYPE;
        }
        else
        {
            node.type = type1;
        }
    }

    @Override
    public void Visit(LengthNode node) {
        visitChildren(node);

        String type1 = node.getLeftmostchild().type;
        if(type1.equals(BOOLTYPE) || type1.equals(INTTYPE))
        {
            ProgNode.errorList.add(new Error("Cannot find length of "+type1, node.line, node.pos));
        }
        node.type = INTTYPE; //the type, when everything goes well, will always be an int, so might aswell default to it
    }

    @Override
    public void Visit(PositionNode node) {
        visitChildren(node);
        DoComplexCheck(node, "find position of ", INTTYPE);
    }

    @Override
    public void Visit(CountNode node) {
        visitChildren(node);
        DoComplexCheck(node, "count ", INTTYPE);
    }

    @Override
    public void Visit(ContainsNode node) {
        visitChildren(node);
        DoComplexCheck(node, "find ", BOOLTYPE);
    }

    @Override
    public void Visit(RemoveNode node) {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);
        //resulting type will always be the secondary type, which is the parameter, from which we want to remove something
        DoComplexCheck(node, "remove ", types.type2);
    }
}
