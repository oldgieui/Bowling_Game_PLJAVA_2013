import junit.framework.TestCase;


public class BowlingGameTest extends TestCase {
	public void testRoll() throws Exception {
		BowlingGame bg = new BowlingGame();
		bg.roll(9);
		bg.roll(1);
		bg.roll(8);
		bg.roll(0);
		bg.roll(10);
		bg.roll(10);
		bg.roll(8);
		bg.roll(0);
		bg.roll(10);
		bg.roll(8);
		bg.roll(1);
		bg.roll(9);
		bg.roll(1);
		bg.roll(8);
		bg.roll(1);
		bg.roll(10);
//		bg.roll(9);
//		bg.roll(1);
		
		
		for (int i = 0; i<bg.board.frameBoard.size(); i++){
			System.out.println(bg.board.frameBoard.get(i));
		}
	}
	
	public void testTenFrameFirstRoll() throws Exception {
		Frame frame = new Frame(9);
		frame.addPinNumber(10);
		ScoreBoard scoreBoard = new ScoreBoard();
		scoreBoard.setFrameBoard(frame);
	}
	
	public void testTenFrameSecondRoll() throws Exception {
		Frame frame = new Frame(9);
		frame.addPinNumber(10);
		frame.addPinNumber(8);
		ScoreBoard scoreBoard = new ScoreBoard();
		scoreBoard.setFrameBoard(frame);
	}
}
