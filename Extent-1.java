/** The invisible bubble around an object. */
public class Extent {
	// NOTE: Some code borrowed from Asteroid Rally.

	private double x;
	private double y;
	private double length;
	private double height;
	private double width;


	/** Creates a new extent, with the X and Y values of the object's center and the length from the object's center to the edge of its extent. */
	public Extent(double x, double y, double length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}
	
	/** Creates a new extent, with the X and Y values of the object's center, the height from the object's center to the top edge of its extent, and the width from the object's center to its right edge. */
	public Extent(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	/** Returns the X value of the center of an object's extent. */
	public double getX() {
		return x;
	}

	/** Returns the Y value of the center of an object's extent. */
	public double getY() {
		return y;
	}
	
	/** Sets the X value of the center of an object's extent. */
	public void setX(double x) {
		this.x = x;
	}
	
	/** Sets the Y value of the center of an object's extent. */
	public void setY(double y) {
		this.y = y;
	}

	/** Returns the length from the center of an object's extent to the edge of its extent. */
	public double getLength() {
		return length;
	}
	
	/** Returns the length from the center of an object's extent to the top edge of its extent. */
	public double getHeight() {
		return height;
	}
	
	/** Returns the length from the center of an object's extent to the side edge of its extent. */
	public double getWidth() {
		return width;
	}

	/** Moves an object horizontally by the value given. */
	public void move(double moveX) {
		if ((x+moveX) < 1 && (x+moveX) > 0) {
			x = x + moveX;
		}
	}
	
	/** Returns current floor (in the form of a Y value) of player. */
	public double currentFloor() {
		// If the player is over platform three
		if (x <= 0.1 && y > 0.75) {
			return 0.75;
		}
		
		// If the player is over platform two
		if (x <= 0.25 && y > 0.55) {
			return 0.55;
		}
		
		// If the player is over platform one
		if (x <= 0.30 && y > 0.15) {
			return 0.15;
		}
		
		// If the player is over platform four
		if (x >= 0.30 && x <= 0.55 && y > 0.85) {
			return 0.85;
		}
		
		// If the player is over platform seven
		if (x >= 0.4 && x <= 0.6 && y > 0.35 && y< 0.55) {
			return 0.35;
		}
		
		// If the player is over platform five
		if (x >= 0.55 && x <= 0.7 && y > 0.75) {
			return 0.75;
		}
		
		// If the player is over platform six
		if (x >= 0.55 && x <= 0.7 && y > 0.55) {
			return 0.55;
		}
		
		// If the player is over platform eleven
		if (x >= 0.7 && x <= 0.8 && y > 0.15) {
			return 0.15;
		}
		
		// If the player is over platform eight
		if (x >= 0.8 && x <= 1 && y > 0.6) {
			return 0.6;
		}
		
		// If the player is over platform nine
		if (x >= 0.8 && x <= 0.9 && y > 0.05) {
			return 0.05;
		}
		
		// If the player is over platform ten
		if (x >= 0.9 && x <= 1 && y > 0.15) {
			return 0.15;
		}
				
		
		// Otherwise, the player is over the ground level
		else {
			return 0.0;
		}
	}
	
	/** Detects overlap between circle-shaped extents and rectangular extents */
	public Boolean overlaps(Extent rectangle) {
		
		double charX = this.x;
		double charY = this.y;
		double rectX = rectangle.getX();
		double rectY = rectangle.getY();
		//height and width are temporarily changed
		double rectWidth = rectangle.getWidth();
		double rectHeight = rectangle.getHeight();
		
		//X and Y distance between circle and rectangle
		double xDistance = Math.abs(charX - rectX);
		double yDistance = Math.abs(charY - rectY);
		
		//is circle above or below rectangle = check Y
				if (yDistance > (rectHeight) + length) {
					return false;
				}
				//is circle to the side of rectangle = check X
				if (xDistance > (rectWidth) + length) {
					return false;
				}
				//if side overlap
				if (xDistance - rectWidth <= rectWidth || yDistance - rectWidth <= rectWidth) {
					return true;
				}
				//is circle on corner of rectangle
				double cornerDistance = Math.pow(xDistance - rectWidth - length, 2) + Math.pow(yDistance - rectY - length, 2);
				return cornerDistance <= (Math.pow(length, 2));
			}
	
	/** Set new extent height */
	public void setHeight(double inputHeight) {
		height = inputHeight;
		
	}
	/** Set new extent width */
	public void setWidth(double inputWidth) {
		width = inputWidth;
	}
	
}