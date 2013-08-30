
public class Roll {
	int pins;
	
	public Roll(int x){
		pins = x;
	}
	
	public boolean isStrike(){
		if(pins == 10)
			return true;
		return false;
	}
	
	
	
}
