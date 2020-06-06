import GUI.Screen;
import GUI.StartScreen;
import Utility.World;
import Utility.WorldBuilder;
import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
    private final int width = 80;
    private final int height = 40;
    private World world;
    private AsciiPanel terminal;
    private Screen screen;

    public Game(){
        super();
        terminal = new AsciiPanel(this.width, this.height);
        screen = new StartScreen();
        createWorld();

    }

    private void createWorld(){
        /*world = new WorldBuilder(20, 40)
                .makeCaves()
                .build();*/
    }

    public void initGame(){
        add(terminal);
        pack();
        addKeyListener(this);
        repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }


}
