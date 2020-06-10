package Game.GUI;

public enum StartMenuSelection {
    Play, Help, Credits;
    private static StartMenuSelection[] vals = values();

    public StartMenuSelection next() {
        return vals[(this.ordinal()+1) % vals.length];
    }

    public StartMenuSelection previous() {
        int ind = (this.ordinal()-1);
        if(ind < 0){
            ind = vals.length-1;
        }
        return vals[ind % vals.length];
    }
}
