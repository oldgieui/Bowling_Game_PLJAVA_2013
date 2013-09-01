
public class BowlingGame {
	private Frame frame = new Frame();
	private ScoreBoard board = new ScoreBoard();
	
	public BowlingGame() {
	}
	
	public void roll(int x){
		frame.addPinNumber(x);
		if (frame.isEnd()) {
			board.addFrameList(frame);
			if (frame.getFrameNum() <9) {
				frame = frame.next();
			}
		}
	}
	
	public Frame getFrame(){
		return frame;
	}
	
	public ScoreBoard getScoreBoard(){
		return board;
	}
	
	public void printInfo(){
		frame.printInfo();
	}
	
	public void printScore(){
		board.printTotalScore();
	}
}
