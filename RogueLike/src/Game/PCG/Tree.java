package Game.PCG;

import java.util.HashSet;

public class Tree {
    private Node root;
    private int minimumRoomSize;
    private int depth;

    public Tree(){
        this.depth = 8;
    }

    public void generateTree(Room room){
        this.root = generateTreeRec(room, 0);
    }

    private Node generateTreeRec(Room room, int depth) {

        Room[] roomArray = new Room[2];
        if(!room.sliceRoom(roomArray) || depth >= this.depth){
            return new Leaf(room);
        }

        depth ++;

        return new InternNode(generateTreeRec(roomArray[0], depth), generateTreeRec(roomArray[1], depth), room);
    }

    public HashSet<InternNode> treeToListOfLeaf(){
        HashSet<InternNode> listOfLeaf = new HashSet<InternNode>();
        treeToListOfLeafRec( listOfLeaf, this.root);
        return listOfLeaf;
    }
    
    public void treeToListOfLeafRec( HashSet<InternNode> listOfLeaf, Node node) {
        if (node instanceof InternNode) {
            InternNode internNode = (InternNode) node;
            if(internNode.getLeftNode().isLeaf() && internNode.getRightNode().isLeaf()){
                listOfLeaf.add(internNode);
            }
            treeToListOfLeafRec(listOfLeaf, internNode.getLeftNode());
            treeToListOfLeafRec(listOfLeaf, internNode.getRightNode());
        }

    }

}
