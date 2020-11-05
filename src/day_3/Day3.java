package day_3;

import helpers.TextFile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Day3 {
	private final ArrayList<Claim> claims = new ArrayList<Claim>();
	private ArrayList<Point> claimed_coords = new ArrayList<Point>();
	private ArrayList<Point> counted_coords = new ArrayList<Point>();

	private int multiple_claim_count = 0;

	public Day3() {
		TextFile textFile = new TextFile("inputs/day_3/input.txt");
		for(String line : textFile.getLines()) {
			this.claims.add(new Claim(line));
		}
		for(Claim claim : claims) {
			for(Point coord : claim.getAllCoords()) {
				addClaimedCoord(coord, claim);
			}
		}
		for(Claim claim : claims) {
			boolean overlap = false;
			for(Point coord : claim.getAllCoords()) {
				int count = Collections.frequency(this.claimed_coords, coord);
				if(count > 1) {
					overlap = true;
					break;
				}
			}
			if(!overlap) System.out.println("No overlap ID: " + claim.getID());
		}
		System.out.println(multiple_claim_count);
	}

	private void addClaimedCoord(Point coord, Claim claim) {
		/*if(this.claimed_coords.contains(coord)) {
			if(!this.counted_coords.contains(coord)) {
				this.multiple_claim_count++;
				this.counted_coords.add(coord);
			}
			return;
		}*/
		this.claimed_coords.add(coord);
	}

	public static void main(String args[]) {
		new Day3();
	}

}
