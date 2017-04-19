package Node;

/**
 * Created by frederik on 18/04/2017.
 */
public class IdentifierNode extends ExpressionNode {
    private String identifier;

    public String getIdentifier() { return this.identifier; }
    public void setIdentifier(String str) {this.identifier = str; }
}
