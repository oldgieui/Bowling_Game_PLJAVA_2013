import java.util.ArrayList;


public class ScoreBoard {
	private ArrayList <Frame> frameList = new ArrayList<Frame>();
	private ArrayList <String>	frameView = new ArrayList<String>();
	private ArrayList <Integer> scoreBoard = new ArrayList<Integer>();
	
	public void setFrameList(Frame frame){
		frameList.add(frame);
	}
	
	public void setframeView(){
		for (int i = 0; i < frameList.size(); i++) {
			Frame currentFrame = frameList.get(i);
			if (i == 9) {
				setTenthFrameView(currentFrame);
				continue;
			}
			if (currentFrame.isStrike()) {
				frameView.add(i, "X");
				continue;
			}
			if (currentFrame.isSpare()) {
				frameView.add(i, currentFrame.getScoreOf(0) + ", /");
				continue;
			}
			frameView.add(i, currentFrame.getScoreOf(0) + ", " + currentFrame.getScoreOf(1));
		}
	}

	private void setTenthFrameView(Frame currentFrame) {
		StringBuilder sb = new StringBuilder();
		if (currentFrame.isStrike()) {
			sb.append("X, ");
			if (currentFrame.getScoreOf(1) == 10) {
				sb.append("X, ");
				if (currentFrame.getScoreOf(2) == 10) {
					sb.append("X");
					frameView.add(9, sb.toString());
					return;
				}
				sb.append(currentFrame.getScoreOf(2));
				frameView.add(9, sb.toString());
				return;
			}
			if (currentFrame.getScoreOf(1) + currentFrame.getScoreOf(2) == 10) {
				sb.append(currentFrame.getScoreOf(1)+", /");
				frameView.add(9, sb.toString());
				return;
			}
			sb.append(currentFrame.getScoreOf(1) + ", " + currentFrame.getScoreOf(2));
			frameView.add(9, sb.toString());
			return;
		}
		if (currentFrame.isSpare()) {
			sb.append(currentFrame.getScoreOf(0)+", /, ");
			if (currentFrame.getScoreOf(2)==10) {
				sb.append("X");
				frameView.add(9, sb.toString());
				return;
			}
			sb.append(currentFrame.getScoreOf(2));
			frameView.add(9, sb.toString());
			return;
		}
		sb.append(currentFrame.getScoreOf(0) + ", " + currentFrame.getScoreOf(1));
		frameView.add(9, sb.toString());
	}

	public String getFrameView(int i){
		return frameView.get(i);
	}
	
	public ArrayList<Frame> getFrameList(){
		return frameList;
	}

	public Frame getFrameList(int i){
		return frameList.get(i);
	}
	
	
	
}
