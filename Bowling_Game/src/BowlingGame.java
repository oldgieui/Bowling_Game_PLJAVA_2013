
public class BowlingGame {
	Frame frame = new Frame();
	ScoreBoard board = new ScoreBoard();
	
	public BowlingGame() {
	}
	
	public void roll(int x){
		frame.addPinNumber(x);
		if (frame.isStrike()) {
			setAndNext();
			return;
		}
		if (frame.getFrameNum() <9 && frame.getFrameResult().size() == 2) {
			setAndNext();
			return;
		}
		if (frame.getFrameNum() == 9 && ((frame.isSpare() || frame.isStrike()) == false) && frame.getFrameResult().size() == 2) {
			setAndNext();
			return;
		}
		if (frame.getFrameNum() == 9 && frame.getFrameResult().size() ==3) {
			setAndNext();
			return;
		}
	}
	
	public void setAndNext(){
		board.setFrameBoard(frame);
		frame.nextFrame();
	}
}
