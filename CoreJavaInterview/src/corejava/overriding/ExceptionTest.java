package corejava.overriding;

public class ExceptionTest {
	private String na;

	public static void main(String[] args) {
		ExceptionTest et = new ExceptionTest();
		et.m1();
	}

	private void m1() {
		try {
			m2();
			System.out.println(" code execute in m1 ");
		} catch (NullPointerException e) {
			System.out.println(" Runtime Exception in m1");
		}

	}

	private void m2() {
		try {
			m3();
		} catch (RuntimeException ee) {
			System.out.println(" excepitn in m2");
		}

	}

	public String m3() {
		return na.toString();

	}
}
