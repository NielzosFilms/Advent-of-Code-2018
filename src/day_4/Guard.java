package day_4;

import java.util.ArrayList;
import java.util.HashMap;

public class Guard {
	private ArrayList<String> guard_actions_str;
	private ArrayList<Action> actions = new ArrayList<>();
	private ArrayList<Sleep> sleep;
	private int ID;

	public Guard(ArrayList<String> guard_actions_str) {
		this.guard_actions_str = guard_actions_str;
		decodeLines();
	}

	private void decodeLines() {
		String id_line = guard_actions_str.get(0);
		this.ID = Day4.getIDFromLine(id_line);

		for(int i = 1; i < guard_actions_str.size(); i++) {
			actions.add(new Action(guard_actions_str.get(i)));
		}
		actionsToSleep();
	}

	public void addLines(ArrayList<String> lines) {
		this.guard_actions_str.addAll(lines);
		for(String line : lines) {
			actions.add(new Action(line));
		}
		actionsToSleep();
	}

	public int getID() {
		return this.ID;
	}

	public int getTotalTimeAsleep() {
		int tot = 0;
		for(Sleep sleep : this.sleep) {
			tot += sleep.getSleepTime();
		}
		return tot;
	}

	private void actionsToSleep() {
		this.sleep = new ArrayList<>();
		for(int i = 0; i < actions.size() -1; i+=2) {
			this.sleep.add(new Sleep(actions.get(i), actions.get(i+1)));
		}
	}

	public int getBestMin() {
		HashMap<Integer, Integer> checked = new HashMap<>();
		for(Sleep sleep_1 : this.sleep) {
			for(Sleep sleep_2 : this.sleep) {
				if(sleep_1 == sleep_2) continue;
				if(sleep_1.fall_asleep.day == sleep_2.fall_asleep.day) {
					if(sleep_1.fall_asleep.month == sleep_2.fall_asleep.month) continue;
				}
				for(int min = sleep_1.fall_asleep.mins; min < sleep_1.wake_up.mins; min++) {
					if(sleep_2.containsMin(min)) {
						if(checked.containsKey(min)) {
							checked.put(min, checked.get(min) + 1);
						}else {
							checked.put(min, 1);
						}
					}
				}
			}
		}
		int ret_key = 0, val = 0;
		for(Integer key : checked.keySet()) {
			if(checked.get(key) > val) {
				val = checked.get(key);
				ret_key = key;
			}
		}
		return ret_key;
	}
}
