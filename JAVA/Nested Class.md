## Nested Class

- Nested Class는 '중첩 클래스'라고 하며 클래스 내부에 위치하는 클래스를 뜻한다.

### Nested Class 장점

- 소스의 가독성이 높아지고, 유지보수가 용이해진다.
  - 외부 클래스와 중첩 클래스 코드의 위치가 가까워 유지 보수 및 가독성 향상에 도움이 된다.
- 클래스를 논리적으로 그룹화할 수 있다.
  - 중첩클래스는 외부클래스에 의해서만 사용되므로 논리적 그룹화가 가능하다.
- 캡슐화가 향상된다.
  - 중첩클래스는 외부클래스의 멤버이므로 은닉화하여 캡슐화에 도움이 된다.

### Nested Class 종류

- Nested Class는 아래와 같이 분류된다.

  1. Static Nested Class

  2. Non-Static Nested Class (Inner Class)

     2-1. Member Inner Class

     2-2. Local Inner Class

     2-3. Anonymous Inner Class



### 1. Static Class

- Static Nested Class는 '정적 중첩 클래스'라고 한다.
- Outer Class의 static 멤버만 사용이 가능하다.
- new 연산자를 통해 클래스를 생성하여 사용하여야 한다.

```java
//class
public class OuterClass {
    //static variable
    private static int number1 = 10;
    //non-static variable
    private int number2 = 20;   
    //static nested class
    static class StaticNestedClass{ 
        private int num = 10;
        public int multiple(int number){
            return number*num;
        }
        public void print(){
            //reference static variable
            System.out.println(multiple(number1)); 
            
            //reference non-static variable //Complie Error!
            //System.out.println(multiple(number2));  
        }
    }
}
//main
public class main {
    public static void main(String[] args) {
        //static nested class 생성
        OuterClass.StaticNestedClass test = new OuterClass.StaticNestedClass();
        test.print();
    }
}
//output
100
```



### 2 Non-Static Nested Class

- Non-Static Nested Class는 'Inner Class' 즉, '내부 클래스'라고 한다.
- Outer Class의 모든 멤버 사용이 가능하다.
- Static Nested Class를 제외한 Inner Class는 Non-Static Nested Class이다.



### 2-1 Member Inner Class

- Member Inner Class는 '멤버 클래스'라고 한다.

- new 연산자를 통해 생성된 Outer Class 객체를 통해 다시 new 연산자로 생성해야 한다.

```java
//class
public class OuterClass {

    private static int number1 = 10;    //static variable
    private int number2 = 20;   //non-static variable

    //member inner class
    class MemberInnerClass{
        private int num = 10;
        public int multiple(int number){
            return number*num;
        }
        public void print(){
            //reference static variable
            System.out.println(multiple(number1));
            //reference non-static variable
            System.out.println(multiple(number2));
        }
    }
}
//main
public class main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.MemberInnerClass test = outer.new MemberInnerClass();
        test.print();
    }
}
//output
100
200
```



### 2-2 Local Inner Class

- Local Inner Class는 '지역 클래스'라고 한다.
- 메소드 내부에 정의된 클래스이다.
- 메소드 내의 지역변수처럼 쓰인다.
- 메소드 내부에서 new 연산자를 통해 클래스를 생성하여 사용하여야 한다.
  (메소드 내부에서만 사용이 가능하다.)

```java
//class
public class OuterClass {

    private static int number1 = 1;    //static variable
    private int number2 = 2;   //non-static variable

    public void method(){
        //Local class in Method
        class LocalClass{
            private int num = 10;
            public int multiple(int number){
                return number*num;
            }
        }
        LocalClass local = new LocalClass();
        System.out.println(local.multiple(number1));
        System.out.println(local.multiple(number2));
    }
}
//main
public class main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.method();
    }
}
//output
10
20
```



### 2-3 Anonymous Inner Class

- Anonymous Inner Class는 '익명 클래스'라고 한다.
- Class와 Inheritance 함께 쓰여지는 것.
- 인스턴스 이름이 없다.
- new 연산자를 통해 생성 시, 상속을 받고, Over ride 하여 사용한다.
- 일회용으로 사용된다.

```java
//class
public class AnonymousClass {
    void method(){
        System.out.println("Original");
    }
}
//main
public class main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        AnonymousClass anonymous = new AnonymousClass(){
            @Override
            public void method() {
                System.out.println("Anonymous!");
            }
        };
        anonymous.method();
    }
}
//output
Anonymous!
```