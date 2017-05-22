package SemanticAnalysis;

import AST.Visitor;
import ASTNodes.BaseNode;
import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareArrayNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.Error;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.*;
import org.antlr.v4.codegen.model.decl.Decl;

import java.beans.Expression;
import java.util.ArrayList;


public class TypeChecker extends Visitor
{
    private static String INTTYPE = "int";
    private static String BOOLTYPE = "bool";
    private static String DNATYPE = "dna";
    private static String RNATYPE = "rna";
    private static String CODONTYPE = "codon";
    private static String PROTEINTYPE = "protein";
    private static String ARRAYTYPE = "array";      //just array?
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
        private boolean TypesAreTheSame()
        {
            if(type1.equals(type2))
            {
                return true;
            }
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

    private void DoCentralDogmaCheck(ExpressionNode node, String operation, String nodetype)
    {
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if((types.type1.equals(DNATYPE)||types.type1.equals(RNATYPE)||types.type1.equals(CODONTYPE))&&
                (types.type2.equals(DNATYPE)||types.type2.equals(RNATYPE)||types.type2.equals(CODONTYPE)))
        {
            node.type = nodetype;
        }
        else
        {
            ProgNode.errorList.add(new Error("Cannot "+operation+types.type1+" in "+types.type2, node.line, node.pos));
            node.type = nodetype;
        }
    }
    private void DoDogmaWithIntsCheck(ExpressionNode node, String operation, String nodetype)
    {
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(!types.type1.equals(BOOLTYPE)&&
        !types.type2.contains(BOOLTYPE))
        {
            node.type = nodetype;
        }
        else
            {
                ProgNode.errorList.add(new Error("Cannot "+operation+types.type1+" and "+types.type2, node.line, node.pos));
                node.type = nodetype;
            }
    }

    private void DoComplexCheck(ExpressionNode node, String operation, String nodetype)
    {
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(types.type1.equals(types.type2) && !types.type1.equals(CODONTYPE) &&
                !types.type1.equals(INTTYPE) && !types.type1.equals(BOOLTYPE))
        {
            node.type = nodetype;
        }
        //the following else if, covers some unnecessary cases from the previous if, but that is okay
        else if((types.type1.equals(DNATYPE) || types.type1.equals(RNATYPE) || types.type1.equals(CODONTYPE)) &&
                (types.type2.equals(DNATYPE) || types.type2.equals(RNATYPE) || types.type2.equals(PROTEINTYPE)))
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
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);
        if(!types.TypesAreTheSame() && !types.type1.equals(BOOLTYPE) && !types.type2.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Cannot add "+types.type1+" and "+types.type2, node.line, node.pos));
            node.type = DEFAULTTYPE;
        }
        else
        {
            node.type = types.type1;
        }
    }



