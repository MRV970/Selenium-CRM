package DataDriven;

public class B {
	public static void main(String[] args) {
		System.out.println(m1());
	}

public static int m1() {
		int a = 5;
		try {
			a=5/0;
			return a;
			
		} catch (Exception e) {
			System.out.println("catch block");
          System.exit(0);
		} 
		finally {
			a = 10;
			return a;
		}
	}
}
