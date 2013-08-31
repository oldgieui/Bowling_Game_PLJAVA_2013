public class Conditions {
	private int frameNum = 0;
	private int pitchNum = 0;

	public void nextFrame() {
		if (frameNum < 9) {
			frameNum++;
			pitchNum = 0;
		}
		// try catch 넣을것
	}

	public void nextPitch() {
		if ((frameNum < 9 && pitchNum < 1) || (frameNum == 9 && pitchNum < 2)) {
			pitchNum++;
		}
		// 여기도
	}

	public int getFrame() {
		return frameNum;
	}

	public int getPitch() {
		return pitchNum;
	}

	public void print() {
		System.out.println("현재 " + (getFrame() + 1) + "번째 프레임, "
				+ (getPitch() + 1) + "번째 굴릴 차례");
	}
}
