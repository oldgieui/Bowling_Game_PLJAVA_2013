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
	
	public void testroll() throws Exception {
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
		bg.roll(9);
		bg.roll(1);
		
		bg.printSequence();
		
		for (int[] points : bg.pointPerPitch) {
			for (int i : points) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		
	}
}
