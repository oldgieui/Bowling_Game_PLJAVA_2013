import junit.framework.TestCase;


public class ScoreBoardTest extends TestCase {
	public void testSetFrameBoard() throws Exception {
		Frame frame = new Frame();
		ScoreBoard sbd = new ScoreBoard();
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(8);
		frame.addPinNumber(0);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		frame.addPinNumber(10);
		frame.addPinNumber(10);
		frame.addPinNumber(10);
		sbd.setFrameBoard(frame);
		frame.nextFrame();
		
		for (int i = 0; i<sbd.frameBoard.size(); i++){
			System.out.println(sbd.frameBoard.get(i));
		}
	}
}
