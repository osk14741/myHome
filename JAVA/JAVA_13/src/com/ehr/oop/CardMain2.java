package com.ehr.oop;

public class CardMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // �ν��Ͻ��� ���� ���� Ŭ�����̸�.Ŭ���� ������ ���
        System.out.println(Card.width);
        System.out.println(Card.height); 
        
        // �ν��Ͻ� ���� �� ��������.�ν��Ͻ� ������ ����
        Card c01 = new Card();
        c01.kind = "Heart";
        c01.number = 7;
        
        System.out.println(c01.kind);
        System.out.println(c01.number);
	}

}
