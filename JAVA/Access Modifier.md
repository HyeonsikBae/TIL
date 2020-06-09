## Access Modifier

### 접근제어자



__접근제어자__란,

선언된 __클래스의 정보를 어디까지 접근 가능하게 할 것인지를 제어__하는 키워드이다.

외부에서의 접근 권한을 제어하여 __정보 은닉__을 구체화 할 수 있다. 



접근제어자의 종류에는,

__public, protected, default, private__의 4가지 종류가 있다.

이를 학습하기 전에 필요한 개념들에는 __패키지, 클래스, 상속, 생성자__가 있다고 생각된다.

선수개념들에 대한 내용들을 따로 정리해놓았으니 참고하면 좋을 것 같다 :)



이제부터 각각의 접근제어자에 대해 알아보자.

1. public

- public을 통해 선언된 멤버는 누구나 접근을 할 수 있다.

2. protected

- protected를 통해 선언된 멤버는 동일 패키지의 클래스와 서브 클래스만 접근이 가능하다.

3. default

- 접근제어자 없이 선언된 멤버는 동일 패키지의 클래스만 접근이 가능하다.

4. private

- private를 통해 선언된 멤버는 자기자신 클래스 내에서만 접근이 가능하다.

| 종류      | 해당 클래스 | 서브 클래스 | 동일 패키지 | 모든 클래스 |
| --------- | ----------- | ----------- | ----------- | ----------- |
| public    | O           | O           | O           | O           |
| protected | O           | O           | O           | X           |
| (default) | O           | X           | O           | X           |
| private   | O           | X           | X           | X           |



자주 쓰이는 public과 private 예시 코드를 보자.

```java
package accessModifier;

public class PublicClass {
	public static void main(String[] args) {
		/*
		main method를 아래에서 한 줄씩 차근차근 작성해나가보도록 하겠다.
		*/
	}
}
class Car{
	private String engine;
	String name;
	
	public Car(String name) {
		this.name = name;
	}
	public void engineSet(String engine) {
		this.engine = engine;
	}
	public void nameSet(String name) {
		this.name = name;
	//nameSet 메소드는 engineSet 메소드와 같아 아래 설명에서 생략하였다.
	}
    public void fullAccel(){
    	System.out.println(this.engine + " : 부릉!\t");
        System.out.println(this.name + " : 출발!");
    }
    public void info() {
    	System.out.print("엔진은  " + engine);
    	System.out.println("\t이름은 " + name);
    }
}
```

```java
main-
    Car car = new Car("다마스"); <<
/*	Car 클래스의 생성자를 통해 객체 car가 만들어진다.
	Car 클래스 -> Car 생성자 -> this.name (호출한 객체의 name) 에 접근하여 "다마스"를 
	넣는다.
```

```java
main-
	Car car = new Car("다마스");
	car.info(); <<
//	엔진은 null	이름은 다마스

/*	엔진에 넣어준 값은 없으므로 null, 이름은 다마스가 출력된다.
	참고로 숫자타입의 default 값은 0이다.
```

```java
main-
	Car car = new Car("다마스");
	car.info();
	car.name = "스파크"; <<
/*	car의 name 변수에 바로 접근하여 내용을 "스파크"로 바꾼다.
	Car 클래스 내부의 변수 name 은 따로 접근제어자가 없으므로 default이고 같은 패키지 내에서
	접근이 가능하다.
```

```java
main-
	Car car = new Car("다마스");
	car.info();
	car.name = "스파크";
	car.engine = "전륜"; //<<ERROR!!!
/*	위와 같은 방법으로 car의 engine 변수를 바꾸려하지만 에러가 나온다.
	Car 클래스 내부의 변수 engine은 private 이므로 Car 클래스 내에서만 접근이 가능하다.
```

```java
main-
	Car car = new Car("다마스");
	car.info();
	car.name = "스파크";
	//car.engine = "전륜";
	car.engineSet("전륜"); <<
/*	Car 클래스 내부의 engineSet 메소드를 통하여 car의 engine 값을 넣어주었다.
	
	이해하기 어려웠지만... 
	객체 = 나, private 변수 = 엔진, 메소드 = 페달이라고 했을 때,
	내가 엔진을 바로 움직일 순 없지만 페달이라는 메소드를 통해 엔진의 상태를 바꿀 수 있다고
	하면 비교적 이해하기 쉬울 것이다.
```

```java
main-
	Car car = new Car("다마스");
	car.info();
	car.name = "스파크";
	//car.engine = "전륜";
	car.engineSet("전륜");
	car.fullAccel(); <<
//	전륜 : 부릉!	스파크 : 출발!
        
/*	car의 name과 car의 engine 값이 바뀐 걸 볼 수 있다.
```

메인 메소드를 한 줄씩 작성하다보니 글이 길어졌지만, 한 단계씩 차근차근 본다면 이해가 좀 더 쉬울 것이다.

핵심은 car 객체의 engine 값을 바꾸는 것이다.

아이고 어려워 ^~^ b