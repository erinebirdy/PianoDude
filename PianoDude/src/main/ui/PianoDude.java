package ui;

import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PianoDude extends JFrame {
    private PianoPanel pp;
    Game game;

    // EFFECTS: Sets up main window for game
    public PianoDude() {
        super("Piano Dude");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        pp = new PianoPanel();
        game = new Game(pp);

        add(pp);
        addKeyListener(new KeyHandler());
        pack();
        centerOnScreen();
        setVisible(true);
        game.startNewSong();
    }

    // MODIFIES: this
    // EFFECTS: location of frame is set so frame is centered on screen
    private void centerOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent ke) {
            game.keyPressed(ke);
        }

    }


    public static void main(String[] args) {

        new PianoDude();
    }
}
