## Override



오버라이드는 '고쳐 기입'하는 것이다.

아래 클래스를 보자.

```java
public class Superclass{
	//public Superclass(){}		기본 생성자 생략 가능
    public void method(){
        System.out.println("Superclass의 method");
    }
}

public class Subclass1 extends Superclass{
    //public Subclass(){}		기본 생성자 생략 가능
    public void method(){
        System.out.println("Subclass1의 method");
    }
}
public class Subclass2 extends Superclass{
    //public Subclass(){}		기본 생성자 생략 가능
    public void subMethod(){
        System.out.println("Subclass2의 subMethod");
    }
}
```

슈퍼클래스와 서브클래스가 있다.

서브클래스1은  슈퍼클래스와 메소드명과 매개변수가 동일한 method()를 가지고 있고,

서브클래스2는 슈퍼클래스와 다른 메소드를 가지고 있다. (method()는 없다.)

각각의 서브 클래스를 인스턴스화하여 method()를 호출하면 어떻게 될까?

```java
public class main {
	public static void main(String[] args) {
        Subclass1 sub1 = new Subclass1();
        Subclass2 sub2 = new Subclass2();
        sub1.method();
        sub2.method();
    }
}
```

```
>>Output
Subclass1의 method
Superclass의 method
```

sub1의 method는 Subclass1 에서 Override 된 method가 실행되고,

sub2의 method는 Superclass 의 method가 실행된다.



이렇게 슈퍼클래스의 완벽히 동일한 성질의 변수나 메소드를 서브클래스에서 바꿔 쓰는 것을 Override라고 한다.

하지만 sub1에서 Superclass의 method()에 접근하고 싶을 수도 있지 않을까?

아래의 Subclass1을 변경시킨 뒤 실행해보도록 하자.

```java
public class Subclass1 extends Superclass{
    public void method(){
        System.out.println("Subclass1의 method");
    }
    public void superMethod(){
        super.method();
    }
}
public class main {
	public static void main(String[] args) {
        Subclass1 sub1 = new Subclass1();
        sub1.method();
        sub1.superMethod();
    }
}
```

```
>>Output
Subclass1의 method
Superclass의 method
```

Subclass1에 있는 method 내부에 super.method(); 라는 코드를 보자.

this.method()와 닮아있다.

this는 자기 자신을 참조하는 것이었고, super는 슈퍼클래스를 참조한다. 

super.method()는 실행된 클래스인 Subclass1의 슈퍼클래스인 superclass의 method()를 실행한다는 것이다.



그렇다면 Override는 왜 사용하는 것일까?

1. 협업 시, 기존에 작성된 클래스를 상속해서 쓰는데 method 수정이 필요한 경우

2. 슈퍼클래스에서만 사용되는 메소드가 있을 때, 이를 자식클래스에 사용하기 위해 만드는 경우



또한 다형성으로 객체들을 관리하다 보면 Over ride를 쓸 경우도 생긴다.

해당 Polymorphism 포스팅에서 알아보겠다.