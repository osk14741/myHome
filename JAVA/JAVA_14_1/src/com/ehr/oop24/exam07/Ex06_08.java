/**
* <pre>
* com.ehr.oop24.exam07
* Class Name : Ex06_08.java
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

package com.ehr.oop24.exam07;

public class Ex06_08 {
    /**
     * 클래스 메서드 
     * @param arr
     * @return
     */
	static int[] shuffle(int[] arr) {
		int []result =new int[arr.length];
		//셔플: 랜덤+자리바뀜
        for(int i=0;i<arr.length;i++) {
        	//Random: 0.0<=x<1.0
        	int j =(int)(Math.random()*arr.length);
        	//자리바뀜
        	int tmp = arr[i];
        	arr[i]     = arr[j];
        	arr[j]     = tmp; 
        }
		//주소번지 일치
		result = arr;
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
