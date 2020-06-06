package Utility;

import asciiPanel.AsciiPanel;

import java.awt.*;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    public Creature newPlayer(){
        Creature player = new Creature(world, '@', AsciiPanel.brightWhite);
        world.addAtEmptyLocation(player);
        new PlayerAi(player);
        return player;
    }
}