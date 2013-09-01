import java.util.ArrayList;

public class ScoreBoard2 {
	private int[] scoreBoard = new int[10];
	private ArrayList<Frame> gameResult = new ArrayList<Frame>();
	ArrayList<Integer> gameScore = new ArrayList<Integer>();	
	private ArrayList<String> frameScore = new ArrayList<String>();	

	public void addFrame(Frame frame){
		gameResult.add(frame.getFrameNum(), frame);
	}
	
	public void setFirstScore(){
		if (gameResult.get(0).isStrike()) {
			if (gameResult.get(1) == null) {
				return;
			}
			if (gameResult.get(1).isStrike()){
				if(gameResult.get(2) == null) {
					return;
				}
				gameScore.add(0, 20+ gameResult.get(2).getScoreOf(0));
				return;
			}
			gameScore.add(0, 10 + gameResult.get(1).getWholeScore());
		}
		if (gameResult.get(0).isSpare()) {
			if (gameResult.get(1) == null) {
				return;
			}
			gameScore.add(0, 10 + gameResult.get(1).getScoreOf(0));
		}
	}
	
	public void setGameScore(){
		for (int i = 1; i < gameResult.size(); i++) {
			if(gameResult.get(i).isStrike()){
				if (gameResult.get(i+1).isStrike() && gameResult.get(i+2) != null) {
					gameScore.add(i, 20+ gameResult.get(i+2).getScoreOf(0));
					return;
				}
				
			}
		}
	}
	
	
	
	
	
	public void setFrameBoard(Frame frame){
		if (frame.getFrameNum() < 9) {
			if (frame.isStrike()) {
				frameScore.add(frame.getFrameNum(), "X | ");
				return;
			}
			if (frame.isSpare()) {
				frameScore.add(frame.getFrameNum(), frame.getScoreOf(0)+", / | ");
				return;
			}
			frameScore.add(frame.getFrameNum(), frame.getScoreOf(0)+", " + frame.getScoreOf(1)+" | ");		
		}
		if (frame.getFrameNum() == 9) {
			StringBuilder sb = new StringBuilder();
			if (frame.isStrike()) {
				sb.append("X, ");
				if(frame.getFrameResult().get(1) == 10){
					sb.append("X, ");
				}
			}
		}
	}
	
	public void setScoreBoard() {
		int i;
		for (i = 0; i < gameResult.size(); i++) {
			if (gameResult.get(i).isStrike()) {
				if (gameResult.get(i + 1) != null) {
					if (gameResult.get(i + 1).isStrike()) {
						if (gameResult.get(i + 2) != null) {
							scoreBoard[i] += 20 + gameResult.get(i + 2)
									.getScoreOf(0);
							scoreBoard[i + 1] = scoreBoard[i];
						}
						return;
					}
					scoreBoard[i] += 10 + gameResult.get(i + 1).getWholeScore();
					scoreBoard[i + 1] = scoreBoard[i];
				}
				return;
			}
			// 이상 i번째 프레임이 스트라이크였을때의 처리

			if (gameResult.get(i).isSpare()) {
				if (gameResult.get(i + 1) != null) {
					scoreBoard[i] += 10 + gameResult.get(i + 1).getScoreOf(0);
					scoreBoard[i + 1] = scoreBoard[i];
				}
				return;
			}
			// 이상 i번째 프레임이 스페어였을때의 처리
			// 이상 0번~7번 프레임까지 처리.(실세계에서는 1~8번)
			if (i == 8) {
				if (gameResult.get(i).isStrike()) {
					if (gameResult.get(i + 1) != null) {
						scoreBoard[i] += 10 + gameResult.get(i + 1).getScoreOf(0)
								+ gameResult.get(i + 1).getScoreOf(1);
						scoreBoard[i + 1] = scoreBoard[i];
					}
					return;
				}
				if (gameResult.get(i).isSpare()) {
					if (gameResult.get(i + 1) != null) {
						scoreBoard[i] += 10 + gameResult.get(i + 1).getScoreOf(0);
						scoreBoard[i + 1] = scoreBoard[i];
					}
					return;
				}
				// scoreBoard[i] += gameResult.get(i).getWholeScore();
				// scoreBoard[i + 1] = scoreBoard[i];
			}

			if (i == 9) {
				scoreBoard[i] += gameResult.get(i).getWholeScore();
				return;
			}

			// 8번 프레임(실세계에선 9번)이 스트라이크나 스페어였을 때의 처리. 9번도 처리. 추가할것
			// 점수판 보여줄때 스트라이크면 점수와 X, 스페어면 첫번째 점수와 /를 보여주도록 처리
			// exception 확인

			scoreBoard[i] += gameResult.get(i).getWholeScore();
			scoreBoard[i + 1] = scoreBoard[i];
		}


	}
	
	public void printBoard() {
		for (int i = 0; i < scoreBoard.length; i++) {
//			if (gameResult.get(i).isStrike()) {
//				System.out.print("X, ");
//			} else if (gameResult.get(i).isSpare()) {
//				System.out.print(gameResult.get(i).getScoreOf(0) + ", /, ");
//			} else {
//				for (int pointPerPitch : gameResult.get(i).getFrameResult()) {
//					System.out.print(pointPerPitch + ", ");
//				}
//			}
			System.out.println(scoreBoard[i]);
		}
	}
}
