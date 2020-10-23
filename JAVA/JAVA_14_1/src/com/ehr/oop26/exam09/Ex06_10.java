/**
* <pre>
* com.ehr.oop26.exam09
* Class Name : Ex06_10.java
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

package com.ehr.oop26.exam09;

public class Ex06_10 {
//	�޼���� : isNumber
//	�� �� : �־��� ���ڿ��� ��� ���ڷθ� �̷�����ִ��� Ȯ���Ѵ�.
//  String -> char
//  !('0'<=char<='9')	
//	��� ���ڷθ� �̷���� ������ true�� ��ȯ�ϰ�,
//	�׷��� ������ false�� ��ȯ�Ѵ�.
//	���� �־��� ���ڿ��� null�̰ų� ���ڿ������̶�� false�� ��ȯ�Ѵ�.
//	��ȯŸ�� : boolean
//	�Ű����� : String str - �˻��� ���ڿ�
	static boolean isNumber(String str){
		if(null == str || "".equals(str) ){
		     return false;
		}
		
		//The local variable result may not have been initialized
		boolean result=true;
		//���ڿ� -> char
		for(int i=0;i<str.length();i++) {
			char  ch = str.charAt(i);
			//���ڿ��� �ǰ���:!('0'<=char<='9')	
			if('0'>ch || ch>'9' ) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		String str = "123";
		//123�� �����Դϱ�? true
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));
		str = "1234o";
		//1234o�� �����Դϱ�? false
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));
		
		str = null;
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));
		
		str = "";
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));
		
		
	}

}
