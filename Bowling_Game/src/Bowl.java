import java.util.ArrayList;

public class Bowl {
	private int pins;
	private ArrayList<Object> frameRecord = new ArrayList<Object>();
	private ArrayList<ArrayList<Object>> gameRecord = new ArrayList<ArrayList<Object>>();
	
	//int 이차원 배열을 만들어서 99나 98 등의 숫자를 넣고 나중에 기호로 대체하는 것과 ArrayList 안에 ArrayList를 포함시키는 것 중에 어느 게 더 효율적인가?
	
	
	public void roll(int x){
		if (x>10) return;
		if (!isStrike()) {
			pins = x;
		}
	}
	
	public boolean isStrike(){
		if(pins==10){
			return true;
		}
		return false;
	}
	
	public boolean isSpare(){
		if (frameRecord.size()>=1 && (Integer)frameRecord.get(0) + pins == 10) {
			return true;
		}
		return false;
	}
	
	public void setFrameRecord(){
		if (isStrike()) {
			frameRecord.add('X');
			return;
		}
		if (isSpare()) {
			frameRecord.add('/');
			return;
		}
		frameRecord.add(pins);
	}
	
	
	public void setGameRecord(Conditions condition){
		gameRecord.add(condition.getFrame(), frameRecord); 
	}
	
}
