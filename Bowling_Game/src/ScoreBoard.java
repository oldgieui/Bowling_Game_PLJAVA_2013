import java.util.ArrayList;


public class ScoreBoard {
	private ArrayList <Frame> frameList = new ArrayList<Frame>();
	private ArrayList <String>	frameView = new ArrayList<String>();
	private ArrayList <Integer> scoreBoard = new ArrayList<Integer>();
	
	//List 말고 Map을 쓰면 앞에서부터 안 채워도 상관없을 것 같다
	
	public void addFrameList(Frame frame){
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

	//10번째를 위해 9번 주소에 직접 값을 넣는 코드를 많이 썼는데 만약 볼링이 15프레임까지 진행되는 룰로 바뀐다거나 하면 다시 다 만들어야 하는건가.... 알아서 적용되게 미리 짜두고 싶은데 어떻게 해야 되는지 모르겠다...
	
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

	public void setScoreBoard(){
		for (int i = 0; i < frameList.size(); i++){
			Frame currentFrame = frameList.get(i);
			if (i==9) {
				scoreBoard.add(i, currentFrame.getWholeScore());
				continue;
			}
			if (i==8) {
				setNinthScoreBoard(currentFrame,i);
				continue;
			}
			if (currentFrame.isStrike()) {
				if (frameList.get(i+1) != null && frameList.get(i+1).isStrike() == false) {
					scoreBoard.add(i, 10+frameList.get(i+1).getWholeScore());
					continue;
				}
				if (frameList.get(i+1) != null && frameList.get(i+1).isStrike() && frameList.get(i+2) != null) {
					scoreBoard.add(i, 20+frameList.get(i+2).getScoreOf(0));
					continue;
				}
			}
			if (currentFrame.isSpare()) {
				if (frameList.get(i+1) != null) {
					scoreBoard.add(i, 10+frameList.get(i+1).getScoreOf(0));
					continue;
				}
			}
			scoreBoard.add(i, currentFrame.getWholeScore());
		}
	}
	
	private void setNinthScoreBoard(Frame currentFrame, int i) {
		if (currentFrame.isStrike()) {
			if (frameList.get(i+1) != null) {
				scoreBoard.add(i, 10 + frameList.get(i+1).getScoreOf(0) + frameList.get(i+1).getScoreOf(1));
				return;
			}
			return;
		}
		if (currentFrame.isSpare()) {
			if (frameList.get(i+1) != null) {
				scoreBoard.add(i, 10 + frameList.get(i+1).getScoreOf(0));
				return;
			}
			return;
		}
		scoreBoard.add(i, currentFrame.getWholeScore());
	}

	public ArrayList<Integer> getScoreBoard(){
		return scoreBoard;
	}
	
	public int getScoreBoard(int i){
		return scoreBoard.get(i);
	}
	
	private int[] setTotalScore(){
		int[] totalScore = new int[scoreBoard.size()];
		for (int i = 0; i<scoreBoard.size(); i++){
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum+= scoreBoard.get(j);
			}
			totalScore[i] = sum;
		}
		return totalScore;
	}
	
	public void printTotalScore(){
		setframeView();
		setScoreBoard();
		int[] totalScore = setTotalScore();
		for (int i = 0; i < frameList.size(); i++) {
			System.out.print("("+getFrameView(i)+") ");
			System.out.println(totalScore[i]);
		}
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
