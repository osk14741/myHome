/**
* <pre>
* com.ehr.oop25.exam08
* Class Name : Ex06_09.java
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

package com.ehr.oop25.exam08;

public class Ex06_09 {

	public static void main(String[] args) {
		MyTv t = new MyTv();
		t.channel = 1;
		t.volume = 0;
		
//		System.out.println("t.isPowerOn:"+t.isPowerOn);
//		t.turnOnOff();
//		System.out.println("t.isPowerOn turnOnOff call:"+t.isPowerOn);
//		//-----------------------------------------------------------------
//		System.out.println("t.volume:"+t.volume);
//		t.volumeUp();
//		System.out.println("t.volumeUp call:"+t.volume);
//		//-----------------------------------------------------------------
//		t.volumeDown();
//		System.out.println("t.volume:"+t.volume);
//		t.volumeDown();
//		System.out.println("t.volumeDown call:"+t.volume);
		//-----------------------------------------------------------------
//		System.out.println("t.channel :"+t.channel );
//		t.channelUp();
//		System.out.println("t.channel :"+t.channel );
		//-----------------------------------------------------------------		
		System.out.println("t.channel :"+t.channel );
		t.channelDown();
		System.out.println("t.channel :"+t.channel );
		
	}

}
