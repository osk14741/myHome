package com.ehr.oop05.callbyreference;

import com.ehr.oop05.method.callbyvalue.Data;

public class ReferenceParamMain {
	// ������ �Ű�����
	public static void main(String[] args) {
		
		Data d = new Data();
		d.x = 10;
		System.out.println("main(): x =" + d.x);
		change(d);
		System.out.println("AFTER CHANGE");
		System.out.println("main(): x =" + d.x);
	}

	static void change(Data data) {
		data.x = 100; //return�� ���̵� ���� �ٲ� �� �ִ�.
		System.out.println("change(): x =" + data.x);
	}
}
