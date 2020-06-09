## Polymorphism

다형성



서브클래스들을 관리하는 경우를 보도록 하자.

```java
//클래스 선언
public class Child{
    public void method(){
        System.out.println("자식");
    }
}
public class Boy extends Child{
    public void method(){
        System.out.println("아들");
    }
    public void example(){
        System.out.println("Boy클래스만 가지는 method");
    }
}
public class Girl extends Child{
    public void subMethod(){
        System.out.println("딸");
    }
}
```

```java
//Boy, Girl 클래스들을 각각 선언
public class main {
	public static void main(String[] args) {
        Boy boy[] = new Boy[3];		// 배열 할당
        Girl girl[] = new Girl[3];	// 배열 할당
        
        //생성 시, 순서가 어떻게 될 지 모름.
        girl[0] = new Girl();
        girl[1] = new Girl();
        boy[0] = new Boy();
        girl[2] = new Girl();
        boy[1] = new Boy();
        boy[2] = new Boy();
        //출력은 생략하겠다.
    }
}
```

```java
//
public class main {
	public static void main(String[] args) {
        Child child[] = new Child[6];	//배열 할당
        
        //생성 시, 배열 순으로 생성 가능.
        child[0] = new Girl();
        child[1] = new Girl();
        child[2] = new Boy();
        child[3] = new Girl();
        child[4] = new Boy();
        child[5] = new Boy();
        
        //처리 시에도 반복문 사용하기 좋음.
        for(int i=0;i<child.length;i++){
            child[i].method();
        }
    }
}
```

```
>>Output
딸
딸
아들
딸
아들
아들
```

위 코드와 같이 Boy, Girl의 서브클래스들을 Child라는 슈퍼클래스로 선언하여 하나로 관리가 가능하다.

하지만!

Boy, Girl class 내의 method()는 오버라이딩 된 것으로 Child로 생성해도 처리가 가능했지만,

Boy class내 example method같은 경우엔 사용할 수 없다.

이를 사용하려면 다음과 같은 캐스팅이 필요하다.

```java
// 1번째 방법
Boy boy = (Child)child[5];
boy.example();
// 2번째 방법
((Boy)child[5]).example();
```



이렇게 배열 형태의 객체들을 캐스팅을 하려고 할 때, 해당 객체가 어떤 클래스로부터 생성된 것인지 구별을 하고 싶을 수도 있다.

그럴 땐 instance를 사용해 구별이 가능하다.

```java
public class main {
	public static void main(String[] args) {
        Example array[] = { new Exam1, new Exam2, new Exam3 };
        for(int i=0;i<array.length;i++){
            instance(array[i]);
        }
        public void instance(Example array){
            if(array instanceOf Exam1) ((Exam1)array).method();
            //array 
            else if(array instanceOf Exam2) ((Exam2)array).method();
            else if(array instanceOf Exam3) ((Exam3)array).method();
        }
    }
}
```

