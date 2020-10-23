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
* ������   ������    ��������
*-----------------------------------------------------
*2020/06/18 ���ʻ���
*-----------------------------------------------------
* </pre>
*/

package com.ehr.oop24.exam07;

public class Ex06_08 {
    /**
     * Ŭ���� �޼��� 
     * @param arr
     * @return
     */
	static int[] shuffle(int[] arr) {
		int []result =new int[arr.length];
		//����: ����+�ڸ��ٲ�
        for(int i=0;i<arr.length;i++) {
        	//Random: 0.0<=x<1.0
        	int j =(int)(Math.random()*arr.length);
        	//�ڸ��ٲ�
        	int tmp = arr[i];
        	arr[i]     = arr[j];
        	arr[j]     = tmp; 
        }
		//�ּҹ��� ��ġ
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
