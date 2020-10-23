package com.ehr.oop;

public class CardMain {
//	2. 클래스 변수					
//	- 같은 클래스의 모든 인스턴스들이 공유하는 변수				
//	- 인스턴스 생성없이 클래스이름.클래스변수				
//	- 클래스가 로딩될 때 생성, 프로그램이 종료될 때 소멸.
	public static void main(String[] args) {
		
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);
		
		Card c01 = new Card();
		c01.kind = "Heart";
		c01.number = 7;
		
		Card c02 = new Card();
		c02.kind = "Spade";
		c02.number = 8;
		
		System.out.println("c01은 " + c01.kind + "," + c01.number + " 크기 : " + Card.width + "," + Card.height);
		System.out.println("c02은 " + c02.kind + "," + c02.number + " 크기 : " + Card.width + "," + Card.height);
		
		Card.width = 150;
		Card.height = 300;
		
		System.out.println("c01은 " + c01.kind + "," + c01.number + " 크기 : " + Card.width + "," + Card.height);
		System.out.println("c02은 " + c02.kind + "," + c02.number + " 크기 : " + Card.width + "," + Card.height);
		

		
		
	}

}
