/**
* <pre>
* com.ehr.oop18.exam
* Class Name : SudaCard.java
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

package com.ehr.oop19.exam02;


public class SudaCard {
	/**ī���� ����(1-10���� ����) */
	int num;  
	/**���̸� true,�ƴϸ� false */
	boolean  isKwang;
	SudaCard(){
		this(1,true);//1 + true
	}
	
	SudaCard(int num,boolean isKwang){//3
		this.num = num;
		this.isKwang = isKwang;
	}
	
	String info() {
		String result = "";
		result = num+"";
		if(this.isKwang==true) {
			result+="K";
		}
		return result;
	}
	
	
	
	
	
	
}
