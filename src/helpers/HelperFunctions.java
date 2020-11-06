package helpers;

import java.util.ArrayList;

public class HelperFunctions {
	public static ArrayList<String> getSubList(ArrayList<String> lines, int start_i, int end_i) {
		ArrayList<String> new_lines = new ArrayList<>();
		for(int i = start_i; i <= end_i;i++) {
			new_lines.add(lines.get(i));
		}
		return new_lines;
	}

	public static int getNextCharIndex(ArrayList<String> lines, int offset, String character) {
		for(int i = offset + 1; i < lines.size(); i++) {
			if(lines.get(i).contains(character)) {
				return i;
			}
		}
		return lines.size() -1;
	}
}
