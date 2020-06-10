package Game.PCG;

public abstract class Node {

    private Room value;

    protected Node (Room value){
        this.value = value;
    }

    public Room getValue() {
        return value;
    }


    abstract boolean isLeaf();
}
