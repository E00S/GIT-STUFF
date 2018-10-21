import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameModelTest {

		public static final double DELTA = 0.001;
		
		
		private Extent player;
		private Extent player1;
		private Extent player2;
		private Extent SPIKE3;
		GameModel gameModel = new GameModel();
		
		
		@Before
		public void setUp() throws Exception {
			player = new Extent(0.15, .025, .025);
		
		}
		
		/** tests if level completed when overlap with exit*/
		@Test
		public void detectsExitReached() {
			//TODO need to integrate exitReached in gameModel
			//new Extent(.85, .1, .01)
			assertEquals(false, gameModel.exitReached());
			
		}
		
		/** tests if button press sets gate to null */
		@Test
		public void detectsButtonPressedGateGone() {
			// TODO want to test if button is true after overlap with player, however I am not sure how to pass button between tests and GameModel
			assertTrue(gameModel.buttonPress(new Extent(0.425, 0.0864, 0.01)));
			// TODO should have case to test if gate has been set to null
		}
		
		/** Detects player death */
		@Test
		public void detectsPlayerDeath() {
			//TODO player is moving, but spikeHit method is using player defined in gameModel, so player in this test is not being seen
			player.move(.129);
			assertEquals(0.279, player.getX(), DELTA);
			gameModel.spikeHit();
			assertEquals(1, gameModel.getDeaths());
			
		}
		
		
		
}
