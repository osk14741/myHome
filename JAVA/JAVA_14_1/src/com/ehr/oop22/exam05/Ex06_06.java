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
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2020/06/18 최초생성
*-----------------------------------------------------
* </pre>
*/

package com.ehr.oop22.exam05;

public class Ex06_06 {
	// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
	//Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y))
	static double getDistance(int x, int y, int x1, int y1) {
		double result = 0.0;
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
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
	//결과값
	//1.4142135623730951
	//----------------------------------
}
