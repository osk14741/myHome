package com.ehr.oop;

public class CardMain {
//	2. Ŭ���� ����					
//	- ���� Ŭ������ ��� �ν��Ͻ����� �����ϴ� ����				
//	- �ν��Ͻ� �������� Ŭ�����̸�.Ŭ��������				
//	- Ŭ������ �ε��� �� ����, ���α׷��� ����� �� �Ҹ�.
	public static void main(String[] args) {
		
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);
		
		Card c01 = new Card();
		c01.kind = "Heart";
		c01.number = 7;
		
		Card c02 = new Card();
		c02.kind = "Spade";
		c02.number = 8;
		
		System.out.println("c01�� " + c01.kind + "," + c01.number + " ũ�� : " + Card.width + "," + Card.height);
		System.out.println("c02�� " + c02.kind + "," + c02.number + " ũ�� : " + Card.width + "," + Card.height);
		
		Card.width = 150;
		Card.height = 300;
		
		System.out.println("c01�� " + c01.kind + "," + c01.number + " ũ�� : " + Card.width + "," + Card.height);
		System.out.println("c02�� " + c02.kind + "," + c02.number + " ũ�� : " + Card.width + "," + Card.height);
		

		
		
	}

}
