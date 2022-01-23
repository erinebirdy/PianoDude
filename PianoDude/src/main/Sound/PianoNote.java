package Sound;

import org.jfugue.player.Player;

public class PianoNote {
    Player player;
    public PianoNote(){
        player = new Player();
    }
    public void playNote(String note) {
        player.play(note.toUpperCase());
    }
}