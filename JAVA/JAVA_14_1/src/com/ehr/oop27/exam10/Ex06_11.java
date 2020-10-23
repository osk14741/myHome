/**
* <pre>
* com.ehr.oop27.exam10
* Class Name : Ex06_11.java
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

package com.ehr.oop27.exam10;

public class Ex06_11 {
	/*
	 * (1) max메서드를 작성하시오.
	 */
	static int max(int[] arr) {
		int result = 0;
		if(null == arr ||  0==arr.length) {
			return -999999;
		}
		
		int max = 0;
		max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		result = max;
		
		return result;
	}
	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
	}
}



