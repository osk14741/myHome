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
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2020/06/18 최초생성
*-----------------------------------------------------
* </pre>
*/

package com.ehr.oop20.exam03;

public class Student {
	 String	 name;//학생이름
	 int     	 ban ;//반
	 int     	 no  ;//번호
	 int     	 kor ;//국어점수
	 int     	 eng ;//영어점수
	 int     	 math;//수학점수
    /**
     * 총합(kor + eng + math)	 
     * @return int
     */
	 int getTotal() {
		 int result = 0;
		 result = kor + eng + math;
		 return result;
	 }
	 
	 float getAverage() {
		 // 총합/과목수=
		 float result = 0.0f;

		   //-실수 소숫점 4(1000/1000f)째자리에서 반올림		
			//	3.141592f	-> 3.141
			//  (pi*1000)   -> 3141.592
			//  (pi*1000+0.5)   -> 3141.592+0.5
			//  (int)(pi*1000) -> 3141
			//  (int)(pi*1000)/1000f -> 3.141
		 int tot =(kor + eng + math);
		 //소수점 둘째자리에서 반올림할 것.
		 result = ( (int)( tot /3.0f*10+0.5))/10f;
		 return result;
	 }
	 
	 
	 
	 
	 
	 
}





