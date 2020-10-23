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
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2020/06/18 최초생성
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
//[6-12] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
//메서드명 : abs
//기 능 : 주어진 값의 절대값을 반환한다.
//반환타입 : int
//매개변수 : int value
//[실행결과]
//8의 절대값:8
//-10의 절대값:10
	 * (1) abs메서드를 작성하시오.
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
		System.out.println(value + "의 절대값:" + abs(value));
		value = -10;
		System.out.println(value + "의 절대값:" + abs(value));
	}
}
