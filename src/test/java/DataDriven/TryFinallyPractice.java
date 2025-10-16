package DataDriven;

public class TryFinallyPractice {

	static int a = 5;

	public static void main(String[] args) {
		System.out.println(a);
		System.out.println(m1());
		System.out.println(a);
	}

	public static int m1() {
		try {
			a = 10;
			return a;

		} catch (Exception e) {
			return a;
		} finally {
			a = 15;

		}
	}
}
