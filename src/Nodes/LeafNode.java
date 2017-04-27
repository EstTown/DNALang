package Nodes;
/*
This node is the outter-most node, meaning
it doesn't have any children, only siblings
and a parent. Although, this node is the node
containing the actual semantic information
(Strings, ints, etc...)
 */
public class LeafNode extends Node{

    public LeafNode(){};
    public LeafNode(String name, Object content){
        this.content = content;
        this.name = name;
    }
    public Object content;

}
