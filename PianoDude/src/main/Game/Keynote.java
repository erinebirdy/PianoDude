package Game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;


public class Keynote implements KeyListener {

    private String keyVal;


    public Keynote(){
    }

    public String getKeyVal() {
        System.out.println("input?");
        Scanner sc = new Scanner(System.in);
        keyVal = sc.nextLine();
        return keyVal;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
