/**
* <pre>
* com.ehr.oop23.exam06
* Class Name : Exercise06_07.java
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

public class Exercise06_07 {

	public static void main(String[] args) {
		MyPoint  myPoint=new MyPoint(1, 1);
		
		System.out.println("두점사이 거리:"+myPoint.getDistance(2, 2));

	}
    //------------------------------------
	//두점사이 거리:1.4142135623730951
	//------------------------------------
}
