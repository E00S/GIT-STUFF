import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameModelTest {

		public static final double DELTA = 0.001;
		
		
		private Extent player;
		GameModel gameModel = new GameModel();
		
		
		@Before
		public void setUp() throws Exception {
			player = new Extent(0.15, .025, .025);
		
		}
		
		/** Tests if level is completed when player overlaps exit. */
		@Test
		public void detectsExitReached() {
			assertEquals(false, gameModel.exitReached(player));
			// No button press, so player cannot reach exit
			assertEquals(false, gameModel.exitReached(new Extent(.85,.075, 0.025)));
			
		}
		
		/** Tests if button press sets gate to null */
		@Test
		public void detectsButtonPressed() {
			assertTrue(gameModel.buttonPress(new Extent(0.425, 0.864, 0.025)));
		}
		
		/** Detects player death */
		@Test
		public void detectsPlayerDeath() {
			player.move(.129);
			assertEquals(0.279, player.getX(), DELTA);
			gameModel.spikeHit(player);
			assertEquals(1, gameModel.getDeaths());
			
		}
		
		
}