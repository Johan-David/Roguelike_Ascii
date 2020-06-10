package Game.GUI;

import Game.Game;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public interface Screen {
    public void displayOutput(AsciiPanel terminal, Object ... params);

    public Screen respondToUserInput(KeyEvent key, Game game);
}