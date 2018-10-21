/** The logical model of This is the Only Level. */
public class GameModel {

	// The Player
	private Extent player;
	
	// Stores number of player deaths
	private int deaths = 0;
	
	// Button starts out not pressed
	private boolean button = false;
	
	// Gate Extent
	private Extent gate = new Extent(.85,.1,.05,.015);
	
	// Button Extent
	private final Extent BUTTON = new Extent(.425, .864, .035, .013);
	
	// Exit Extent
	private final Extent EXIT = new Extent(.85,.075,.05,.015);
	
	// The Platforms.
	private Extent platform1;
	private Extent platform2;
	private Extent platform3;
	private Extent platform4;
	private Extent platform5;
	private Extent platform6;
	private Extent platform7;
	private Extent platform8;
	private Extent platform9;
	private Extent platform10;
	private Extent platform11;
	
	// The Spikes.
	private Extent spike1;
	private Extent spike2;
	private Extent spike3;
	private Extent spike4;
	private Extent spike5;
	private Extent spike6;
	private Extent spike7;
	private Extent spike8;
	private Extent spike9;
	
	/** Sets the starting values for the game, including the player's starting location and the extents of all platforms and spikes. */
	public GameModel() {
	
		player = new Extent(0.15, 0.2, .01);
		//					   x    y  width height
		platform1 = new Extent(.15,.075,.15,.075);
		platform2 = new Extent(.125,.525,.125,.025);
		platform3 = new Extent(.05,.725,.05,.025);
		platform4 = new Extent(.425,.775,.125,.075);
		platform5 = new Extent(.625,.725,.075,.025);
		platform6 = new Extent(.625,.525,.075,.025);
		platform7 = new Extent(.5,.3,.1,.05);
		platform8 = new Extent(.9,.575,.1,.025);
		platform9 = new Extent(.85,.025,.05,.025);
		platform10 = new Extent(.95,.075,.05,.075);
		platform11 = new Extent(.75,.075,.05,.075);
		spike1 = new Extent(.05,.575,.05, .025);
		spike2 = new Extent(.125,.475,.125, .025);
		spike3 = new Extent(.5,.025,.2, .025);
		spike4 = new Extent(.95,.175,.05, .025);
		spike5 = new Extent(.75,.175,.05, .025);
		spike6 = new Extent(.55,.375,.05, .025);
		spike7 = new Extent(.275,.525,.025, .025);
		spike8 = new Extent(.275,.775,.025, .075);
		spike9 = new Extent(.625,.775,.075, .025);
	}
	
	/** Returns the button. */
	public Extent getButton() {
		return BUTTON;
	}
	
	/** Returns the gate. */
	public Extent getGate() {
		return gate;
	}
	
	/** Returns the player. */
	public Extent getPlayer() {
		return player;
	}
	/** Returns the platform. */
	public Extent getPlatform1() {
		return platform1;
	}
	/** Returns the platform. */
	public Extent getPlatform2() {
		return platform2;
	}
	/** Returns the platform. */
	public Extent getPlatform3() {
		return platform3;
	}
	/** Returns the platform. */
	public Extent getPlatform4() {
		return platform4;
	}
	/** Returns the platform. */
	public Extent getPlatform5() {
		return platform5;
	}
	/** Returns the platform. */
	public Extent getPlatform6() {
		return platform6;
	}
	/** Returns the platform. */
	public Extent getPlatform7() {
		return platform7;
	}
	/** Returns the platform. */
	public Extent getPlatform8() {
		return platform8;
	}
	/** Returns the platform. */
	public Extent getPlatform9() {
		return platform9;
	}
	/** Returns the platform. */
	public Extent getPlatform10() {
		return platform10;
	}
	/** Returns the platform. */
	public Extent getPlatform11() {
		return platform11;
	}
	
	/** Returns true if player overlaps button */
	public boolean buttonPress(Extent player) {
		if (player.overlaps(BUTTON)) {
			button = true;
		}
		return button;
	}
	
	/** Returns true if player overlaps exit */
	public boolean exitReached(Extent player) {
		if (button && player.overlaps(EXIT)) {
			return true;
		}
		return false;
	}
	
	/** If player overlaps spike, resets player at beginning */
	public void spikeHit(Extent player) {
		boolean hit = false;
		if (player.overlaps(spike1)) {
			hit = true;
		} else if (player.overlaps(spike2)) {
			hit = true;
		} else if (player.overlaps(spike3)) {
			hit = true;
		} else if (player.overlaps(spike4)) {
			hit = true;
		} else if (player.overlaps(spike5)) {
			hit = true;
		} else if (player.overlaps(spike6)) {
			hit = true;
		} else if (player.overlaps(spike7)) {
			hit = true;
		} else if (player.overlaps(spike8)) {
			hit = true;
		} else if (player.overlaps(spike9)) {
			hit = true;
		} 
		
			
		if (hit == true) {	
			reset();
			
			//add deaths
			deaths ++;
		}
	}
	
	/** Resets everything (except the death counter) to the starting state of the game. */
	public void reset() {
		//reset player at beginning
		player.setX(.15);
		player.setY(.2);
		
		//reset button
		button = false;
		
		//reset gate
		gate.setX(.85);
		gate.setY(.1);
		gate.setHeight(.015);
		gate.setWidth(.05);
	}
	
	/** Returns number of deaths. */
	public int getDeaths() {
		return deaths;
	}
	
}