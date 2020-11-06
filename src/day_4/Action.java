package day_4;

public class Action {
	public int year,month,day;
	public int hour,mins;
	public boolean asleep;

	public Action(String action) {
		decodeAction(action);
	}

	private void decodeAction(String action) {
		String date = action.substring(1, 11);
		this.year = Integer.parseInt(date.split("-")[0]);
		this.month = Integer.parseInt(date.split("-")[1]);
		this.day = Integer.parseInt(date.split("-")[2]);

		String time = action.substring(12, 17);
		this.hour = Integer.parseInt(time.split(":")[0]);
		this.mins = Integer.parseInt(time.split(":")[1]);

		this.asleep = action.substring(19).equals("falls asleep");
	}
}
