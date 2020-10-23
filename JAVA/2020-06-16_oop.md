## 변수와 메서드

#### 선언 위치에 따른 변수의 종류

```java
class Variables {
    int iv; // 인스턴스 변수
    static int cv; // 클래스 변수(static 변수, 공유변수)
    
    void method {
        int localV = 0; // 지역 변수
    }
}
```

|  변수의 종류  |  선언 위치  |            생성 시기             |
| :-----------: | :---------: | :------------------------------: |
|  클래스 변수  | 클래스 영역 |   클래스가 메모리에 올라갈 때    |
| 인스턴스 변수 | 클래스 영역 |         인스턴스 생성 시         |
|   지역 변수   |   메서드    | 메서드 수행(변수 선언문 수행 시) |



##### 인스턴스 변수

각 인스턴스 별 별도의 저장 공간, 인스턴스 별로 다른 값 저장

인스턴스 생성 후 참조변수.인스턴스 변수로 접근

인스턴스 생성 할 때 생성, 참조변수가 없을 때 가비지 컬렉터에 의해 제거.

##### 클래스 변수

같은 클래스의 모든 인스턴스들이 공유하는 변수

<u>*인스턴스 생성없이 클래스이름.클래스 변수*</u>

클래스가 로딩될 때 생성, 프로그램이 종료될 때 소멸

##### 지역 변수

메서드 내에 선언, 메서드의 종료와 함께 소멸

조건문, 반복문의 블록{ }내에 선언된 지역변수는 블록을 벗어나면 소멸



#### 클래스 변수와 인스턴스 변수

```java
class Card{
    String kind; // 무늬
    int number; // 숫자
    
    static int width = 100;
    static int height = 200;
}

public class CardMain{
    public static void main(String[] args){
        
        // 인스턴스의 생성 없이 클래스이름.클래스 변수로 사용
        System.out.println(Card.weight);
        System.out.println(Card.height); 
        
        // 인스턴스 생성 후 참조변수.인스턴스 변수로 접근
        Card c01 = new Card();
        c01.kind = "Heart";
        c01.number = 7;
        
        System.out.println(c01.kind);
        System.out.println(c01.number);
        
    }
}
```

```
100
200
Heart
7
```



#### 메서드

작업을 수행하기 위한 명령문의 집합

어떤 값을 입력받아서 처리하고 그 결과를 돌려준다.(입력값이 없을 수도 있고 있을 수도 있다.)



#### 메서드의 장점 및 작성지침

반복적인 코드를 줄이고 코드의 관리가 용이

<u>*반복적으로 수행되는 여러 문장을 메서드로 작성*</u>

<u>*하나의 메서드는 한 가지 기능만 수행하도록 작성*</u>

여러 문장을 메서드로 작성



#### 메서드의 선언과 구현

클래스 영역에서만 정의할 수 있음. (메서드 안에 메서드 X)

```java
반환타입 메서드이름(타입변수명, 타입변수명, ...) { // <-선언부
    
    // 구현부 : 메서드 호출 시 사용 될 코드
    
}
```

```java
int add(int a, int b){
    int result = 0;
    result = a + b;
    return result;
}

void power() {
    power != power;
}

int add(int a, b){  // 이런 식은 안됨.
    int result = 0; // XXX
    result = a + b; // XXX
    return result;  // XXX
}                   // XXX
```



##### 메서드 이름

카멜케이스, 함축적이면서도 의미 있는 이름.

ex) addint()



##### 반환 타입(return type)

메서드가 블록{ } 의 끝에 도달했을 때

메서드가 블록{ } 을 수행 도중 return 문을 만났을 때



##### return문

반환 값이 있는 경우 : return 반환값;

반환 값이 없는 경우 : return;

```java
int add(int a, int b){
    int result = 0;
    result = a + b;
    return result; // 반환값의 타입이 일치해야 함.
}
```



##### return문 주의사항

```java
int add(int a, int b){
    if(a > b) {
        return a;
    }
} // 모든 경우에 대해 return 값을 주자.

//->>>>>>>>>>>>>
int add(int a, int b){
    if(a > b) {
        return a;
    } else {
        return b;
    }
}
```



#### 메서드 호출

참조변수.메서드 이름();

참조변수.메서드 이름(값1, 값2, ...);

```java
class MyMath{
    long add(long a, long b){
        long result = 0;
        result = a + b;
        return result;
    }
    
    double divide(double a, double, b){
        double result = 0;
        result = a / b;
        return result;
    }
}
```

```java
public class MyMathMain{
    public static void main(String[] args){
        
        MyMath myMath = new MyMath();
        
        long value = myMath.add(1L, 2L); // 타입을 맞춰준다.
        double value2 = myMath.divide(3d, 4d);
    }
}
```



#### JVM의 메모리 구조

| **METHOD AREA** | 클래스 정보와 변수가 저장                                    |
| :-------------: | ------------------------------------------------------------ |
| **CALL STACK**  | **메서드의 작업공간 : 메서드가 호출되면 메서드가 수행될 메모리 공간을 할당받고, 메서드를 수행하고 종료되면 사용하던 메모리 반환** |
|    **HEAP**     | **인스턴스 생성, new 연산자에 의해 생성, 배열과 객체는 모두 여기에** |

```java
public class CallStackTest {

	public static void main(String[] args) {
		
		System.out.println("01 MAIN");
		firstMethod();
		System.out.println("02 MAIN");
	}

	static void firstMethod() {
		System.out.println("01 FIRST METHOD");
		secondMethod();
		System.out.println("01 FIRST METHOD");
	}
	
	static void secondMethod() {
		System.out.println("SECOND METHOD");
	}
}
```

```
01 MAIN
01 FIRST METHOD
SECOND METHOD
01 FIRST METHOD
02 MAIN
```

![asdfasdf](https://github.com/osk14741/ehrStudy/blob/master/JAVA/asdf.jpg)



#### 기본형 매개변수와 참조형 매개변수

##### 기본형 매개변수 : 변수의 값을 읽기만 할 수 있다.

##### 참조형 매개변수 : 변수의 값을 읽고 변경할 수 있다.

```java
public class PrimitiveParamMain {

	public static void main(String[] args) {
		
		Data data = new Data();
		data.x = 11;
		System.out.println("main() : x = " + data.x);
		change(data.x);
		System.out.println("After Change(data.x)");
		System.out.println("main() : x = " + data.x);
        System.out.println();
        change2(data);
        System.out.println("After Change2(data.x)");
        System.out.println("main() : x = " + data.x);
		
	}
	// 기본형 매개변수
	static void change(int x) {
		x = 1000;
		System.out.println("change() : x = " + x);
	}
    // 참조형 매개변수
    static void change2(Data d){
        d.x = 1000;
        System.out.println("change() : x = " + d.x);
    }
}

```

```java
main() : x = 11
change() : x = 1000
After Change(data.x)
main() : x = 11

change() : d.x = 1000
After Change2(data.x)
main() : x = 1000
```

기본형 매개변수 : change 메서드에서 main 메서드로부터 넘겨받은 d.x의 값을 변경한 것이 아니라 change 메서드의 매개변수 x(지역변수)의 값이 변경된 것.

참조형 매개변수 : change 메서드에 값이 아닌 값이 저장된 주소를 넘겨주었기 때문에 인스턴스의 변수가 변한 것.

> 객체를 넘기느냐 변수를 넘기느냐 차이인 것 같다.

쓰는 이유 : 반환 값이 없어도 메서드의 결과값을 가져올 수 있다.

