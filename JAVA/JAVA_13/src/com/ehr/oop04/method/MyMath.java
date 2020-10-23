package com.ehr.oop04.method;

public class MyMath {

	/**
	 * ¥ı«œ±‚(a + b)
	 * @param a
	 * @param b
	 * @return long
	 */
	long add(long a, long b) {
		long result = 0;
		result = a + b;		
		return result;
	}
	
	/**
	 * (a - b)
	 * @param a
	 * @param b
	 * @return long
	 */
	long subtract(long a, long b) {
		long result = 0;
		result = a - b;
		return result;
	}
	
	/**
	 * (a * b)
	 * @param a
	 * @param b
	 * @return long
	 */
	long multiple(long a, long b) {
		long result = 0;
		result = a * b;
		return result;
	}
	
	/**
	 * (a / b)
	 * @param a
	 * @param b
	 * @return double
	 */
	double divide(double a, double b) {
		double result = 0;
		if (b == 0) {
			System.out.println("can't divide. b can't be 0. return 0.");
			return 0;
		}
		result = a / b;
		return result;
	}
	

}
