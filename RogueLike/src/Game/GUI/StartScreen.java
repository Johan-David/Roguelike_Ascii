package Game.GUI;

import Game.Game;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {
    private StartMenuSelection actualSelection;
    private int size;

    public StartScreen(){
        this.size = 3;
        this.actualSelection = StartMenuSelection.Play;
    }

    public void displayOutput(AsciiPanel terminal, Object ... params) {
        if(actualSelection == StartMenuSelection.Play){
            terminal.writeCenter("-- Play --", 15, Color.white, Color.red);
        }else{
            terminal.writeCenter("-- Play --", 15);
        }
        if(actualSelection == StartMenuSelection.Help){
            terminal.writeCenter("-- Help --", 20, Color.white, Color.red);
        }else{
            terminal.writeCenter("-- Help --", 20);

        }
        if(actualSelection == StartMenuSelection.Credits){
            terminal.writeCenter("-- Credits --", 25, Color.white, Color.red);
        }else{
            terminal.writeCenter("-- Credits --", 25);

        }

    }

    private void moveUp(){
        actualSelection = actualSelection.previous();
    }

    private void moveDown(){
        actualSelection = actualSelection.next();
    }

    public Screen respondToUserInput(KeyEvent key, Game game) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ENTER:
                switch (this.actualSelection){
                    case Play: return new PlayScreen();
                    case Help: return new HelpScreen();
                    case Credits: return new CreditsScreen();
                }
            case KeyEvent.VK_UP: moveUp(); break;
            case KeyEvent.VK_DOWN: moveDown(); break;

        }
        return this;
    }
}