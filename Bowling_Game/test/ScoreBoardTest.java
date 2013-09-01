import junit.framework.TestCase;


public class ScoreBoardTest extends TestCase {
	public void testSetFrameList() throws Exception {
		Frame frame = new Frame(8);
		ScoreBoard board = new ScoreBoard();
		frame.addPinNumber(10);
		board.addFrameList(frame);

		assertTrue(board.getFrameList().contains(frame));
	}
	
	public void testSetFrameView() throws Exception {
		Frame frame = new Frame();
		ScoreBoard sbd = new ScoreBoard();
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(0);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(0);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		sbd.setframeView();
		
		for (int i = 0; i<sbd.getFrameList().size(); i++){
			System.out.println(sbd.getFrameView(i));
		}
	}
	
	public void testSetScoreBoard() throws Exception {
		Frame frame = new Frame();
		ScoreBoard sbd = new ScoreBoard();
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(0);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(0);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		sbd.setScoreBoard();
		
		for (int i = 0; i<sbd.getFrameList().size(); i++){
			System.out.println(sbd.getScoreBoard(i));
		}
	}
	
	public void testPrintTotalScore() throws Exception {
		Frame frame = new Frame();
		ScoreBoard sbd = new ScoreBoard();
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(0);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(0);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(8);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		frame = frame.next();
		frame.addPinNumber(10);
		frame.addPinNumber(9);
		frame.addPinNumber(1);
		sbd.addFrameList(frame);
		sbd.setframeView();
		sbd.setScoreBoard();
		sbd.printTotalScore();
	}
	
}
