package com.ehr.oop05.method.callbyvalue;

public class PrimitiveParamMain {

	public static void main(String[] args) {
		
		Data data = new Data();
		data.x = 11;
		System.out.println("main() : x = " + data.x);
		change(data.x);
		System.out.println("After Change(data.x)");
		System.out.println("main() : x = " + data.x);
		System.out.println();
		change2(data);
		System.out.println("After Change2(data.x)");
		System.out.println("main() : x = " + data.x);
		
		
	}

	static void change(int x) {
		x = 1000;
		System.out.println("change() : x = " + x);
	}
	
	static void change2(Data d) {
		d.x = 1000;
		System.out.println("change() : d.x = " + d.x);
	}
	
}
