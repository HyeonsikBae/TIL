## Constructor

### 생성자

생성자란,

객체를 생성할 때, 반드시 호출되고 제일 먼저 실행되는 일종의 메소드와 같은 것이다.

(메소드는 아니지만 굉장히 비슷하다)

- 생성자의 역할
  1. 객체 생성 시, 필드 초기화
  2. 객체 생성 시, 설정한 필드에 값을 넣어주어야만 객체 생성.
- 생성자의 특징
  1. return 타입이 없다.
  2. 생성자를 만들지 않으면, 컴파일할 때 기본생성자(매개변수가 없는 생성자)가 자동으로 만들어지게 된다.
  3. 생성자를 만들면 기본생성자는 만들어지지 않는다.



예시 코드를 통해 알아보자.

```java
public class Constructor {
	public static void main(String[] args) {
		smartphone myPhone = new smartphone();
		myPhone.view();
	}
}
class smartphone{
	String vendor;
	String kind;
	String number;
	int price;
    /*
    public smartphone(){
    }
    */
	public void view() {
		System.out.println("벤더 : " + this.vendor + "\n" + 
						   "기종 : " + this.kind + "\n" + 
						   "번호 : " + this.number + "\n" + 
						   "가격 : " + this.price + "\n");
    }
}
```

​	>> Output

```
벤더 : null
기종 : null
번호 : null
가격 : 0
```

위 코드는 생성자를 따로 만들지 않은 경우이다.

주석 내의 코드가 자동으로 생성되며,

smartphone 내 필드값이 없어도 객체 생성이 되는 것을 확인할 수 있다.

물론 필드값을 넣지 않았으므로, String 타입 변수 값은 null, int 타입 변수 값은 0이 출력된다.



생성자를 만들어 보도록 하자.

```java

public class Constructor {
	public static void main(String[] args) {
		smartphone myPhone = new smartphone("삼성","노트10",1100000);
		
		myPhone.view();
	}
}
class smartphone{
	String vendor;
	String kind;
	String number;
	int price;
	
	public smartphone(String vendor, String kind,int price) {
		this.vendor = vendor;
		this.kind = kind;
		setPrice(price);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void view() {
		System.out.println("벤더 : " + this.vendor + "\n" + 
						   "기종 : " + this.kind + "\n" + 
						   "번호 : " + this.number + "\n" + 
						   "가격 : " + this.price + "\n");
	}
}
```

smartphone 이라는 생성자를 만들어주었다!

주의해야 할 점은 생성자의 이름은 클래스 이름과 동일해야 한다는 것과, 그 앞엔 접근제어자만 올 수 있다는 점이다.

이 생성자의 변수엔 String vendor, String kind, int price가 있다.

이 세 종류의 필드값을 넣지 않으면 객체가 생성되지 않는다.

하지만 생성자의 매개변수가 아닌 String 타입 변수 number는 넣지 않아도 된다 ^~^