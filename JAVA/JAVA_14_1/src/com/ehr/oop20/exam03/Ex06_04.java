/**
* <pre>
* com.ehr.oop20.exam03
* Class Name : Ex06_04.java
* Description:
* Author: sist
* Since: 2020/06/18
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* ������   ������    ��������
*-----------------------------------------------------
*2020/06/18 ���ʻ���
*-----------------------------------------------------
* </pre>
*/

package com.ehr.oop20.exam03;

public class Ex06_04 {

	public static void main(String[] args) {
		Student s = new Student();
		s.name = "ȫ�浿";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		System.out.println("�̸�:" + s.name);
		System.out.println("����:" + s.getTotal());
		System.out.println("���:" + s.getAverage());
	}
	//----------------------------------------------
	//	[������]
	//	�̸�:ȫ�浿
	//	����:236
	//	���:78.7
	//----------------------------------------------
}
