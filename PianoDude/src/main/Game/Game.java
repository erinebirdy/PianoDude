package Game;


import Sound.*;
import ui.PianoPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

// Game is the loop of one game,
// Game would start with certain key (start key)
// Each game can only has one error:
//      if the wrong key is pressed, restart the game
//      once one sequence is completed (all correct), start the next sequence
//          (next or exit button)
//      end game when out of sequence

public class Game {

    public static final ArrayList<String> PIANO_KEYS = new ArrayList<>(Arrays.asList(
            "a", "b", "c", "d", "e", "f", "g"));

    private boolean isCorrectKey;
    private boolean isNextGame;
    private boolean isGameComplete;
    private int score;
    private ArrayList<String> currSong;
    public ArrayList<String> attemptSong;
    private SequenceGenerator sqGen;
    private boolean isListening;
    private String lastKeyPressed;
    private PianoNote notePlayer;
    private PianoPanel piano;
    private boolean b;

    public Game(PianoPanel pp){
        isCorrectKey = true;
        isNextGame = false;
        isGameComplete = false;
        isListening = false;
        this.b = false;
        attemptSong = new ArrayList<>();

        sqGen = new SequenceGenerator();
        notePlayer = new PianoNote();
        piano = pp;
    }

    // MODIFIES: this
    // EFFECTS: receives the last pressed key string value,
    //          call play song on last pressed note, update piano panel
    public void keyPressed(KeyEvent ke) {
        char temp;

        if (isListening) {
            temp = ke.getKeyChar();
            System.out.print(temp);

            if(this.attemptSong.size() == 3){
                this.attemptSong.add(String.valueOf(temp));
                System.out.print(this.attemptSong);
                System.out.print(this.currSong);
                if(this.currSong.equals(this.attemptSong)){
                    System.out.print("done");
                    System.out.println("Congratulation! You complete the song!\n next song!");
                    this.startNewSong();

                } else {
                    this.attemptSong.clear();
                    System.out.println("try again!");
                }
            } else {
                this.attemptSong.add(String.valueOf(temp));
            }
            lastKeyPressed = Character.toString(temp).toLowerCase();

            if (PIANO_KEYS.contains(lastKeyPressed)) {
                piano.brightenKey(lastKeyPressed);
                piano.repaint();
                playSong(lastKeyPressed);
                //piano.darkenKey(lastKeyPressed);
                //piano.repaint();

            } else if (lastKeyPressed.equalsIgnoreCase("r")) {
                for (String s: currSong) {
                    playSong(s);
                }
            } else if (lastKeyPressed.equalsIgnoreCase("n")) {

                //piano.repaint();
                currSong = sqGen.generateString();
                for (String s: currSong) {
                    playSong(s);
                }
                System.out.println(currSong);
            }
        }
    }

    // EFFECTS: returns true if the input string matches the corresponding string in song
    public boolean checkKey(String expectedNote){

        while(true) {
            if (PIANO_KEYS.contains(lastKeyPressed)) {
                return (lastKeyPressed.equalsIgnoreCase(expectedNote));
            }
        }

    }

    // EFFECTS: play the current song
    public void playSong(String note){
        notePlayer.playNote(note);
    }

    // EFFECTS: update the piano panel with the last pressed key
    public void updatePanel(String inputKey) {
        piano.brightenKey(inputKey.toLowerCase());
        piano.repaint();
    }


    // EFFECTS: starts a new song
    public void startNewSong(){

        isCorrectKey = true;
        isNextGame = false;
        isGameComplete = false;
        isListening = false;


        currSong = sqGen.generateString();
        ArrayList<String> song = currSong;
        String note;

        System.out.println(currSong);

        for (String s : currSong) {
            playSong(s);
        }
        isListening = true;

//        while (!isGameComplete) {
//
//            while (isCorrectKey && song.size() > 0) {
//                isListening = true;
//                note = song.get(0);
//
//                //while (!b) {}
//
//                isCorrectKey = checkKey(note);
//
//
//                song.remove(0);
//            }
//
//            if (song.size() == 0) {
//                isListening = false;
//                isGameComplete = true;
//            }
//
//            System.out.println("try again!");
//        }
//
//        if (isGameComplete && isCorrectKey) {
//            System.out.println("Congratulation! You complete the song!\n next song!");
//        }
    }

}