    @Override
    public void Visit(NotNode node)
    {
        visitChildren(node);
        String type = node.getLeftmostchild().type;

        if(!type.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Cannot apply \"!\" on type "+type));
        }
        else
        {
            node.type = type;
        }
    }

    @Override
    public void Visit(IdentifierNode node)
    {
        BaseNode temp = ProgNode.RetrieveSymbol(node.content.toString());

        if(temp != null)
        {
            node.type = temp.content.toString();
        }
        else
        {
            node.type = DEFAULTTYPE; //should never enter this
        }
    }

    //don't visitchildren on literals, since they should always be leaf nodes
    @Override
    public void Visit(AminoLiteralNode node) { node.type = PROTEINTYPE;  }
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
        visitChildren(node);

        String type1 = node.getLeftmostchild().type;
        String type2 = node.getLeftmostchild().getRightsibling().type;
        if (!type1.equals(type2))
        {
            ProgNode.errorList.add(new Error("cannot assign " + type2 + " to " + type1, node.line, node.pos));
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
        DoSimpleBoolCheck(node, "compare ");
    }

    @Override
    public void Visit(AndNode node) {
        visitChildren(node);
        DoSimpleBoolCheck(node, "compare ");
    }

    /* the following two nodes have special cases */
    @Override
    public void Visit(EqualNode node)
    {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        //extended with special cases, done with DoComplexCheck
        if(!types.TypesAreTheSame())
        {
            ProgNode.errorList.add(new Error("Cannot compare "+types.type1+" and "+types.type2));
            node.type = DEFAULTTYPE;
        }
        else
        {
            node.type = BOOLTYPE;
        }
    }

    @Override
    public void Visit(NotEqualNode node)
    {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(!types.TypesAreTheSame())
        {
            ProgNode.errorList.add(new Error("Cannot compare "+types.type1+" and "+types.type2));
            node.type = DEFAULTTYPE;
        }
        else
        {
            node.type = BOOLTYPE;
        }
    }

    @Override
    public void Visit(LessThanNode node) {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(!types.TypesAreTheSame())
        {
            DoDogmaWithIntsCheck(node, "compare ", BOOLTYPE);
        }
        else
            {
                node.type = BOOLTYPE;
            }
    }

    @Override
    public void Visit(GreaterThanNode node) {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(!types.TypesAreTheSame())
        {
            DoDogmaWithIntsCheck(node, "compare ", BOOLTYPE);
        }
        else
            {
                node.type = BOOLTYPE;
            }
    }

    @Override
    public void Visit(LessOrEqualNode node) {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(!types.TypesAreTheSame())
        {
            DoDogmaWithIntsCheck(node, "compare ", BOOLTYPE);
        }
        else
        {
            node.type = BOOLTYPE;
        }
    }

    @Override
    public void Visit(GreaterOrEqualNode node) {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(!types.TypesAreTheSame())
        {
            DoDogmaWithIntsCheck(node, "compare ", BOOLTYPE);
        }
        else
        {
            node.type = BOOLTYPE;
        }
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
        else if(type1.equals(DNATYPE) && (type2.equals(RNATYPE) || type2.equals(PROTEINTYPE)))
        {
            node.type = type2;
        }
        else if(type1.equals(RNATYPE) && (type2.equals(PROTEINTYPE) || type2.equals(DNATYPE)))
        {
            node.type = type2;
        }
        else if(type1.equals(CODONTYPE) && (type2.equals(PROTEINTYPE) || type2.equals(DNATYPE) || type2.equals(RNATYPE)))
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

    @Override
    public void Visit(DeclareArrayNode node)
    {
        visitChildren(node);
        //should evaluate what type of the array is. The only type not allowed is a boolarray
        String typeOfArray = node.content.toString();
        if(typeOfArray.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Cannot have an array of "+typeOfArray, node.line, node.pos));
        }
        else
        {
            node.type = typeOfArray;
        }
        //we should also typecheck the expression, which says how much memory to allocate to this array,
        // which means that this expression must be of type int
        String arrayMemoryExpression = node.getLeftmostchild().type;
        if(!arrayMemoryExpression.equals(INTTYPE))
        {
            ProgNode.errorList.add(new Error("Memory allocation expression must be of type "+"\""+INTTYPE+"\""));
            node.type = DEFAULTTYPE;
        }
        else
        {
            node.type = ARRAYTYPE;
        }
    }

    @Override
    public void Visit(IfCommandNode node)
    {
        visitChildren(node);
        BaseNode temp = node.getLeftmostchild(); //get predicate
        if(!temp.type.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Predicate of controlstructure does not evaluate to "+BOOLTYPE, node.line, node.pos));
        }
    }

    @Override
    public void Visit(IfElseCommandNode node)
    {
        visitChildren(node);
        BaseNode temp = node.getLeftmostchild();
        if(!temp.type.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Predicate of controlstructure does not evaluate to "+BOOLTYPE, node.line, node.pos));
        }
    }

    @Override
    public void Visit(ForCommandNode node)
    {
        visitChildren(node);
        BaseNode temp = node.getLeftmostchild().getRightsibling(); //get predicate
        if(!temp.type.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Predicate of controlstructure does not evaluate to "+BOOLTYPE, node.line, node.pos));
        }
    }

    @Override
    public void Visit(WhileCommandNode node)
    {
        visitChildren(node);
        BaseNode temp = node.getLeftmostchild(); //get predicate
        if(!temp.type.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Predicate of controlstructure does not evaluate to "+BOOLTYPE, node.line, node.pos));
        }
    }

    @Override
    public void Visit(CallCommandNode node)
    {
        visitChildren(node);
        //need to access symboltable, therefore find DeclareFunctionNode
        DeclareFunctionNode temp = (DeclareFunctionNode) ProgNode.RetrieveSymbol(node.spelling);

        if(temp == null)
        {
            ProgNode.errorList.add(new Error("Function "+"\""+node.spelling+"\""+" has not been declared"));
        }
        else
        {
            node.type = temp.content.toString();

            //typecheck actual parameters with formal parameters. Formal parameters are in temp (0). Actual parameters in node (2)
            int childrenToSkip = 2;     //in a callcommandnode, the first two children, will never be the actual parameters, there skip those.
            if(node.ActualParameters != temp.listOfParameters.size())
            {
                ProgNode.errorList.add(new Error("Amount of actual parameters does not match amount of formal parameters", node.line, node.pos));
            }
            else
            {
                ArrayList<BaseNode> listOfActualParameters = ProgNode.GetListOfChildren(node);
                for (int i = 0; i < temp.listOfParameters.size(); i++)
                {
                    if (!temp.listOfParameters.get(i).GetParameterType().equals(listOfActualParameters.get(i+childrenToSkip).type))
                    {
                        ProgNode.errorList.add(new Error("Type of actual parameter "+
                                "\""+listOfActualParameters.get(i+childrenToSkip).content.toString()+"\"" + " does not match the type of formal parameter "+
                                "\""+temp.listOfParameters.get(i).GetParameterName()+"\""));
                    }
                }
            }
        }
    }

    @Override
    public void Visit(DeclareFunctionNode node)
    {
        visitChildren(node);

        String functionReturnType = node.content.toString();
        //find return type. It should be

        for(BaseNode tempNode1 : ProgNode.GetListOfChildren(node))
        {
            if(tempNode1.getClass().getSimpleName().equals("BlockNode")) //DeclareFunctionNode should always have only 1 BlockNode child
            {
                ArrayList<BaseNode> list = ProgNode.GetListOfChildren(tempNode1);
                if(list.isEmpty()) //then there is no return statement
                {
                    ProgNode.errorList.add(new Error("Missing return statement in function "+"\""+node.functionName+"\"", node.line, node.pos));
                }
                else if(!list.get(list.size()-1).getClass().getSimpleName().equals("ReturnCommandNode"))
                {
                    ProgNode.errorList.add(new Error("Function must end with a return statement", node.line,node.pos));
                }
                //from here on, should/could be done in ReturnCommandNode
                /*
                else
                {
                    String returnType = list.get(list.size()-1).getLeftmostchild().type;
                    if(!returnType.equals(node.content.toString()))
                    {
                        ProgNode.errorList.add(new Error("Function "+node.functionName+
                                " must return a value of type "+"\""+node.content.toString()+"\"",node.line,node.pos));
                    }
                }
                */
            }
        }
    }

    @Override
    public void Visit(ReturnCommandNode node)
    {
        visitChildren(node);
        String returnType = node.getLeftmostchild().type;

        DeclareFunctionNode functionNode = (DeclareFunctionNode) ProgNode.GetDeclareFunctionParent(node);

        if(!returnType.equals(functionNode.content.toString()))
        {
            ProgNode.errorList.add(new Error("Function "+"\""+functionNode.functionName+"\""+
                    " must return a value of type "+"\""+functionNode.content.toString()+"\"",node.line,node.pos));
        }
    }

    @Override
    public void Visit(GetNode node)
    {
        visitChildren(node);
        BinaryExpressionTypes types = new BinaryExpressionTypes(node);

        if(!types.type2.equals(INTTYPE))
        {
            ProgNode.errorList.add(new Error("Expression must be of type "+INTTYPE, node.line, node.pos));
        }
        if(types.type1.equals(INTTYPE) || types.type1.equals(BOOLTYPE))
        {
            ProgNode.errorList.add(new Error("Expression cannot be "+types.type1, node.line, node.pos));
        }
        node.type = types.type1;
    }
}