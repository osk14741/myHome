package com.ehr.oop05.method.callstack;

public class CallStackTest {

	public static void main(String[] args) {
		
		System.out.println("01 MAIN");
		firstMethod();
		System.out.println("02 MAIN");
	}

	static void firstMethod() {
		System.out.println("01 FIRST METHOD");
		secondMethod();
		System.out.println("01 FIRST METHOD");
	}
	
	static void secondMethod() {
		System.out.println("SECOND METHOD");
	}
}
