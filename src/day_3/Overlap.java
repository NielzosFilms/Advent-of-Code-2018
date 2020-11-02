package day_3;

import java.awt.geom.Rectangle2D;

public class Overlap {
	public int ID_1, ID_2;
	public int square_inches_overlap;
	public Rectangle2D overlap;

	public Overlap(int ID_1, int ID_2, Rectangle2D overlap) {
		this.ID_1 = ID_1;
		this.ID_2 = ID_2;
		this.overlap = overlap;
		this.square_inches_overlap = (int)(overlap.getWidth() * overlap.getHeight());
	}

	public boolean checkIDs(int ID_1, int ID_2) {
		if(ID_1 == this.ID_1 && ID_2 == this.ID_2) {
			return true;
		} else if(ID_1 == this.ID_2 && ID_2 == this.ID_1) {
			return true;
		}
		return false;
	}
}
