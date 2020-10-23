package com.ehr.oop05.callbyreference;

public class ReferenceParamArrayMain {

	public static void main(String[] args) {
		
		int[] x = { 10 }; //크기가 1인 배열, x[0] = 10;
		System.out.println("BEFORE : " + x[0]);
		change(x);
		System.out.println("AFTER : " + x[0]);
	}

	static void change(int[] x) {
		
		x[0] = 1000;
		System.out.println("change(): x = " + x[0]);
	}
}
