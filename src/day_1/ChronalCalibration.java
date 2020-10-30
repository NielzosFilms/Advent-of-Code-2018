package day_1;

import helpers.TextFile;
import javax.script.ScriptException;
import java.util.ArrayList;

public class ChronalCalibration {
    private final TextFile textFile;

    private static final int START_FREQ = 0;

    private int freq;
    private final ArrayList<Integer> frequencies = new ArrayList<Integer>();

    public ChronalCalibration() throws ScriptException {

        this.textFile = new TextFile("inputs/day_1/input.txt");
        this.freq = START_FREQ;
        ArrayList<String> changes = this.textFile.getLines();
        this.frequencies.add(START_FREQ);

        boolean running = true;
        while(running) {
            for (String change : changes) {
                int change_int = Integer.parseInt(change);
                this.freq += change_int;

                if (frequencyExists(this.freq)) {
                    running = false;
                    break;
                } else {
                    this.frequencies.add(this.freq);
                }
            }
        }
        System.out.println(this.freq);
    }

    private boolean frequencyExists(int freq) {
        for(int found_freq : this.frequencies) {
            if(found_freq == freq) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            new ChronalCalibration();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
