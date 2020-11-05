package day_3;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Claim {
	private String claim;
	private boolean overlap;

	private int ID;
	private int x, y, w, h;

	public Claim(String claim) {
		this.claim = claim;
		decodeClaim(this.claim);
		this.overlap = false;
	}

	private void decodeClaim(String claim) {
		this.ID = Integer.parseInt(claim.substring(1, claim.indexOf('@')-1));
		this.x = Integer.parseInt(claim.substring(claim.indexOf('@')+2, claim.indexOf(',')));
		this.y = Integer.parseInt(claim.substring(claim.indexOf(',')+1, claim.indexOf(':')));
		this.w = Integer.parseInt(claim.substring(claim.indexOf(':')+2, claim.indexOf('x')));
		this.h = Integer.parseInt(claim.substring(claim.indexOf('x')+1));
	}

	public ArrayList<Point> getAllCoords() {
		ArrayList<Point> coords = new ArrayList<Point>();
		for(int yy = 0;yy < this.h; yy++) {
			for(int xx = 0;xx < this.w; xx++) {
				coords.add(new Point(this.x + xx, this.y + yy));
			}
		}
		return coords;
	}

	public void setOverlap(boolean overlap) {
		this.overlap = overlap;
	}

	public boolean getOverlap() {
		return this.overlap;
	}

	public int getID() {
		return this.ID;
	}

}
