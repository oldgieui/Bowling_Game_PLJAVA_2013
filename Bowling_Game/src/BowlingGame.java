import java.util.Stack;

public class BowlingGame {
	int[][] pointPerPitch = new int[10][];
	
	int[] pointPerFrame = new int[10];
	int frameNum = 0;
	int pointUntil = 0;
	int pitchNum = 0;
	Stack<Integer> point = new Stack<Integer>();
	
	public BowlingGame() {
		for (int i = 0; i<9 ; i++){
			pointPerPitch[i] = new int [2];
		}
		pointPerPitch[9] = new int [3];
	}
	
	void printSequence() {
		System.out.println("현재 프레임 : " + (frameNum+1) +"회");
		System.out.println("현재 투구 차례 : " + (pitchNum+1) +"번째");
	}
	
	void next(int i){
		if (i==10 && frameNum == 9 && pitchNum <=2) {
			nextPitch();
			return;
		}
		if (i == 10) {
			nextFrame();
			return;
		} 
		nextPitch();
		if (frameNum == 9 && pitchNum ==2) {
			return;
		}
		if (frameNum == 9 && pitchNum >2){
			System.out.println("game over");
			return;
		}
		if (pitchNum>1) {
			nextFrame();
			return;
		}
	}
	
	void nextFrame(){
		frameNum++;
		pitchNum = 0;
	}
	//투구 차례의 경우 다음 프레임으로 넘어가면 어차피 초기화되고, 각 프레임별로 투구 결과에 따라 다음 투구를 하는지 아닌지가 정해지기 때문에 복잡다단한 조건문을 만들 필요가 없다. (아마도)
	void nextPitch(){
		this.pitchNum++;
	}

	void roll(int i){
		point.push(i);
		setPointPerPitch();
		next(i);
	}
	
	void makePointBoard(){
		if (pointPerPitch[frameNum][0] == 10) {
			if (pointPerPitch[frameNum+1][0] == 10) {
				
			}
		}
		for(int i = 0; i<pointPerPitch[frameNum].length;i++){
			pointPerFrame[frameNum] += pointPerPitch[frameNum][i];
		}
	}
	
	void makePointBoard(int i) {
		if (frameNum <= 8) {
			if (frameNum >= 1 && pointPerPitch[frameNum - 1][0] == 10) {
				if (i == 10) {
					nextFrame();
					return;
				}
				if (pitchNum == 1) {
					setPointPerFrame();
					nextFrame();
					return;
				}
				nextPitch();
				return;
			}
			if (frameNum >= 1 && pointPerFrame[frameNum - 1] == 0) {
				if (i == 10) {
					setPointPerFrame();
					nextFrame();
					return;
				}
				setPointPerFrame();
				point.push(i);
				nextPitch();
				return;
			}

			if (i == 10) {
				nextFrame();
				return;
			}

			nextPitch();

			if (pitchNum > 1) {
				if(pointPerPitch[frameNum][0]+pointPerPitch[frameNum][1] == 10){
					nextFrame();
					return;
				}
				setPointPerFrame();
				nextFrame();
				return;
			}
		}
	}
	
	void setPointPerPitch(){
		pointPerPitch[frameNum][pitchNum] = point.peek();
	}
	
	void setPointPerFrame(){
		while (point.isEmpty() != true) {
			pointPerFrame[pointUntil]+= point.pop();
		}
		point.push(pointPerFrame[pointUntil]);
		pointUntil++;
	}
}
