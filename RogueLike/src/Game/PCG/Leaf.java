package Game.PCG;

public class Leaf extends Node{

    public Leaf(Room room){
        super(room);
    }

    public boolean isLeaf(){
        return true;
    }
}
