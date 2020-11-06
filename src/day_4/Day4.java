package day_4;

import helpers.TextFile;

import java.util.ArrayList;

import static helpers.HelperFunctions.getSubList;
import static helpers.HelperFunctions.getNextCharIndex;

public class Day4 {
	private final ArrayList<String> LINES;
	private ArrayList<Guard> guards = new ArrayList<>();

	public Day4() {
		TextFile textFile = new TextFile("inputs/day_4/input.txt");
		this.LINES = textFile.getLines();
		this.guards = decodeLinesToGuards(this.LINES);

		Guard guard = getGuardHighestTotSleep(this.guards);
		System.out.println(guard.getBestMin());
		System.out.println(guard.getID());
	}

	private ArrayList<Guard> decodeLinesToGuards(ArrayList<String> lines) {
		ArrayList<Guard> guards = new ArrayList<>();
		for(int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			if(line.contains("#")) {
				Guard guard = getGuardWithID(guards, getIDFromLine(line));
				if(guard != null) {
					int end_i = getNextCharIndex(lines, i, "#") - 1;
					guard.addLines(getSubList(lines, i+1, end_i));
					i = end_i;
				} else {
					int end_i = getNextCharIndex(lines, i, "#") - 1;
					guards.add(new Guard(getSubList(lines, i, end_i)));
					i = end_i;
				}
			}
		}
		return guards;
	}

	private Guard getGuardWithID(ArrayList<Guard> guards, int ID) {
		for(Guard guard : guards) {
			if(guard.getID() == ID) {
				return guard;
			}
		}
		return null;
	}

	public static int getIDFromLine(String line) {
		int hashI = line.indexOf("#") + 1;
		return Integer.parseInt(line.substring(hashI, line.indexOf(" ", hashI)));
	}

	private Guard getGuardHighestTotSleep(ArrayList<Guard> guards) {
		Guard ret = null;
		for(Guard guard : guards) {
			if(ret == null) {
				ret = guard;
			} else {
				if(guard.getTotalTimeAsleep() > ret.getTotalTimeAsleep()) {
					ret = guard;
				}
			}
		}
		return ret;
	}

	public static void main(String args[]) {
		new Day4();
	}
}
