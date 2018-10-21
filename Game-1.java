import java.awt.Font;

/** This is the Only Level. */
public class Game {

	/** Starts a new game. */
	public static void main(String[] args) {
		new Game().run();
	}

	// Names the model for Game
	private GameModel model;

	// Level counter
	private int level = 1;

	// Changes the height of the jump
	private double moveY;

	// Prevents double jumping
	private int jumpCount = 0;

	/** Runs the game. */
	public void run() {
		StdDraw.enableDoubleBuffering();
		// Title Screen
		titleScreen();
		// Creates new instance of Game Model
		model = new GameModel();
		while (true) {
			// If you already jumped, you can't jump again until you land on a platform.
			if (model.getPlayer().currentFloor() + .02 > model.getPlayer().getY()) {
				jumpCount = 1;
			}
			draw();
			// Handles left and right movement
			handleKeyPresses();
			// Handles jumping
			jump();
			model.spikeHit(model.getPlayer());
		}
	}

	/** Draws every aspect of the game. */
	public void draw() {
		if (level == 1) {
			StdDraw.clear(StdDraw.BLACK);
		} else if (level == 2) {
			StdDraw.clear(StdDraw.GRAY);
		} else if (level == 3) {
			StdDraw.clear(StdDraw.PINK);
		} else if (level == 4) {
			StdDraw.clear(StdDraw.YELLOW);
		} else if (level == 5) {
			StdDraw.clear(StdDraw.WHITE);
		}
		// Draw player
		drawPlayer(model.getPlayer());
		if (level < 5) {
			// Draw platforms
			drawPlatforms();
		}
		// Draws info
		drawInfo();
		if (level < 4) {
			// Draw spikes
			drawSpike();
		}
		// Draw button
		drawButton(model.getButton());
		// Draw gate
		drawGate(model.getGate());
		if (model.exitReached(model.getPlayer())) {
			level++;
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

	/** Draws the win screen for each level. */
	public void winScreen() {
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		if (level == 2) {
			StdDraw.text(0.5, 0.75, "LEVEL ONE");
			StdDraw.text(0.5, 0.6, "The level is over... or is it?");
			StdDraw.text(0.5, 0.4, "Press spacebar to continue.");
			StdDraw.show();
			while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
				// Wait for spacebar
			}
			model.reset();
		}
		if (level == 3) {
			StdDraw.text(0.5, 0.75, "LEVEL ONE");
			StdDraw.text(0.5, 0.6, "The level is over... or is it?");
			StdDraw.text(0.5, 0.4, "Press spacebar to continue.");
			StdDraw.show();
			while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
				// Wait for spacebar
			}
			model.reset();
		}
		if (level == 4) {
			StdDraw.text(0.5, 0.75, "LEVEL ONE");
			StdDraw.text(0.5, 0.6, "The level is over... or is it?");
			StdDraw.text(0.5, 0.4, "Press spacebar to continue.");
			StdDraw.show();
			while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
				// Wait for spacebar
			}
			model.reset();
		}
		if (level == 5) {
			StdDraw.text(0.5, 0.75, "LEVEL ONE");
			StdDraw.text(0.5, 0.6, "The level is over... or is it?");
			StdDraw.text(0.5, 0.4, "Press spacebar to continue.");
			StdDraw.show();
			while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
				// Wait for spacebar
			}
			model.reset();
		}
		if (level == 6) {
			StdDraw.text(0.5, 0.75, "You Win!");
			if (model.getDeaths() == 0) {
				StdDraw.text(0.5,  0.6, "Congratulations!");
			}
			else {
			StdDraw.text(0.5, 0.6, "You only died " + model.getDeaths() + " times!!");
			}
			StdDraw.text(0.5, 0.4, "Press spacebar to quit.");
			StdDraw.show();
			while (!StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
				// Wait for spacebar
			}
			System.exit(0);
		}
	}

	/** Draws the hint for every level and the total death counter. */
	public void drawInfo() {
		StdDraw.setPenColor(StdDraw.BLACK);
		Font font = new Font("Arial", Font.BOLD, 16);
		StdDraw.setFont(font);
		if (level == 1) {
			StdDraw.text(0.15, 0.1, "Easy-going");
		}
		if (level == 2) {
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.text(0.15, 0.1, "Opposites Attract");
		}
		if (level == 3) {
			StdDraw.text(0.15, 0.1, "WOOF! WOOF!");
		}
		if (level == 4) {
			StdDraw.text(0.15, 0.1, "No Spikes Here!");
		}
		if (level == 5) {
			StdDraw.text(0.15, 0.1, "Good Luck!");
		}
		StdDraw.text(0.15, 0.04, "Deaths: " + model.getDeaths());
		StdDraw.text(0.85, 0.02, "EXIT!");
	}

	/** Draws the platforms. */
	private void drawPlatforms() {
		if (level == 1) {
			StdDraw.setPenColor(StdDraw.WHITE);
		} else if (level == 2) {
			StdDraw.setPenColor(StdDraw.BLACK);
		} else if (level == 3) {
			StdDraw.setPenColor(StdDraw.GREEN);
		} else if (level == 4) {
			StdDraw.setPenColor(StdDraw.CYAN);
		}
		StdDraw.filledRectangle(model.getPlatform1().getX(), model.getPlatform1().getY(),
				model.getPlatform1().getWidth(), model.getPlatform1().getHeight());
		StdDraw.filledRectangle(model.getPlatform2().getX(), model.getPlatform2().getY(),
				model.getPlatform2().getWidth(), model.getPlatform2().getHeight());
		StdDraw.filledRectangle(model.getPlatform3().getX(), model.getPlatform3().getY(),
				model.getPlatform3().getWidth(), model.getPlatform3().getHeight());
		StdDraw.filledRectangle(model.getPlatform4().getX(), model.getPlatform4().getY(),
				model.getPlatform4().getWidth(), model.getPlatform4().getHeight());
		StdDraw.filledRectangle(model.getPlatform5().getX(), model.getPlatform5().getY(),
				model.getPlatform5().getWidth(), model.getPlatform5().getHeight());
		StdDraw.filledRectangle(model.getPlatform6().getX(), model.getPlatform6().getY(),
				model.getPlatform6().getWidth(), model.getPlatform6().getHeight());
		StdDraw.filledRectangle(model.getPlatform7().getX(), model.getPlatform7().getY(),
				model.getPlatform7().getWidth(), model.getPlatform7().getHeight());
		StdDraw.filledRectangle(model.getPlatform8().getX(), model.getPlatform8().getY(),
				model.getPlatform8().getWidth(), model.getPlatform8().getHeight());
		StdDraw.filledRectangle(model.getPlatform9().getX(), model.getPlatform9().getY(),
				model.getPlatform9().getWidth(), model.getPlatform9().getHeight());
		StdDraw.filledRectangle(model.getPlatform10().getX(), model.getPlatform10().getY(),
				model.getPlatform10().getWidth(), model.getPlatform10().getHeight());
		StdDraw.filledRectangle(model.getPlatform11().getX(), model.getPlatform11().getY(),
				model.getPlatform11().getWidth(), model.getPlatform11().getHeight());
	}

	/** Draws the spikes. */
	public void drawSpike() {
		if (level == 1) {
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		}
		if (level == 2) {
			StdDraw.setPenColor(StdDraw.ORANGE);
		}
		if (level == 3) {
			StdDraw.setPenColor(StdDraw.YELLOW);
		}
		double[][][] xy1 = {
				// X values
				{ { .3, .35, .325 }, { .35, .4, .375 }, { .4, .45, .425 }, { .45, .5, .475 }, { .5, .55, .525 },
						{ .55, .6, .575 }, { .6, .65, .625 }, { .65, .7, .675 }, { .9, .95, .925 }, { .95, 1, .975 },
						{ .5, .55, .525 }, { .55, .6, .575 }, { 0, .05, .025 }, { .05, .1, .075 }, { .1, .15, .125 },
						{ .15, .2, .175 }, { .2, .25, .225 }, { 0, .05, .025 }, { .05, .1, .075 }, { .25, .25, .3 },
						{ .3, .3, .25 }, { .3, .3, .25 }, { .3, .3, .25 }, { .55, .6, .575 }, { .6, .65, .625 },
						{ .65, .7, .675 }, { 0.7, .75, .725 }, { .75, .8, .775 } },
				// Y values
				{ { 0, 0, .05 }, { 0, 0, .05 }, { 0, 0, .05 }, { 0, 0, .05 }, { 0, 0, .05 }, { 0, 0, .05 },
						{ 0, 0, .05 }, { 0, 0, .05 }, { .15, .15, .2 }, { .15, .15, .2 }, { .35, .35, .4 },
						{ .35, .35, .4 }, { .5, .5, .45 }, { .5, .5, .45 }, { .5, .5, .45 }, { .5, .5, .45 },
						{ .5, .5, .45 }, { .55, .55, .6 }, { .55, .55, .6 }, { .55, .5, .525 }, { .7, .75, .725 },
						{ .75, .8, .775 }, { .8, .85, .825 }, { .75, .75, .8 }, { .75, .75, .8 }, { .75, .75, .8 },
						{ .15, .15, .2 }, { .15, .15, .2 } } };
		for (int i = 0; i < 28; i++) {
			StdDraw.filledPolygon(xy1[0][i], xy1[1][i]);
		}

	}

	/** Draws the player. */
	public void drawPlayer(Extent c) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(c.getX(), c.getY(), .01);
	}

	/** Draws the button. */
	public void drawButton(Extent b) {
		if (level == 1) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		if (level == 2) {
			StdDraw.setPenColor(StdDraw.YELLOW);
		}
		if (level == 3) {
			StdDraw.setPenColor(StdDraw.MAGENTA);
		}
		if (level == 4) {
			StdDraw.setPenColor(StdDraw.BLUE);
		}
		if (level == 5) {
			StdDraw.setPenColor(StdDraw.CYAN);
		}
		// Draws button pushed down if player has pressed it
		if (model.buttonPress(model.getPlayer())) {
			StdDraw.filledRectangle(b.getX(), (b.getY() - .008), b.getWidth(), (b.getHeight() / 2));
		}
		// Otherwise, draws button un-pressed
		else {
			StdDraw.filledRectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
	}

	/** Draws the gate. */
	public void drawGate(Extent g) {
		if (level == 1) {
			StdDraw.setPenColor(StdDraw.YELLOW);
		}
		if (level == 2) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		if (level == 3) {
			StdDraw.setPenColor(StdDraw.ORANGE);
		}
		if (level == 4) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		if (level == 5) {
			StdDraw.setPenColor(StdDraw.GREEN);
		}
		// If the button has been pressed, draws the gate the color of the background.
		if (model.buttonPress(model.getPlayer()) == true) {
			if (level == 1) {
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			if (level == 2) {
				StdDraw.setPenColor(StdDraw.GRAY);
			}
			if (level == 3) {
				StdDraw.setPenColor(StdDraw.PINK);
			}
			if (level == 4) {
				StdDraw.setPenColor(StdDraw.YELLOW);
			}
			if (level == 5) {
				StdDraw.setPenColor(StdDraw.WHITE);
			}
		}
		StdDraw.filledRectangle(g.getX(), g.getY(), g.getWidth(), g.getHeight());
	}

	/** Handles the player's left and right movement. */
	public void handleKeyPresses() {
		// Gets the player from the model
		Extent player = model.getPlayer();
		if (level == 3) {
			handleWeirdKeyPresses();
		} else if (level == 2) {
			handleOppositeKeyPresses();
		} else {
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
	}

	/** Handles the level two movement. */
	public void handleOppositeKeyPresses() {
		// Gets the player from the model
		Extent player = model.getPlayer();
		// Right key is pressed
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT)) {
			// Moves player left by the value given to move
			player.move(-.005);
			// This value should be negative
		}
		// Left key is pressed
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT)) {
			// Moves player right by the value given to move
			player.move(.005);
			// This value should be positive
		}
	}

	/** Handles the level three movement. */
	public void handleWeirdKeyPresses() {
		// Gets the player from the model
		Extent player = model.getPlayer();
		// D key is pressed
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_D)) {
			// Moves player left by the value given to move
			player.move(-.005);
			// This value should be negative
		}
		// G key is pressed
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_G)) {
			// Moves player right by the value given to move
			player.move(.005);
			// This value should be positive
		}
	}

	/** Causes the player to jump. */
	public void jump() {
		switch (level) {
		// For level 2, the jump key is down.
		case 2:
			if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN)) {
				if (jumpCount == 1) {
					jumpCount = 0;
					moveY = .0105;
				}
			}
			break;
		// For level 3, the jump key is O.
		case 3:
			if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_O)) {
				if (jumpCount == 1) {
					jumpCount = 0;
					moveY = .0105;
				}
			}
			break;
		// For levels 1, 4, and 5, the jump key is up.
		default:
			if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP)) {
				if (jumpCount == 1) {
					jumpCount = 0;
					moveY = .0105;
				}
			}
			break;
		}
		// Gets the current floor of the player from the game model
		double floor = model.getPlayer().currentFloor();
		// If the button hasn't been pressed yet, the player can't get to the exit.
		if (floor == 0.05 && !model.buttonPress(model.getPlayer())) {
			floor = model.getGate().getY() + .01;
		}
		// Gets the player from the game model and sets their Y value equal to their current Y value + moveY
		model.getPlayer().setY(model.getPlayer().getY() + moveY);
		// Prevents the player from sinking below their current floor due to gravity
		if (model.getPlayer().getY() < (floor + .01)) {
			model.getPlayer().setY(floor + .01);
			return;
		}
		// Makes the player bounce off platforms
		bouncesOffOfPlatforms(model.getPlayer());
		// Prevents the player from going through the ceiling
		if (model.getPlayer().getY() > .99) {
			model.getPlayer().setY(.99);
			moveY -= 0.0006;
		}
		// Enacts a gravity for jumping
		moveY -= 0.000253;
	}

	/** Prevents player from going through platforms. */
	public void bouncesOffOfPlatforms(Extent player) {
		double playerRadius = 0.025;

		// Platform 2
		if (model.getPlayer().getY() > (0.525 - 0.025 - playerRadius) && model.getPlayer().getY() < (0.525 - 0.015)
				&& player.overlaps(model.getPlatform2())) {
			model.getPlayer().setY(0.515 - playerRadius);
			moveY -= 0.0006;
		}
		// Platform 3
		if (model.getPlayer().getY() > (0.725 - 0.025 - playerRadius) && model.getPlayer().getY() < (0.725 - 0.015)
				&& player.overlaps(model.getPlatform3())) {
			model.getPlayer().setY(0.715 - playerRadius);
			moveY -= 0.0006;
		}
		// Platform 4
		if (model.getPlayer().getY() > (0.775 - 0.075 - playerRadius) && model.getPlayer().getY() < (0.775 - 0.065)
				&& player.overlaps(model.getPlatform4())) {
			model.getPlayer().setY(0.715 - playerRadius);
			moveY -= 0.0006;
		}
		// Platform 5
		if (model.getPlayer().getY() > (0.725 - 0.025 - playerRadius) && model.getPlayer().getY() < (0.725 - 0.015)
				&& player.overlaps(model.getPlatform5())) {
			model.getPlayer().setY(0.715 - playerRadius);
			moveY -= 0.0006;
		}
		// Platform 6
		if (model.getPlayer().getY() > (0.525 - 0.025 - playerRadius) && model.getPlayer().getY() < (0.525 - 0.015)
				&& player.overlaps(model.getPlatform6())) {
			model.getPlayer().setY(0.515 - playerRadius);
			moveY -= 0.0006;
		}
		// Platform 7
		if (model.getPlayer().getY() > (0.3 - 0.05 - playerRadius) && model.getPlayer().getY() < (0.3 - 0.04)
				&& player.overlaps(model.getPlatform7())) {
			model.getPlayer().setY(0.265 - playerRadius);
			moveY -= 0.0006;
		}
		// Platform 8
		if (model.getPlayer().getY() > (0.575 - 0.025 - playerRadius) && model.getPlayer().getY() < (0.575 - 0.015)
				&& player.overlaps(model.getPlatform8())) {
			model.getPlayer().setY(0.565 - playerRadius);
			moveY -= 0.0006;
		}
		// Platform 8
		if (model.getPlayer().getY() > (0.575 - 0.025 - playerRadius) && model.getPlayer().getY() < (0.575 - 0.015)
				&& player.overlaps(model.getPlatform8())) {
			model.getPlayer().setY(0.565 - playerRadius);
			moveY -= 0.0006;
		}

		// ********* LEFT of platforms **********

		// Platform 6
		if (model.getPlayer().getX() > (0.625 - 0.075 - playerRadius) && model.getPlayer().getX() < (0.625 - 0.065)
				&& player.overlaps(model.getPlatform6())) {
			model.getPlayer().setX(0.57 - playerRadius);
		}
		// Platform 7
		if (model.getPlayer().getX() > (0.5 - 0.1 - playerRadius) && model.getPlayer().getX() < (0.5 - 0.09)
				&& player.overlaps(model.getPlatform7())) {
			model.getPlayer().setX(0.415 - playerRadius);
		}
		// Platform 8
		if (model.getPlayer().getX() > (0.9 - 0.1 - playerRadius) && model.getPlayer().getX() < (0.9 - 0.09)
				&& player.overlaps(model.getPlatform8())) {
			model.getPlayer().setX(0.815 - playerRadius);
		}
		// Platform 10
		if (model.getPlayer().getX() >= (0.95 - 0.05 - playerRadius) && model.getPlayer().getX() < (0.95 - 0.04)
				&& player.overlaps(model.getPlatform10())) {
			model.getPlayer().setX(0.915 - playerRadius);
		}
		// Platform 11
		if (model.getPlayer().getX() >= (0.75 - 0.05 - playerRadius) && model.getPlayer().getX() < (0.75 - 0.03)
				&& player.overlaps(model.getPlatform11())) {
			model.getPlayer().setX(0.71 - playerRadius);
		}

		// ********* RIGHT of platforms **********

		// Platform 1
		if (model.getPlayer().getX() < (0.15 + 0.15 + playerRadius) && model.getPlayer().getX() > (0.15 + 0.15)
				&& player.overlaps(model.getPlatform1())) {
			model.getPlayer().setX(0.3 + playerRadius);
		}
		// Platform 3
		if (model.getPlayer().getX() < (0.05 + 0.05 + playerRadius) && model.getPlayer().getX() > (0.05 + 0.05)
				&& player.overlaps(model.getPlatform3())) {
			model.getPlayer().setX(0.1 + playerRadius);
		}
		// Platform 4
		if (model.getPlayer().getX() < (0.425 + 0.125 + playerRadius) && model.getPlayer().getX() > (0.425 + 0.125)
				&& player.overlaps(model.getPlatform4())) {
			model.getPlayer().setX(0.55 + playerRadius);
		}
		// Platform 5
		if (model.getPlayer().getX() < (0.625 + 0.075 + playerRadius) && model.getPlayer().getX() > (0.625 + 0.075)
				&& player.overlaps(model.getPlatform5())) {
			model.getPlayer().setX(0.7 + playerRadius);
		}
		// Platform 6
		if (model.getPlayer().getX() < (0.625 + 0.075 + playerRadius) && model.getPlayer().getX() > (0.625 + 0.075)
				&& player.overlaps(model.getPlatform6())) {
			model.getPlayer().setX(0.7 + playerRadius);
		}
		// Platform 7
		if (model.getPlayer().getX() < (0.5 + 0.1 + playerRadius) && model.getPlayer().getX() > (0.5 + 0.09)
				&& player.overlaps(model.getPlatform7())) {
			model.getPlayer().setX(0.585 + playerRadius);
		}

		// Platform 11
		if (model.getPlayer().getX() < (0.75 + 0.039 + playerRadius) && model.getPlayer().getX() >= (0.75 + 0.04)
				&& player.overlaps(model.getPlatform11())) {
			model.getPlayer().setX(0.75 + 0.04 + playerRadius);
		}

	}
}