package day_3;

import java.awt.*;

public class Claim {
	private String claim;

	private int ID;
	private int x, y, w, h;

	public Claim(String claim) {
		this.claim = claim;
		decodeClaim(this.claim);
	}

	private void decodeClaim(String claim) {
		this.ID = Integer.parseInt(claim.substring(1, claim.indexOf('@')-1));
		this.x = Integer.parseInt(claim.substring(claim.indexOf('@')+2, claim.indexOf(',')));
		this.y = Integer.parseInt(claim.substring(claim.indexOf(',')+1, claim.indexOf(':')));
		this.w = Integer.parseInt(claim.substring(claim.indexOf(':')+2, claim.indexOf('x')));
		this.h = Integer.parseInt(claim.substring(claim.indexOf('x')+1));
	}

	public int getID() {
		return this.ID;
	}
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.w, this.h);
	}
	public String getClaim() {
		return this.claim;
	}

}
