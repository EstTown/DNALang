package Node;

/**
 * Created by frederik on 18/04/2017.
 */
public abstract class InfixExpressionNode extends ExpressionNode {
    private ExpressionNode Left;
    private ExpressionNode Right;

    public ExpressionNode getLeft() { return this.Left; }
    public ExpressionNode getRight() { return this.Right; }
    public void setLeft(ExpressionNode node) { this.Left = node; }
    public void setRight(ExpressionNode node) { this.Right = node; }
}