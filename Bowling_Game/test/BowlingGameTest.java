import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	public void testRoll() throws Exception {
		BowlingGame bg = new BowlingGame();
		bg.printInfo();
		bg.roll(9);
		bg.printInfo();
		bg.roll(1);
		bg.printInfo();
		bg.roll(8);
		bg.printInfo();
		bg.roll(0);
		bg.printInfo();
		bg.roll(10);
		bg.printInfo();
		bg.roll(10);
		bg.printInfo();
		bg.roll(8);
		bg.printInfo();
		bg.roll(0);
		bg.printInfo();
		bg.roll(10);
		bg.printInfo();
		bg.roll(8);
		bg.printInfo();
		bg.roll(1);
		bg.printInfo();
		bg.roll(9);
		bg.printInfo();
		bg.roll(1);
		bg.printInfo();
		bg.roll(8);
		bg.printInfo();
		bg.roll(1);
		bg.printInfo();
		bg.roll(10);
		bg.printInfo();
		bg.roll(9);
		bg.printInfo();
		bg.roll(1);

		
		bg.printScore();
	}
	
	public void testRoll2() throws Exception {
		BowlingGame game = new BowlingGame();
		game.roll(9);
		game.roll(1);
		game.roll(6);
		game.roll(4);
		game.roll(7);
		game.roll(3);
		game.roll(9);
		game.roll(0);
		game.roll(7);
		game.roll(3);
		game.roll(6);
		game.roll(2);
		game.roll(8);
		game.roll(1);
		game.roll(7);
		game.roll(2);
		game.roll(10);
		game.roll(7);
		game.roll(3);
		game.roll(7);
		
		game.printScore();
	}
}
