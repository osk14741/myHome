/**
* <pre>
* com.ehr.oop28.exam11
* Class Name : Ex06_12.java
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

package com.ehr.oop28.exam11;

/**
 * @author sist
 *
 */
public class Ex06_12 {
	/*
//[6-12] ������ ���� ���ǵ� �޼��带 �ۼ��ϰ� �׽�Ʈ�Ͻÿ�.
//�޼���� : abs
//�� �� : �־��� ���� ���밪�� ��ȯ�Ѵ�.
//��ȯŸ�� : int
//�Ű����� : int value
//[������]
//8�� ���밪:8
//-10�� ���밪:10
	 * (1) abs�޼��带 �ۼ��Ͻÿ�.
	 */
	static int abs(int value) {
		int result = 0;
		
		if(value>=0) {
			result = value;
		}else {
			result =-value;
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int value = 8;
		System.out.println(value + "�� ���밪:" + abs(value));
		value = -10;
		System.out.println(value + "�� ���밪:" + abs(value));
	}
}
