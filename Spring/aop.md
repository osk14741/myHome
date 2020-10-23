### AOP(Aspect Oriented Programming)

관점 지향 프로그래밍 : 컴퓨팅에서 관점 지향 프로그래밍은 횡단 관심사의 분리를 허용함으로써 모듈성을 증가시키는 것이 목적인 프로그래밍 패러다임이다.

처음 이 개념을 봤을 때 느낀 감정은 OOP 잘 써놓고 왜 또 쪼개려고 하는거야? 였다. 깊게 생각하지 않다가 aop 관련 글을 읽고나서부터 조금씩 공부를 해보게 되었다.

aspect? advice? pointcut? 사실 영어를 그렇게 잘 하지 못하는 나로썬 괜히 머리만 아프고 마음으로 와닿지 않는 말이다. 하지만 코드를 들여다보니 결국 aspect는 공통적인 기능을 하는 부분. advice는 그 기능. jointpoint는 기능이 적용될 위치 등등. pointcut은 그 시점이 어딘지 구체화하는 것이었더라.

어렵게 말하면 흩어진 관심사를 모듈화한다. 라는 마치 철학과도 같은 말이 되지만 쉽게 생각하니 그냥 여러군데 쓰이는 기능을 떼다가 한번에 수정하고 붙이는 기능이었던 것이다. 괜히 관심사라는 말이 좀 있어보여 어려웠던 걸 지도 모른다.

예를 들어 보자.

|             | A() aspect | Body   | Z() aspect |
| ----------- | ---------- | ------ | ---------- |
| aFunction() | A()        | Body() | Z()        |
| bFunction() | A()        | Body() | Z()        |
| cFunction() | A()        | Body() | Z()        |
| ...         | A()        | ...    | Z()        |

밑으로도 dFunction(), eFunction(), fFunction()로 쭉 나갈 것이다.



이 AOP를 생각한 사람은 A()를 붙이고 싶은데 메서드가 100개면 A()를 100번 써야하잖아? 그냥 Body 부분에 앞뒤로 A(), Z()를 붙일 방법은 없을까 라는 고민으로 시작했을것 같다. 

```java
public void aFunction(){
    A();
    doMethod();
    Z();
}
public void bFunction(){
    A();
    doMethod();
    Z();
}
...
```

보기만 해도 귀찮고 번거롭다. 만약 A() 함수가 A(param)이라도 되어버리는 날에는 끔찍한 일이 벌어질 수도 있을 것이다. IDE의 힘을 빌린다면 가능하겠지만 어쨌든 수정하고 확인이라도 해야 하지 않겠는가.

이렇게 생각하니 왜 쓰는지 어렴풋이 이해가 되기 시작했다. 행으로 수정해야할 걸 열로 수정하다니! 엑셀 쓸 때도 열로 수정하면서 왜 이걸 어렵게 생각했는지. 

심지어 쓰는 방법도 간편하다. (자잘한 설정은 제쳐두고) advice(A(), Z())를 만들고 ..Function()을 만든다. 그리고 xml을 쓰든 class를 쓰든 저기 앞이든 뒤든 어디다가 붙이겠다! 적어놓기만 하면 된다.


