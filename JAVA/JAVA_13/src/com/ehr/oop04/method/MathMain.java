package com.ehr.oop04.method;

public class MathMain {

	public static void main(String[] args) {
		
		MyMath myMath = new MyMath();
		
		System.out.println(myMath.add(1L, 2L) == 3);
		System.out.println(myMath.subtract(2L, 1L));
		System.out.println(myMath.multiple(2L, 4L));
		System.out.println(myMath.divide(2L, 0L));
		System.out.println(myMath.divide(12L, 5L));
		
	}

}
