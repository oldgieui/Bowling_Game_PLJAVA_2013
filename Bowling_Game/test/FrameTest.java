import junit.framework.TestCase;


public class FrameTest extends TestCase {
	public void testAddPinNumber() throws Exception {
		Frame frame = new Frame();
		int randomNum = (int) Math.round(Math.random() * (10-0+1));
		frame.addPinNumber(randomNum);
		assertTrue(frame.frameResult.contains(randomNum));
	}
	
	public void testResetFrame() throws Exception {
		Frame frame = new Frame();
		frame.addPinNumber(1);
		frame.resetFrame();
		assertTrue(frame.frameResult.isEmpty());
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
		System.out.println(randomNum);
	}
	
	public void testNextFrame() throws Exception {
		Frame frame = new Frame();
		for (int i = 1; i <= 9; i++) {
			assertEquals(i, frame.getFrame());
			frame.nextFrame();
		}
	}
	
	public void testGetFrame() throws Exception {
		Frame frame = new Frame();
		int randomNum = (int) Math.round(Math.random() * (10));
		for (int i = 1; i <=randomNum ; i++){
			frame.nextFrame();
		}
		assertEquals(randomNum, frame.getFrame());
	}
	
	public void testGetPitch() throws Exception {
		Frame frame = new Frame();
		assertEquals(0, frame.getPitch());
		frame.addPinNumber(3);
		assertEquals(1, frame.getPitch());
		frame.addPinNumber(4);
		assertEquals(2, frame.getPitch());
//		frame.addPinNumber(2);
//		assertEquals(3, frame.getPitch());
	}
}
