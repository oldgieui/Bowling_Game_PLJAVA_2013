import junit.framework.TestCase;

public class ConditionsTest extends TestCase {
	public void testNextFrame() throws Exception {
		Conditions cd = new Conditions();
		for (int i = 1; i <= 9; i++) {
			assertEquals(i, cd.getFrame());
			cd.nextFrame();
		}
	}

	public void testNextPitch() throws Exception {
		Conditions cd = new Conditions();
		assertEquals(1, cd.getPitch());
		cd.nextPitch();
		assertEquals(2, cd.getPitch());
		// 이하 두 줄은 투구 수가 2 위로 올라가지 않음을 보여주기 위한 테스트 코드. 실행하면 에러가 뜬다.
		// cd.nextPitch();
		// assertEquals(3, cd.getPitch());
		for (int i = 1; i <= 9; i++) {
			cd.nextFrame();
		}
		assertEquals(1, cd.getPitch());
		cd.nextPitch();
		assertEquals(2, cd.getPitch());
		cd.nextPitch();
		assertEquals(3, cd.getPitch());
		// 이하 두 줄은 10프레임에서 투구 수가 3 위로 올라가지 않음을 보여주는 테스트 코드. 
		// cd.nextPitch();
		// assertEquals(4, cd.getPitch());
	}
	
	
	public void testPrint() throws Exception {
		Conditions cd = new Conditions();
		for (int i = 1; i <= 10; i++) {
			cd.print();
			cd.nextPitch();
			cd.print();
			if (i == 10) {
				cd.nextPitch();
				cd.print();
			}
			cd.nextFrame();
		}
	}
}
