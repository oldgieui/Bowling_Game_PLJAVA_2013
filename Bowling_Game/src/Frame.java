import java.util.ArrayList;

public class Frame {
	private ArrayList<Integer> frameResult = new ArrayList<Integer>();
	private int frameNum = 0;

	// private int pitchNum = 0;
	// 현재 투구 차례를 확인하기 위해 따로 변수를 만들 필요 없이 점수가 기록된 ArrayList의 길이만 확인하면 되는 것이어따
	public Frame() {
	}
	
	public void resetFrame() {
		frameResult.removeAll(frameResult);
	}

	public void nextFrame() {
		if (frameNum < 9) {
			frameNum++;
			resetFrame();
		}
		// try catch 넣을것
	}
	

	// 첫번째에서 7개 넣고 두번째에서 5개 넣는 식의 잘못된 입력에 대처할 수 있는 기능 넣을 것
	public void addPinNumber(int x) {
		if (frameResult.size() < 2 && (x <= 10 && x >= 0)) {
			frameResult.add(x);
			return;
		}
		if (frameResult.size() == 2 && frameNum == 9 && (x <= 10 && x >= 0) && (isSpare() || isStrike())) {
			frameResult.add(x);
			return;
		}
	}

	public boolean isStrike() {
		if (frameResult.get(0) == 10) {
			return true;
		}
		return false;
	}

	public boolean isSpare() {
		if (frameResult.size() == 2 && frameResult.get(0) + frameResult.get(1) == 10) {
			return true;
		}
		return false;
	}

	public int getFrameNum() {
		return frameNum;
	}

	public int getPitchNum() {
		return frameResult.size();
	}

	public void print() {
		System.out.println("현재 " + (getFrameNum() + 1) + "번째 프레임, "
				+ (getPitchNum() + 1) + "번째 굴릴 차례");
	}
	
	public ArrayList<Integer> getFrameResult(){
		return frameResult;
	}
	
	public int getWholeScore(){
		int score = 0;
		for (int i = 0; i < frameResult.size(); i++) {
			score+=frameResult.get(i);
		}
		return score;
	}
	
	public int getScoreOf(int x){
		return frameResult.get(x);
	}
}
