## Inheritance

### 상속



우리가 흔히 말하는 '상속'이란,

일반적으로 부모가 자식에게 재산을 물려주는 것을 일컫는다.

자바에서 말하는 '상속'이란,

__부모클래스가 자식클래스에게 변수/메소드를 물려주는 것__을 의미한다.

하지만 하나의 부모클래스로부터만 __단일 상속__ 해야 한다는 점 잊지 말도록 하자

이게 전부다.



```java
public class Superclass{} // SuperClass(부모)가 생성되어 있는 상태라고 가정해보자.
public class Subclass extends Superclass{} // SubClass(자식) 생성 완료!
```

상속을 할 때는 클래스를 선언할 때, __extends SuperClass__ 를 붙여주도록 하자.

이제 SubClass는 SuperClass의 모든 멤버 변수와 메소드를 이용할 수 있다.

​	☆ private 멤버는 상속되지 않는다 ☆



아래 코드로 간단한 예시를 들어보도록 하자.

```java
//	1. Superclass
public class Animal {
	String spieces;
	public void spieces() {
		System.out.println("이 동물은 " + this.spieces + "입니다.");
	}
	public void setSpieces(String spieces) {
		this.spieces = spieces;
	}
}

//	2. Subclass[1]
public class Dog extends Animal{
	String type;
	public void type() {
		System.out.println("이 " + this.spieces + "은 " + this.type + "입니다.");
	}
	public void setType(String type) {
		this.type = type;
	}
}

//3. Subclass[2]
public class Cat extends Animal{
	String type;
	public void type() {
		System.out.println("이 " + this.spieces + "은 " + this.type + "입니다.");
	}
	public void setType(String type) {
		this.type = type;
	}
}

//4. mainclass
package inheritance;

public class mainClass {

	public static void main(String[] args) {
		
		Animal Puppy = new Dog();
		Puppy.spieces = "개";
		//Puppy.type = "불독";
		
		Cat Kitty = new Cat();
		Kitty.spieces = "고양이";
		Kitty.type = "러시안블루";
		
		Puppy.spieces();
		//Puppy.type();
		Kitty.spieces();
		Kitty.type();
	}
}   
```

​	>> Output

```
이 동물은 개입니다.
이 동물은 고양이입니다.
이 고양이은 러시안블루입니다.
```

위에서 Animal class는 SuperClass이다.

Animal class를 상속하는 Dog class가 있고, Animal class를 상속하는 Cat class가 있다.

main class 에서 이를 통해 새로운 객체를 인스턴스화 해 보았다.

```java
Animal Puppy = new Dog();
Cat Kitty = new Cat();
```

둘의 차이는 무엇일까?

Puppy 는 SuperClass인 Animal 클래스의 객체이고, Kitty 는 SubClass인 Cat 클래스의 객체이다.

Kitty는 SuperClass 내부의 spieces 필드, 메소드와 SubClass 내부의 type 필드, 메소드 모두 사용을 하고 있다.

예제 코드에서 주석처리한 코드를 보면 Dog 클래스에서 선언된 type 필드와 메소드이다.

Puppy 는 Animal 클래스의 객체이기 때문에 SubClass의 필드와 메소드를 사용하지 못 하는 것이다.

이렇듯 SuperClass는 SubClass의 필드와 메소드를 사용하지 못함을 알 수 있다.



이것이 상속의 기본적인 개념이고, 오버라이드도 참고해 보도록 하자 :D