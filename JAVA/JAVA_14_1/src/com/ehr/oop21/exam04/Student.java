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

package com.ehr.oop21.exam04;

public class Student {
	 String	 name;//�л��̸�
	 int     	 ban ;//��
	 int     	 no  ;//��ȣ
	 int     	 kor ;//��������
	 int     	 eng ;//��������
	 int     	 math;//��������
	 
	 Student(){
		 
	 }
	 
	 Student(String	 name,int ban,int no,int kor,int eng,int math){
		 this.name = name;
		 this.ban   = ban;
		 this.no     = no;
		 this.kor    = kor;
		 this.eng   = eng;
		 this.math  = math;
	 }
	 
	 String info() {
		 String result = "";
		 //ȫ�浿,1,1,100,60,76,236,78.7
		 String delim = ",";
		 result +=this.name +delim;
		 result +=this.ban +delim;
		 result +=this.no +delim;
		 result +=this.kor +delim;
		 result +=this.eng +delim;
		 result +=this.math +delim;
		 result +=this.getTotal() +delim;
		 result +=this.getAverage() ;
		 return result;
	 }
	 
	 
	 
	 
	 
    @Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", getTotal()=" + getTotal() + ", getAverage()=" + getAverage() + "]";
	}

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





