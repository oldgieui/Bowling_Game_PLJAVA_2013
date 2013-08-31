import junit.framework.TestCase;


public class BowlTest extends TestCase {
	public void testStrike() throws Exception {
		Bowl bowl = new Bowl();
		bowl.roll(10);
		bowl.setFrameRecord();
		assertTrue(bowl.isStrike());
	}
	
	public void testSpare() throws Exception {
		Bowl bowl = new Bowl();
		bowl.roll(7);
		bowl.setFrameRecord();
		bowl.roll(3);
		assertTrue(bowl.isSpare());
	}
}
