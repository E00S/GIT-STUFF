/** The logical model of This is the Only Level. */
public class GameModel {

	// The Player
	private Extent player;
	
	public static final double PLAYER_SPEED = 0;
	
	private int deaths = 0;
	
	private boolean button = false;
	
	private Extent gate = new Extent(.85,.1,.05,.015);
	
	private final Extent BUTTON = new Extent(.425, .864, .035, .013);
	
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
	private Extent SPIKE1;
	private Extent SPIKE2;
	private Extent SPIKE3;
	private Extent SPIKE4;
	//private Extent SPIKE5;
	private Extent SPIKE6;
	private Extent SPIKE7;
	private Extent SPIKE8;
	//private Extent SPIKE9;
	private Extent SPIKE10;
	
	/** Sets the starting values for the game, including the player's starting location and the extents of all platforms and spikes. */
	public GameModel() {
	
		player = new Extent(0.15, 0.2, .01);
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
		SPIKE1 = new Extent(.05,.575,.025,.05);
		SPIKE2 = new Extent(.125,.475,.025,.125);
		SPIKE3 = new Extent(.5,.025,.025,.2);
		SPIKE4 = new Extent(.95,.175,.025,.05);
		//SPIKE5 = new Extent(.75,.175,.025,.05);
		SPIKE6 = new Extent(.55,.375,.025,.05);
		SPIKE7 = new Extent(.275,.525,.025,.025);
		SPIKE8 = new Extent(.275,.775,.075,.025);
		//SPIKE9 = new Extent(9,.625,.025,.1);
		SPIKE10 = new Extent(.625,.775,.025,.075);
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
	
	/** returns true if player overlaps button and sets gate to null */
	public boolean buttonPress(Extent player) {
		if (player.overlaps(BUTTON)) {
			button = true;
		}
		return button;
	}
	
	/** returns true if player overlaps exit */
	public boolean exitReached() {
		if (button && player.overlaps(EXIT)) {
			return true;
		}
		return false;
	}
	
	/** if player overlaps spike, resets player at beginning */
	public void spikeHit() {
		boolean hit = false;
		if (player.overlaps(SPIKE1)) {
			hit = true;
		} else if (player.overlaps(SPIKE2)) {
			hit = true;
		} else if (player.overlaps(SPIKE3)) {
			hit = true;
		} else if (player.overlaps(SPIKE4)) {
			hit = true;
		//} else if (player.overlaps(SPIKE5)) {
		//	hit = true;
		} else if (player.overlaps(SPIKE6)) {
			hit = true;
		} else if (player.overlaps(SPIKE7)) {
			hit = true;
		} else if (player.overlaps(SPIKE8)) {
			hit = true;
		//} else if (player.overlaps(SPIKE9)) {
		//	hit = true;
		} else if (player.overlaps(SPIKE10)) {
			hit = true;
		} 
		
			
		if (hit == true) {	
			//reset player at beginning
			player.setX(.15);
			player.setY(.2);
			
			//reset button
			button = false;
			
			//reset gate
			gate.setX(.85);
			gate.setY(.1);
			gate.setHeight(.05);
			gate.setWidth(.015);
			//add deaths
			deaths ++;
			StdOut.println("Deaths: " + deaths);
		}
		
	}
	
	/** return deaths */
	public int getDeaths() {
		return deaths;
	}
}