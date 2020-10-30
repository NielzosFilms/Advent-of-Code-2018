package day_2;

import helpers.TextFile;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryManagementSystem {
	private ArrayList<String> lines = new ArrayList<String>();

	public InventoryManagementSystem() {
		TextFile textFile = new TextFile("inputs/day_2/input.txt");
		this.lines = textFile.getLines();

		//checkSum();
		findBox();
	}

	private void findBox() {
		for(String line : lines) {
			for(String line_compare : lines) {
				boolean res = compareStrings(line, line_compare);
				if(res) {
					System.out.println(line);
					System.out.println(line_compare);
					System.out.println(removeDifferentChar(line, line_compare));
					System.out.println("");
				}
			}
		}
	}

	private String removeDifferentChar(String str_1, String str_2) {
		StringBuilder sb = new StringBuilder(str_1);

		for(int i = 0; i < str_1.length(); i++) {
			char tmp_1 = str_1.charAt(i);
			char tmp_2 = str_2.charAt(i);
			if(tmp_1 != tmp_2) {
				sb.deleteCharAt(i);
				return sb.toString();
			}
		}
		return null;
	}

	private boolean compareStrings(String str_1, String str_2) {
		int matches = 0;

		for(int i = 0; i < str_1.length(); i++) {
			char tmp_1 = str_1.charAt(i);
			char tmp_2 = str_2.charAt(i);
			if(tmp_1 == tmp_2) matches++;
		}

		return str_1.length()-1 == matches;
	}

	private void checkSum() {
		int count_2 = 0, count_3 = 0;
		for(String line : lines) {
			HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
			char[] chars = line.toCharArray();
			for(char let : chars) {
				if(characters.containsKey(let)) {
					characters.put(let, characters.get(let) + 1);
				} else {
					characters.put(let, 1);
				}
			}

			int char_3_count = 0;
			int char_2_count = 0;
			for(char key : characters.keySet()) {
				int val = characters.get(key);

				switch (val) {
					case 2 -> char_2_count++;
					case 3 -> char_3_count++;
				}
			}

			if(char_2_count == 1 && char_3_count == 1) {
				count_2++;
				count_3++;
			} else if(char_2_count >= 1) {
				count_2++;
			} else if(char_3_count >= 1) {
				count_3++;
			}
		}
		System.out.println("Checksum: " + (count_2 * count_3));
	}

	public static void main(String args[]) {
		new InventoryManagementSystem();
	}
}
