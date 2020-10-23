/**
* <pre>
* com.ehr.oop23.exam06
* Class Name : MyPoint.java
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

package com.ehr.oop23.exam06;

/**
 * @author sist
 *
 */
public class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/*
	 * (1) 인스턴스메서드 getDistance를 작성하시오.
	 */
	double getDistance(int x1,int y1) {
		double result = 0.0d;
		result=Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
		return result;
	}
	
	
	
	
	
	
}
