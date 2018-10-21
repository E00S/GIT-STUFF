/** This is the Only Level. */
public class Game {

	/** Starts a new game. */
	public static void main(String[] args) {
		new Game().run();
	}

	// Names the model for Game
	private GameModel model;

	/** Changes the height of the jump. */
	private double moveY;

	/** Runs the game. */
	public void run() {
		StdDraw.enableDoubleBuffering();
		// Title Screen
		titleScreen();
		// Creates new instance of Game Model
		model = new GameModel();
		while (true) {
			draw();
			// Handles left and right movement
			handleKeyPresses();
			// Handles jumping
			if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP)) {
				// Resets the movement value of Y for each jump
				moveY = .01;
				while (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP)) {
					// wait for release
				}
			}
			jump();
			model.spikeHit();
		}
	}

	/** Draws every aspect of the game. */
	public void draw() {
		StdDraw.clear(StdDraw.BLACK);
		// Draw player
		drawPlayer(model.getPlayer());
		// Draw floors
		drawPlatforms();
		// Draw spikes
		drawSpike();
		// Draw button
		drawButton(model.getButton());
		// Draw gate
		drawGate(model.getGate());
		if(model.exitReached()) {
			winScreen();
		}
		// Show the results
		StdDraw.show();
		StdDraw.pause(15);
	}
	
	/** Draws the title screen. */
	public void titleScreen() {
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(0.5, 0.75, "This is the Only Level");
		StdDraw.text(0.5, 0.4, "Player: maneuver with arrow keys.");
		StdDraw.text(0.5, 0.2, "Avoid spikes, and get to the end of the level.");
		StdDraw.text(0.5, 0.1, "Press space to start.");
		StdDraw.show();
		while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
			// Wait for spacebar
		}
	}
	
	/** The win screen. */
	public void winScreen() {
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(0.5, 0.75, "You Win!");
		StdDraw.text(0.5, 0.4, "Press spacebar to quit.");
		StdDraw.show();
		while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
			// Wait for spacebar
		}
		System.exit(0);
	}

	/** Draws the floors. */
	private void drawPlatforms() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(model.getPlatform1().getX(), model.getPlatform1().getY(),
				model.getPlatform1().getHeight(), model.getPlatform1().getWidth());
		StdDraw.filledRectangle(model.getPlatform2().getX(), model.getPlatform2().getY(),
				model.getPlatform2().getHeight(), model.getPlatform2().getWidth());
		StdDraw.filledRectangle(model.getPlatform3().getX(), model.getPlatform3().getY(),
				model.getPlatform3().getHeight(), model.getPlatform3().getWidth());
		StdDraw.filledRectangle(model.getPlatform4().getX(), model.getPlatform4().getY(),
				model.getPlatform4().getHeight(), model.getPlatform4().getWidth());
		StdDraw.filledRectangle(model.getPlatform5().getX(), model.getPlatform5().getY(),
				model.getPlatform5().getHeight(), model.getPlatform5().getWidth());
		StdDraw.filledRectangle(model.getPlatform6().getX(), model.getPlatform6().getY(),
				model.getPlatform6().getHeight(), model.getPlatform6().getWidth());
		StdDraw.filledRectangle(model.getPlatform7().getX(), model.getPlatform7().getY(),
				model.getPlatform7().getHeight(), model.getPlatform7().getWidth());
		StdDraw.filledRectangle(model.getPlatform8().getX(), model.getPlatform8().getY(),
				model.getPlatform8().getHeight(), model.getPlatform8().getWidth());
		StdDraw.filledRectangle(model.getPlatform9().getX(), model.getPlatform9().getY(),
				model.getPlatform9().getHeight(), model.getPlatform9().getWidth());
		StdDraw.filledRectangle(model.getPlatform10().getX(), model.getPlatform10().getY(),
				model.getPlatform10().getHeight(), model.getPlatform10().getWidth());
		StdDraw.filledRectangle(model.getPlatform11().getX(), model.getPlatform11().getY(),
				model.getPlatform11().getHeight(), model.getPlatform11().getWidth());
	}

	/** Draws the spikes. */
	public void drawSpike() {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		double[] x1 = { .3, .35, .325 };// floor
		double[] y1 = { 0, 0, .05 };
		StdDraw.filledPolygon(x1, y1);
		double[] x2 = { .35, .4, .375 };
		double[] y2 = { 0, 0, .05 };
		StdDraw.filledPolygon(x2, y2);
		double[] x3 = { .4, .45, .425 };
		double[] y3 = { 0, 0, .05 };
		StdDraw.filledPolygon(x3, y3);
		double[] x4 = { .45, .5, .475 };
		double[] y4 = { 0, 0, .05 };
		StdDraw.filledPolygon(x4, y4);
		double[] x5 = { .5, .55, .525 };
		double[] y5 = { 0, 0, .05 };
		StdDraw.filledPolygon(x5, y5);
		double[] x6 = { .55, .6, .575 };
		double[] y6 = { 0, 0, .05 };
		StdDraw.filledPolygon(x6, y6);
		double[] x7 = { .6, .65, .625 };
		double[] y7 = { 0, 0, .05 };
		StdDraw.filledPolygon(x7, y7);
		double[] x8 = { .65, .7, .675 };
		double[] y8 = { 0, 0, .05 };
		StdDraw.filledPolygon(x8, y8); // floor
		//double[] x9 = { .7, .75, .725 }; // gate left
		//double[] y9 = { .15, .15, .2 };
		//StdDraw.filledPolygon(x9, y9);
		//double[] x10 = { .75, .8, .775 };
		//double[] y10 = { .15, .15, .2 };
		//StdDraw.filledPolygon(x10, y10); // left
		double[] x11 = { .9, .95, .925 }; // right
		double[] y11 = { .15, .15, .2 };
		StdDraw.filledPolygon(x11, y11);
		double[] x12 = { .95, 1, .975 };
		double[] y12 = { .15, .15, .2 };
		StdDraw.filledPolygon(x12, y12); // gate right
		double[] x13 = { .5, .55, .525 }; // middle no-button platform
		double[] y13 = { .35, .35, .4 };
		StdDraw.filledPolygon(x13, y13);
		double[] x14 = { .55, .6, .575 };
		double[] y14 = { .35, .35, .4 };
		StdDraw.filledPolygon(x14, y14); // middle no-button platform
		double[] x15 = { 0, .05, .025 }; // left platform
		double[] y15 = { .5, .5, .45 };
		StdDraw.filledPolygon(x15, y15);
		double[] x16 = { .05, .1, .075 };
		double[] y16 = { .5, .5, .45 };
		StdDraw.filledPolygon(x16, y16);
		double[] x17 = { .1, .15, .125 };
		double[] y17 = { .5, .5, .45 };
		StdDraw.filledPolygon(x17, y17);
		double[] x18 = { .15, .2, .175 };
		double[] y18 = { .5, .5, .45 };
		StdDraw.filledPolygon(x18, y18);
		double[] x19 = { .2, .25, .225 };
		double[] y19 = { .5, .5, .45 };
		StdDraw.filledPolygon(x19, y19);
		double[] x20 = { 0, .05, .025 };
		double[] y20 = { .55, .55, .6 };
		StdDraw.filledPolygon(x20, y20); // double
		double[] x21 = { .05, .1, .075 };
		double[] y21 = { .55, .55, .6 };
		StdDraw.filledPolygon(x21, y21); // double
		double[] x22 = { .25, .25, .3 };
		double[] y22 = { .55, .5, .525 };
		StdDraw.filledPolygon(x22, y22); // left platform/single
		double[] x23 = { .3, .3, .25 }; // button left platform
		double[] y23 = { .7, .75, .725 };
		StdDraw.filledPolygon(x23, y23);
		double[] x24 = { .3, .3, .25 };
		double[] y24 = { .75, .8, .775 };
		StdDraw.filledPolygon(x24, y24);
		double[] x25 = { .3, .3, .25 };
		double[] y25 = { .8, .85, .825 };
		StdDraw.filledPolygon(x25, y25); // button left platform
		double[] x26 = { .55, .6, .575 }; // button right platform
		double[] y26 = { .75, .75, .8 };
		StdDraw.filledPolygon(x26, y26);
		double[] x27 = { .6, .65, .625 };
		double[] y27 = { .75, .75, .8 };
		StdDraw.filledPolygon(x27, y27);
		double[] x28 = { .65, .7, .675 };
		double[] y28 = { .75, .75, .8 };
		StdDraw.filledPolygon(x28, y28); // button right platform
		//double[] x29 = { .8, .85, .825 }; // right most platform
		//double[] y29 = { .6, .6, .65 };
		//StdDraw.filledPolygon(x29, y29);
		//double[] x30 = { .85, .9, .875 };
		//double[] y30 = { .6, .6, .65 };
		//StdDraw.filledPolygon(x30, y30);
		//double[] x31 = { .9, .95, .925 };
		//double[] y31 = { .6, .6, .65 };
		//StdDraw.filledPolygon(x31, y31);
		//double[] x32 = { .95, 1, .975 };
		//double[] y32 = { .6, .6, .65 };
		//StdDraw.filledPolygon(x32, y32); // right most platform

	}

	/** Draws the player. */
	public void drawPlayer(Extent c) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(c.getX(), c.getY(), .01);
	}

	/** Draws the button. */
	public void drawButton(Extent b) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(b.getX(), b.getY(), b.getHeight(), b.getWidth());
	}

	/** Draws the gate. */
	public void drawGate(Extent g) {
		StdDraw.setPenColor(StdDraw.YELLOW);
		if (model.buttonPress(model.getPlayer()) == true) {
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		StdDraw.filledRectangle(g.getX(), g.getY(), g.getHeight(), g.getWidth());
	}

	/** Handles the player's left and right movement. */
	public void handleKeyPresses() {
		// Gets the player from the model
		Extent player = model.getPlayer();
		// Left key is pressed
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT)) {
			// Moves player left by the value given to move
			player.move(-.005);
			// This value should be negative
		}
		// Right key is pressed
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT)) {
			// Moves player right by the value given to move
			player.move(.005);
			// This value should be positive
		}
	}

	/** Causes the player to jump. */
	public void jump() {
		// Gets the current floor of the player from the game model
		double floor = model.getPlayer().currentFloor();
		if (floor == 0.05 && !model.buttonPress(model.getPlayer())) {
			floor = model.getGate().getY() + .01;
		}
		// Gets the current ceiling of the player from the game model
		// Gets the player from the game model and sets their Y value
		// equal to their current Y value + moveY
		model.getPlayer().setY(model.getPlayer().getY() + moveY);
		// Prevents the player from sinking below their current floor due to gravity
		if (model.getPlayer().getY() < floor) {
			model.getPlayer().setY(floor + .01);
		}
		if (model.getPlayer().getY() > 1) {
			model.getPlayer().setY(1);
		}
		// Enacts a gravity for jumping
		moveY -= 0.00017;
	}

}