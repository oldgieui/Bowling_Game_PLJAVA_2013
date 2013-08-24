import java.util.ArrayList;
import java.util.HashMap;

public class BowlingGame {
	int[][] pointPerPitch = new int[10][];
	int[] pointPerFrame = new int[10];
	int frameNum = 1;
	int pitchNum = 1;

	void printSequence() {
		System.out.println("현재 프레임 : " + frameNum +"회");
		System.out.println("현재 투구 차례 : " + pitchNum +"번째");
	}
	
	void nextFrame(){
		frameNum++;
		pitchNum = 1;
	}
	//투구 차례의 경우 다음 프레임으로 넘어가면 어차피 초기화되고, 각 프레임별로 투구 결과에 따라 다음 투구를 하는지 아닌지가 정해지기 때문에 복잡다단한 조건문을 만들 필요가 없다. (아마도)
	void nextPitch(){
		this.pitchNum++;
	}

}
