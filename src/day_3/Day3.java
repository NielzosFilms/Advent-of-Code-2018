package day_3;

import helpers.TextFile;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Day3 {
	private ArrayList<String> lines = new ArrayList<String>();
	private ArrayList<Claim> claims = new ArrayList<Claim>();
	private ArrayList<Overlap> overlaps = new ArrayList<Overlap>();

	public Day3() {
		TextFile textFile = new TextFile("inputs/day_3/input.txt");
		this.lines = textFile.getLines();

		decodeLines();
		int tmp = calculateOverlap();
		int output = tmp - getDiff();
		System.out.println(output);
	}

	private int calculateOverlap() {
		int res = 0;
		for(Claim claim_1 : claims) {
			System.out.println("calculateOverlap ID: " + claim_1.getID());
			for(Claim claim_2 : claims) {
				if(claim_1 == claim_2) continue;
				if(claim_1.getBounds().intersects(claim_2.getBounds())) {
					if(!containsOverlap(this.overlaps, claim_1.getID(), claim_2.getID())) {
						Rectangle2D overlap = claim_1.getBounds().createIntersection(claim_2.getBounds());
						res += overlap.getWidth() * overlap.getHeight();
						addOverlap(claim_1.getID(), claim_2.getID(), overlap);
					}
				}
			}
		}
		return res;
	}

	private void addOverlap(int ID_1, int ID_2, Rectangle2D overlap) {
		overlaps.add(new Overlap(ID_1, ID_2, overlap));
	}

	private int getDiff() {
		HashMap<Overlap, ArrayList<Overlap>> checkedOverlaps = new HashMap<>();
		int sub = 0;
		for(Overlap tmp_1 : overlaps) {
			System.out.println("getDiff ID: " + tmp_1.ID_1);
			ArrayList<Overlap> checked = new ArrayList<Overlap>();
			checkedOverlaps.put(tmp_1, checked);
			for(Overlap tmp_2 : overlaps) {
				if(tmp_1 != tmp_2) {
					if(checkedOverlaps.containsKey(tmp_2)) {
						if (!checkedOverlaps.get(tmp_2).contains(tmp_1)) {
							if (tmp_1.overlap.getBounds().intersects(tmp_2.overlap.getBounds())) {
								Rectangle2D overlap = tmp_1.overlap.getBounds().createIntersection(tmp_2.overlap.getBounds());
								sub += overlap.getWidth() * overlap.getHeight();
								checked.add(tmp_2);
							}
						}
					}
				}
			}
			checkedOverlaps.put(tmp_1, checked);
		}
		return sub;
	}

	private boolean containsOverlap(ArrayList<Overlap> overlaps, int ID_1, int ID_2) {
		for(Overlap overlap : overlaps) {
			if(overlap.checkIDs(ID_1, ID_2)) {
				return true;
			}
		}
		return false;
	}

	private void decodeLines() {
		for(String line : lines) {
			claims.add(new Claim(line));
		}
	}

	public static void main(String args[]) {
		new Day3();
	}

}
