import java.util.ArrayList;


public class ScoreBoard {
	ArrayList<String> frameBoard = new ArrayList<String>();
	ArrayList<Integer> gameBoard = new ArrayList<Integer>();
	
	public void setFrameBoard(Frame frame){
		if (frame.getFrameNum() == 9) {
			setTenthFrame(frame);
			return;
		}
		if (frame.isStrike()) {
			frameBoard.add(frame.getFrameNum(), "X");
			return;
		}
		if (frame.isSpare()) {
			frameBoard.add(frame.getFrameNum(), frame.getScoreOf(0) + ", /");
			return;
		}
		frameBoard.add(frame.getFrameNum(), frame.getScoreOf(0) + ", " + frame.getScoreOf(1));
	}

	private void setTenthFrame(Frame frame) {
		if ((frame.isSpare() || frame.isStrike()) == false) {
			frameBoard.add(9, frame.getScoreOf(0) + ", " + frame.getScoreOf(1));
		}
		if (frame.isStrike()) {
			StringBuilder sb = new StringBuilder();
			sb.append("X, ");
			int rollSize = frame.getFrameResult().size();
			if (rollSize < 2) {
				frameBoard.add(9, sb.toString());
				return;
			}
			if (frame.getFrameResult().size() >=2 && frame.getScoreOf(1)==10) {
				sb.append("X, ");
				if (frame.getFrameResult().size() >=2 && frame.getScoreOf(2)==10) {
					sb.append("X");
				}
				else
					sb.append(frame.getScoreOf(2));
			}
			else
				sb.append(frame.getScoreOf(1)+", "+frame.getScoreOf(2));
			frameBoard.add(9, sb.toString());
		}
		if (frame.isSpare()) {
			if (frame.getFrameResult().size() >2){
				frameBoard.add(9, frame.getScoreOf(0)+", /" + frame.getScoreOf(2));
			}
		}
	}
}
