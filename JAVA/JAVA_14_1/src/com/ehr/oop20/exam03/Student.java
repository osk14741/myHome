/**
* <pre>
* com.ehr.oop20.exam03
* Class Name : Student.java
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

public class Student {
	 String	 name;//�л��̸�
	 int     	 ban ;//��
	 int     	 no  ;//��ȣ
	 int     	 kor ;//��������
	 int     	 eng ;//��������
	 int     	 math;//��������
    /**
     * ����(kor + eng + math)	 
     * @return int
     */
	 int getTotal() {
		 int result = 0;
		 result = kor + eng + math;
		 return result;
	 }
	 
	 float getAverage() {
		 // ����/�����=
		 float result = 0.0f;

		   //-�Ǽ� �Ҽ��� 4(1000/1000f)°�ڸ����� �ݿø�		
			//	3.141592f	-> 3.141
			//  (pi*1000)   -> 3141.592
			//  (pi*1000+0.5)   -> 3141.592+0.5
			//  (int)(pi*1000) -> 3141
			//  (int)(pi*1000)/1000f -> 3.141
		 int tot =(kor + eng + math);
		 //�Ҽ��� ��°�ڸ����� �ݿø��� ��.
		 result = ( (int)( tot /3.0f*10+0.5))/10f;
		 return result;
	 }
	 
	 
	 
	 
	 
	 
}





