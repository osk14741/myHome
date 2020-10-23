### DI(Dependency Injection)

의존성 주입 : 소프트웨어 엔지니어링에서 의존성 주입은 하나의 객체가 다른 객체의 의존성을 제공하는 테크닉이다. "의존성"은 예를 들어 서비스로 사용할 수 있는 객체이다. 클라이언트가 어떤 서비스를 사용할 것인지 지정하는 대신, 클라이언트에게 무슨 서비스를 사용할 것인지를 말해주는 것이다.

란다. 의존성. 프로그래밍을 처음 배우는 입장에서 참 어려운 말이면서도 자주 나오는 말이다. 

그래서 이 의존성이 뭔데? 라고 물으면 귀찮음을 늘리는 거지 않을까 생각이 든다. 예를 들어

```java
class Tier {
    public wheel(){
        Log.debug("구른다.");
    }
}
class Car {
    Tier tier;
    
    public Car(){
        this.tier = new tier();
    }
    
    public drive(){
        this.tier.wheel();
    }
}
```

내가 만약 Car 클래스를 호출했다. 근데 tier 객체도 딸려오지 않나. 근데 만약

```java
class NexenTier extends Tier {  
}
class HankookTier extends Tier {
}
```

가 되어버린다면 어떨까. Tier가 아니라 NexenTier, HankookTier..? 아.. 벌써 귀찮다. 이 때 Car와 Tier는 의존성을 가진다고 한다. 

```java
class Car {
    Tier tier;
    
    public Car(){
        // 무슨 타이어를 쓰는 차인지 고른다.
        this.tier = new NexenTier();
        //or
        this.tier = new HankookTier();
        //or
        ....
    }
    
    public drive(){
        this.tier.wheel();
    }
}
```

이렇게 될 것이다. 프로젝트가 커지면 커질수록 한땀한땀 수정해야하는 애물단지가 된다.

하지만 외부에서 주입해준다면 어떨까?

```java
class Car() {
	Tier tier;
    
    public Car(Tier tier){
        this.tier = tier;
    }
    
    public drive(){
        this.tier.wheel();
    }
}
```

![](https://github.com/osk14741/myHome/blob/main/Spring/IMG/DI_1.jpg)

이런 식이다.

그렇다면 정작 중요한 Spring에서는 어떻게 사용하나?

Car에서 직접 객체를 생성하는 게 아니라 외부(IOC 컨테이너)에서 생성된 Tier를 Setter나 Constructor를 이용하여 넣어주게 된다.

```java
package com.my.car;

public class Tier {
	String color;
        
	public void setColor(String color) {
		this.color = color;
	}
	
    public void wheel(){
        Log.debug("구른다.");
    }
}
public class Car {
	Tier tier;
	
	public void setTier(Tier tier) {
		this.tier = tier;
	}
    
    public drive(){
        this.tier.wheel();
    }
}

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="car" class="com.my.car.Car">
		<property name="tier" ref="tier"/>
	</bean>

	<bean id="tier" class="com.my.car.Tier">
		<property name="color" value="Black"/>
	</bean>
	
</beans>
```

setter를 통해 bean을 주입해주는 것이다.(constructor를 통해서도 주입이 가능하다.)

| 이름  | 내용                     |
| ----- | ------------------------ |
| id    | 고유한 식별 id           |
| class | 그 클래스의 package 위치 |
| name  | setter의 이름            |
| value | 주입할 값                |
| ref   | 참조할 id 값             |

Java 코드와는 다르게 바로바로 확확 보여주지 않으니 항상 따라가보는 습관을 가져야 할 것 같다. 솔직히 초반에 난 에러의 1/3은 대소문자 혹은 오타의 문제였다...