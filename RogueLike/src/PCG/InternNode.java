package PCG;

public class InternNode extends Node{
    private Node leftNode;
    private Node rightNode;

    public InternNode(Node leftNode, Node rightNode, Room room){
        super(room);
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public boolean isLeaf(){
        return false;
    }
}
