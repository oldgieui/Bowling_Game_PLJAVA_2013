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
	
	public void testResetFrame() throws Exception {
		Frame frame = new Frame();
		frame.addPinNumber(1);
		frame.resetFrame();
		assertTrue(frame.getFrameResult().isEmpty());
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
		Frame frame = new Frame();
		frame.addPinNumber(10);
		assertEquals(1, frame.getFrameResult().size());
		for (int i = 0; i < 9; i++) {
			assertEquals(i, frame.getFrameNum());
			frame.nextFrame();
		}
		assertEquals(0, frame.getFrameResult().size());
	}
	
	public void testGetFrame() throws Exception {
		Frame frame = new Frame();
		int randomNum = (int) Math.round(Math.random() * (10));
		for (int i = 1; i <=randomNum ; i++){
			frame.nextFrame();
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
//		assertEquals(3, frame.getPitch());
	}
}
