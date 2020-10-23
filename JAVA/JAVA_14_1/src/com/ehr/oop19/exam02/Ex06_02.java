/**
* <pre>
* com.ehr.oop19.exam02
* Class Name : Ex06_02.java
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

package com.ehr.oop19.exam02;

/**
 * @author sist
 *
 */
public class Ex06_02 {


	public static void main(String[] args) {
		SudaCard card1 = new SudaCard(3, false); 
		SudaCard card2 = new SudaCard();

		System.out.println(card1.info()); // 3  
		System.out.println(card2.info()); // 1K
	}

}
