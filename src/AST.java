import Generated.*;
import Nodes.*;

//this class is supposed to build the AST, so that we can use it in the remaining phases

public class AST {

    public static class Builder extends LanguageBaseVisitor<Void> {

        //This is the object that holds our tree, this is the root
        public ParentNode AST;

        @Override
        public Void visitProg(LanguageParser.ProgContext ctx) {

            //Congratz! We have a root node!
            this.AST = new ParentNode("Root");

            return null;
        }

        @Override
        public Void visitFunc(LanguageParser.FuncContext ctx){
            /*
            System.out.println("Function encountered");
            System.out.println("ReturnType: " + ctx.TYPE(0).getText() );
            System.out.println("Identifier  " + ctx.identifier(0).getText() );
            System.out.println("Args       (" + ctx.TYPE(1).getText() + " " + ctx.identifier(1).getText()  + ")");

            System.out.println("Declarations:");
            for (LanguageParser.DeclarationsContext item : ctx.declarations() ){
                System.out.println(item.declaration().getText());
            }

            System.out.println("Statements:");
            for (LanguageParser.StatementsContext item : ctx.statements() ){
                System.out.println(item.statement().getText());
            }
            */
            return null;
        }

        @Override
        public Void visitAssign(LanguageParser.AssignContext ctx){
            //ParentNode tmp = AST.AddChild(new ParentNode("Root"));
            //tmp.AddChild(new LeafNode(ctx.getChild(0).getText()));
            //tmp.AddChild(new LeafNode("Child2"));
            return null;
        }
    }

}
