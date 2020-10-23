package com.ehr.oop05.callbyreference;

import com.ehr.oop05.method.callbyvalue.Data;

public class ReferenceParamMain {
	// 참조형 매개변수
	public static void main(String[] args) {
		
		Data d = new Data();
		d.x = 10;
		System.out.println("main(): x =" + d.x);
		change(d);
		System.out.println("AFTER CHANGE");
		System.out.println("main(): x =" + d.x);
	}

	static void change(Data data) {
		data.x = 100; //return형 없이도 값을 바꿀 수 있다.
		System.out.println("change(): x =" + data.x);
	}
}
