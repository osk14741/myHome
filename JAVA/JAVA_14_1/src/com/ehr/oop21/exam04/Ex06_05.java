/**
* <pre>
* com.ehr.oop21.exam04
* Class Name : Ex06_05.java
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

package com.ehr.oop21.exam04;

/**
 * @author sist
 *
 */
public class Ex06_05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	     Student s = new Student("홍길동",1,1,100,60,76); 
	     System.out.println(s.info());
	     System.out.println(s.toString());

	}
//	[실행결과]
//			홍길동,1,1,100,60,76,236,78.7
//          홍길동,1,1,100,60,76,236,78.7	
}
