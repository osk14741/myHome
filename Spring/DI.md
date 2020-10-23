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

이렇게 될 것이다. 프로젝트가 커지면 커질수록 한땀한땀 수정해야하는 애물단지가 될 것이다.

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

