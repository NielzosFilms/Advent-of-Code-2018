package day_4;

public class Sleep {
	public Action fall_asleep;
	public Action wake_up;

	public Sleep(Action fall_asleep, Action wake_up) {
		this.fall_asleep = fall_asleep;
		this.wake_up = wake_up;
	}

	public int getSleepTime() {
		return this.wake_up.mins - this.fall_asleep.mins;
	}

	public boolean containsMin(int min) {
		return min >= fall_asleep.mins && min < wake_up.mins;
	}
}
