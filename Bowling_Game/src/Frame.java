import java.util.ArrayList;

public class Frame {
	private ArrayList<Integer> frameResult = new ArrayList<Integer>();
	private int frameNum = 0;

	// private int pitchNum = 0;
	// 현재 투구 차례를 확인하기 위해 따로 변수를 만들 필요 없이 점수가 기록된 ArrayList의 길이만 확인하면 되는 것이어따
	public Frame() {
	}
	
	public Frame(int x){
		frameNum = x;
	}
	
	public Frame nextFrame(){
		try{
			if (frameNum == 9) {
				throw new gameOverException();
			}
			return new Frame(frameNum+1);
		}catch(gameOverException e){
			System.out.println("game over");
			return null;
		}
	}

	public void addPinNumber(int x){
		try{
			if (x>10 || x<0) {
				throw new pinNumberException();
			}
			if (frameResult.size() == 0) {
				frameResult.add(x);
				return;
			}
			if (frameResult.size() == 1) {
				if(isStrike() == false && x > (10 - frameResult.get(0))){
					throw new pinNumberException();
				}
				frameResult.add(x);
				return;
			}

			if (frameResult.size() == 2 && frameNum == 9 && (isSpare() || isStrike())) {
				frameResult.add(x);
				return;
			}
		}catch(pinNumberException e){
			System.out.println("잘못된 핀 개수를 입력했음");
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

	public void printInfo() {
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
