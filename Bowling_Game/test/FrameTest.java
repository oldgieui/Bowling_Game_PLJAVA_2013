import junit.framework.TestCase;


public class FrameTest extends TestCase {
	public void testAddPinNumber() throws Exception {
		Frame frame = new Frame();
		int randomNum = (int) Math.round(Math.random() * (10-0+1));
		frame.addPinNumber(randomNum);
		assertTrue(frame.getFrameResult().contains(randomNum));
		
		frame.addPinNumber(randomNum);
		frame.addPinNumber(randomNum);
		frame.addPinNumber(randomNum);
		frame.addPinNumber(1);
		frame.addPinNumber(2);
		
		assertEquals(2, frame.getFrameResult().size());
	}
	
	public void testPrintInfo() throws Exception {
		Frame frame = new Frame(7);
		frame.addPinNumber(7);
		frame.printInfo();
	}
	
	public void testIsStrike() throws Exception {
		Frame frame = new Frame();
		frame.addPinNumber(10);
		assertTrue(frame.isStrike());
//		assertTrue(frame.isSpare());
//		ArrayList의 길이가 2가 아니면 첫번째와 두번째 값의 합이 10이어도 스페어로는 처리되지 않음
	}
	
	public void testIsSpare() throws Exception {
		Frame frame = new Frame();
		int randomNum = (int) Math.round(Math.random() * (10));
		frame.addPinNumber(randomNum);
		frame.addPinNumber(10 - randomNum);
		assertTrue(frame.isSpare());
	}
	
	public void testNextFrame() throws Exception {
		
		Frame frame = new Frame(8);
		frame = frame.next();
		frame.addPinNumber(10);
		frame = frame.next();
		
	}
	
	public void testGetFrame() throws Exception {
		Frame frame = new Frame();
		int randomNum = (int) Math.round(Math.random() * (10));
		for (int i = 1; i <=randomNum ; i++){
			frame = frame.next();
		}
		assertEquals(randomNum, frame.getFrameNum());
	}
	
	public void testGetPitch() throws Exception {
		Frame frame = new Frame();
		assertEquals(0, frame.getPitchNum());
		frame.addPinNumber(3);
		assertEquals(1, frame.getPitchNum());
		frame.addPinNumber(4);
		assertEquals(2, frame.getPitchNum());
//		frame.addPinNumber(2);
//		assertEquals(3, frame.getPitchNum());

		frame = new Frame(9);
		assertEquals(0, frame.getPitchNum());
		frame.addPinNumber(3);
		assertEquals(1, frame.getPitchNum());
		frame.addPinNumber(7);
		assertEquals(2, frame.getPitchNum());
		frame.addPinNumber(2);
		assertEquals(3, frame.getPitchNum());
		//10프레임의 경우 스트라이크나 스페어가 아니면 세 번째 값을 입력할 수 없음
	}
}
