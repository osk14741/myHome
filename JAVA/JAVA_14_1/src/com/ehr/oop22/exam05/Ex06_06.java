/**
* <pre>
* com.ehr.oop22.exam05
* Class Name : Ex06_06.java
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

package com.ehr.oop22.exam05;

public class Ex06_06 {
	// �� �� (x,y)�� (x1,y1)���� �Ÿ��� ���Ѵ�.
	//Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y))
	static double getDistance(int x, int y, int x1, int y1) {
		double result = 0.0;
		/*
		 * (1) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
		 * Math.sqrt(double a)
		 * Returns the correctly rounded positive square root 
		 */
		result = Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
		return result;
	}

	public static void main(String[] args) {
		  System.out.println(getDistance(1, 1, 2, 2));
	}
    //----------------------------------
	//�����
	//1.4142135623730951
	//----------------------------------
}
