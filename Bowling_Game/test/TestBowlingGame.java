import junit.framework.TestCase;


public class TestBowlingGame extends TestCase {
	
	//nextFrame과 nextPitch를 사용한 횟수만큼 반영됨.
	public void testPrintSequence() throws Exception {
		BowlingGame bg = new BowlingGame();
		for(int i = 1; i<=9; i++){
			bg.printSequence();
			bg.nextPitch();
			bg.printSequence();
			bg.nextFrame();
		}
		bg.printSequence();
		bg.nextPitch();
		bg.printSequence();
		bg.nextPitch();
		bg.printSequence();
	}
}
