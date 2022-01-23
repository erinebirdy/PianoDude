package Sound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SequenceGenerator {
    public static final ArrayList<String> NOTES = new ArrayList<>(Arrays.asList("a","b", "c", "d", "e", "f", "g"));

    public ArrayList<String> sequence;

    public SequenceGenerator(){
        sequence = new ArrayList<>();
    }

    public ArrayList<String> generateString() {
        sequence.clear();
        sequence.add("c");

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(NOTES.size());
            sequence.add(NOTES.get(index));
        }
        return sequence;
    }

}
