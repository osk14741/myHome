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
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2020/06/18 최초생성
*-----------------------------------------------------
* </pre>
*/

package com.ehr.oop26.exam09;

public class Ex06_10 {
//	메서드명 : isNumber
//	기 능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
//  String -> char
//  !('0'<=char<='9')	
//	모두 숫자로만 이루어져 있으면 true를 반환하고,
//	그렇지 않으면 false를 반환한다.
//	만일 주어진 문자열이 null이거나 빈문자열“”이라면 false를 반환한다.
//	반환타입 : boolean
//	매개변수 : String str - 검사할 문자열
	static boolean isNumber(String str){
		if(null == str || "".equals(str) ){
		     return false;
		}
		
		//The local variable result may not have been initialized
		boolean result=true;
		//문자열 -> char
		for(int i=0;i<str.length();i++) {
			char  ch = str.charAt(i);
			//숫자여부 판가름:!('0'<=char<='9')	
			if('0'>ch || ch>'9' ) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		String str = "123";
		//123는 숫자입니까? true
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		//1234o는 숫자입니까? false
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
		str = null;
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
		str = "";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
		
	}

}
