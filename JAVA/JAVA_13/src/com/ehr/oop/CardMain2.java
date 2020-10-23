package com.ehr.oop;

public class CardMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 인스턴스의 생성 없이 클래스이름.클래스 변수로 사용
        System.out.println(Card.width);
        System.out.println(Card.height); 
        
        // 인스턴스 생성 후 참조변수.인스턴스 변수로 접근
        Card c01 = new Card();
        c01.kind = "Heart";
        c01.number = 7;
        
        System.out.println(c01.kind);
        System.out.println(c01.number);
	}

}
