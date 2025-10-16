package DataDriven;

import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		int n=150;
		BigInteger result=BigInteger.ONE;
		while(n>0) {
			BigInteger b= BigInteger.valueOf(n);
			result = result.multiply(b);
			n--;
		}
		System.out.println(result);
	}
}
