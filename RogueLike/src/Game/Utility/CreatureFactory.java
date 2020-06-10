package Game.Utility;

import asciiPanel.AsciiPanel;

public class CreatureFactory {

    public Creature newPlayer(){
        Creature player = new Creature( '@', AsciiPanel.brightWhite);
        new PlayerAi(player);
        return player;
    }
}