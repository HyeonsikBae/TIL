## Class

- 클래스

클래스는 같은 특징을 가진 객체의 속성을 묶어 놓은 집합체이다.

예를 들어, '고양이' 라는 클래스가 있다면 이를 통해 '러시안블루', '스코티쉬 폴드','터키쉬 앙고라' 등의 객체들을 생성할 수 있다.

클래스의 구성은  '필드'와 '메소드'로 이루어진다.

>필드 : 객체의 상태를 나타는 변수
>
>메소드 : 객체의 행동을 나타내는 명령문

아래 예문을 통해 클래스에 대해 더 자세히 알아보겠다.

```java
public class ClassStudy{
    public static void main(String[] args){
        Cat RussianBlue = new Cat(); // Cat 클래스를 통해 RussianBlue 객체 생성
    }
}
class Cat{ // Cat class 생성.
}
```

__Cat 클래스__를 생성하고, __RussianBlue 객체__를 생성해보았다.

클래스를 통해 만들어진 객체를 인스턴스라고도 하는데, 객체와 인스턴스에는 약간의 차이가 있다.

'인스턴스'란 아래 예시와 같이 객체가 어떤 클래스의 객체인지 설명할 때 사용된다.

ex) RussianBlue는 __객체__이다

ex) RussianBlue는 __Cat 클래스의 인스턴스__이다.

Cat 클래스 내의 메소드는 해당 클래스를 통해 생성된 모든 인스턴스가 공유하고,

인스턴스는 독립된 메모리에 자신만의 필드(변수)를 가지게 된다.



위 코드에서, Cat class는 위의 ClassStydy class와는 다르게 public이 붙지 않는데,

이는 하나의 java 파일에는 하나의 public class 만이 존재할 수 있기 때문이다.

public에 관해서는 추후 접근제어자에서 더욱 자세히 다루겠다.



이제 클래스 내에 필드를 넣어보도록 하겠다.

```java
public class ClassStudy{
    public static void main(String[] args){
        Cat RussianBlue = new Cat();
        
        RussianBlue.name = "고영희"; // RussianBlue 객체의 name 필드에 "고영희" 삽입
        RussianBlue.age = 3; // RussianBlue 객체의 age 필드에 3 삽입
        RussianBlue.favorite = "츄르"; // RussianBlue 객체의 favorite 필드에 "츄르" 삽입
        
        //객체 내 필드 출력하여 확인
        System.out.println(RussianBlue.name);
        System.out.println(RussianBlue.age);
        System.out.println(RussianBlue.favorite);
    }
}
class Cat{
    String name; // String 타입 name 필드 선언
    int age; // int 타입 age 필드 선언
    String favorite; // String 타입 favorite 필드 선언
}
```

Output>>

```
고영희
3
츄르
```

Cat 클래스 내 변수를 선언하였다.

이것이 클래스의 필드이고, 클래스를 통해 인스턴스화 된 객체들은 이 필드를 공유하게 된다.

이 필드에 접근할 때는 __객체명.필드명__으로 접근할 수 있다.



이제 클래스에 메소드를 넣어보자.

```java
public class ClassStudy{
    public static void main(String[] args){
        Cat RussianBlue = new Cat();
        
        RussianBlue.name = "고영희";
        RussianBlue.age = 3;
        RussianBlue.favorite = "츄르";
        
        RussianBlue.eat();
    }
}
class Cat{
    String name;
    int age;
    String favorite;
    void eat(){ // 메소드 생성
        System.out.println(this.age + "살 " + this.name + "는 "
                           + this.favorite + "를 먹었다.");
    }
}
```

Cat 클래스 내에 eat 이란 메소드를 만들어보았다.

클래스 내에서 생성한 메소드 또한 호출이 가능하다.

필드와 마찬가지로 __객체명.메소드명__으로 호출이 가능하다.

메소드 내에 this. 로 표현된 것이 있는데 해당 클래스의 멤버 변수를 사용한다는 것이다.



아래의 코드를 보도록 하자.

```java
public class ClassStudy{
    public static void main(String[] args){
        Cat RussianBlue = new Cat();
        RussianBlue.setCat("고영희",3,"캣닢");
        RussianBlue.eat();        
    }
}
class Cat{
    
	String name;
	int age;
	String favorite;
	
	public void setCat(String name, int age, String favorite){
	this.name = name;
	this.age = age;
	this.favorite = favorite;
	}
	
    void eat(){ // 메소드 생성
        System.out.println(this.age + "살 " + this.name + "는 "
                           + this.favorite + "를 먹었다.");
    }
}
```

setCat 메소드를 통해 입력되는 __"고영희",3,"캣닢"__은 객체 __RussianBlue의 필드__에 저장된다.

메소드는 RussianBlue에 의해 호출되었고, 메소드 내의 this. 는 메소드를 호출한 객체를 의미한다.

이렇듯 this를 통해 해당 변수가 일반 변수와 클래스의 멤버 변수를 구분짓게 해 준다.



클래스를 통해 우리는 같은 포맷의 객체를 편하게 생성할 수 있다.

예를 들어, 게임 캐릭터도 일일이 생성하는 게 아니라 필드값만 설정하여 생성할 수 있는 것이다.

참 편하구나 ^~^ b