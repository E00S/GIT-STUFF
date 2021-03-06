
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

	public class ExtentTest {

	public static final double DELTA = 0.001;
	
	private Extent rectangle;
	private Extent player;
	private Extent player2;
	
	GameModel gameModel = new GameModel();
	
	
	@Before
	public void setUp() throws Exception {
		//no overlap Y - false
		player = new Extent(3, 5, 1);
		player2 = new Extent(0.3, 0.5, 0.01);
		rectangle = new Extent(3, 2, 1, 2);
		
	}
	
	/** can detect overlap between character and rectangle */
	@Test
	public void detectsOverlap() {
		assertTrue(new Extent(3, 3, 1).overlaps(rectangle)); //Y
		assertTrue(new Extent(5.9, 2.9, 1).overlaps(rectangle)); //X

	}
	
	/** detects lack of overlap */
	@Test
	public void detectsLackOfOverlap() {
		assertFalse(new Extent(3, 5, 1).overlaps(rectangle)); //Y
		assertFalse(new Extent(6.1, 2.9, 1).overlaps(rectangle)); //X
		assertFalse(new Extent(6, 7, 1).overlaps(rectangle)); //corner
	}
	
	/** detects diagonal overlap */
	@Test
	public void detectsDiagonalOverlap() {
		assertTrue(new Extent(5.9, 3.9, 1).overlaps(rectangle));
	}
	
	/** can store X */
	@Test
	public void storesX() {
		assertEquals(3, player.getX(), DELTA);
	}
	
	/** can store Y */
	@Test
	public void storesY() {
		assertEquals(5, player.getY(), DELTA);
	}
	
	/** can move and store new values */
	@Test
	public void moves() {
		player2.move(0.2);
		assertEquals(0.5, player2.getX(), DELTA);
		assertEquals(0.5, player2.getY(), DELTA);	
	}
}




