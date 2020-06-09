## Array List 

C언어에서 열심히 사용해왔던 Array!

하지만 JAVA에는 Array List라는 굉장히 편한 것이 있다고 한다.

Array List 의 장점으로는,

1. 메모리 할당 불필요!
   - 데이터를 추가하면 메모리가 늘어나고, 삭제하면 메모리가 줄어든다
2. 데이터 갱신이 쉽다!
   - Array List의 처음이나 중간에 데이터 삽입, 삭제가 쉽다.
     - 이럴 경우, 뒤의 데이터들이 수정된 인덱스만큼 이동한다.
3. 타입 안정성을 보장할 수 있다.
   - Generics를 사용하여 타입 안정성 보장이 가능하다.

하지만 단점도 있다.

1. Object Element 만 사용 가능
   - Array는 Primitive, Object type 모두 담을 수 있지만, Array List는 Object Element만 담을 수 있다.
2. 데이터 갱신 시 느리다..
   - 앞에서 데이터가 갱신될 때, 뒤의 데이터들이 이동한다고 하였다. 매 갱신마다 이동하는 것이기에 사용을 편리하지만 속도는 느리다.
3. 크기 한정
   - 크기가 한정되어 있어 포화 상태에 이를 수 있다.
   - 크기 재조정 연산이 가능하지만, 연산량이 어마어마하다



ArrayList 사용 예제

- 선언

```java
ArrayList<T> name = new ArrayList<T>();
//<T> : Generic. Object Element가 들어간다.
//name : ArrayList 변수이름
```

```java
//Example
ArrayList<String> player = new ArrayList<String>();
ArrayList<Integer> number = new ArrayList<Integer>();
```

- 추가

```java
ArrayListName.add(Object);
// Object 값을 ArrayList 마지막에 추가한다.
ArrayListName.add(Index, Object);
//Object 값을 ArrayList의 Index 위치에 추가한다. 뒤에 있는 값은 1칸씩 밀린다.
```

```java
//Example
//ArrayList<String> Language = ["JAVA", "C", "Python"]
Language.add("JavaScript");
//ArrayList<String> Language = ["JAVA", "C", "Python", "JavaScript"]
Language.add(1,"C++");
//ArrayList<String> Language = ["JAVA", "C++", C", "Python", "JavaScript"]
```

- 삭제

```java
ArrayListName.remove(Index);
//ArrayList의 Index Number에 해당하는 객체를 삭제한다.
ArrayListName.remove(Object);
//ArrayList의 Object를 찾아 객체를 삭제한다.
```

```java
//Example
//ArrayList<String> Language = ["JAVA", "C", "Python"]
Language.remove(0);
//ArrayList<String> Language = ["C", "Python"]
Language.remove("C");
//ArrayList<String> Language = ["Python"]
```

- 수정

```java
ArrayListName.set(Index,Object);
//ArrayList의 Index Number에 해당하는 객체를 Object로 변경한다.
```

```java
//Example
//ArrayList<String> Language = ["JAVA", "C", "Python"]
Language.set(1,"C#");
//ArrayList<String> Language = ["JAVA", "C#", "Python"]
```



- 검색

ArrayList에서 검색을 할 경우, Wrapper가 아닌 Object를 사용하는 경우가 많다.

이런 경우엔 ArrayList에 있는 Object를 꺼내서 검색하는 것이 좋은데, 이런 상황에서 위에 나온 메소드들까지 적용하여 코드를 작성해보도록 하겠다.

```java
class Member{
    private int number;
    private String name;
    Member(int number, String name){
        this.number = number;
        this.name = name;
    }
}
main class{
    public static void main(String[] args){
        ArrayList<Member> memberList = new ArrayList<Member>();
        Member mem1 = new Member(1,"루피");
        memberList.add(mem1);
        memberList.add(new Member(2,"쵸파"));
    }
}
```





이제 Array List 를 사용해보도록 하자.

```java
ArrayList food = new ArrayList();
```

ArrayList __'food'__를 만들었다!

ArrayList 내에 음식들을 넣어보겠다.

데이터 삽입의 형식은 이렇다.

```
ArrayList명.add(삽입할 데이터);
```

```java
ArrayList food = new ArrayList();

String food1 = "라볶이";
String food2 = "김밥";
int food3 = 35;
String food4 = "라면";

food.add(food1);
food.add(food2);
food.add(food3);
food.add(food4);

System.out.println(food);
```

​	\>\>Output

```
[라볶이, 김밥, 35, 라면]
```

????

실수로 int형을 삽입해버리고 말았다...

그렇다. ArrayList는 변수의 타입에 관계없이 삽입이 가능하다.

하지만!

food Array List내엔 String 타입의 음식만을 넣고 싶다..

이렇게 수정해보도록 하자.

```java
ArrayList<String> food = new ArrayList<String>();
```

이제 String 타입이 아닌 변수를 넣으면 오류가 나오게 된다.

<> 내에는 Object Element만 올 수 있다.

예를 들면 int가 아니라 Integer를 써야 한다는 점!



마저 food를 채우러 가 보자.

```java
ArrayList<String> food = new ArrayList<String>();

String food1 = "라볶이";
String food2 = "치킨"; //...?
String food3 = "라면";
String food4 = "김밥";

food.add(food1);
food.add(food2);
food.add(food3);
food.add(food4);
//Output >> [라볶이, 치킨, 라면, 김밥]
//분식 사이에 치느님이라니... 삭제해주자.. 1번 인덱스..
food.remove(1); 
// food.remove("치킨")으로 Array List 내 맨 앞의 치킨을 없앨 수도 있다.
//Output >> [라볶이, 라면, 김밥]
//인덱스가 앞으로 하나씩 당겨진 걸 확인할 수 있다.
```

```java
//ArrayList food 내의 값 : [라볶이, 라면, 김밥]

ArrayList<String> 분식 = new ArrayList<String>();
분식.addAll(food);
//Output >> [라볶이, 라면, 김밥]
//???? 그렇다. 다른 Array List를 통째로 가져와버렸다 하하
```

이렇게 분식집이 완성되었다!

배가 고프니 분식집에 가보자



난 돈가스가 먹고 싶어! 돈까스 줘!

```java
System.out.println(분식.contains("돈까스"));
//Output >> false
```

돈까스가 없구나..

그럼 이 분식집에는 몇 가지 요리가 있을까?

```java
System.out.println(분식.size());
//Output >> 3
```

흠.. 0번, 1번, 2번 인덱스 총 3가지의 요리가 있구나

아.. 난 1번 인덱스에 있는 분식이 먹고 싶어..

1번 인덱스에 있는 분식 줘!

```java
System.out.println(분식.get(1));
//Output : 라면
```



앗..분식집이 장사가 잘 안되는지 리뉴얼에 들어갔다고 한다.

```java
분식.set(2,"돈까스");			// 2번 인덱스의 "김밥"을 "돈까스"로 대체
							// [라볶이, 돈까스, 김밥]
분식.add(1,"냉면"); 			// 인덱스 중간인 1번 인덱스에 "냉면" 삽입! 
							// [라볶이, 냉면, 라면, 돈까스]
```



오늘도 라면이 먹고 싶구나. 라면은 몇 번째에 있는 음식이었지? 

```java
System.out.println(분식.indexOf("김밥"));
//Output >> 2
```

3번째인 2번 인덱스에 있구나~

혹시 그 다음 메뉴도 나왔는지 궁금한데..

사장님 3번째 메뉴 뒤에 다른 메뉴가 더 있나요? 있으면 뭔지 알려주세요~

```java
Iterator<String> iter = 분식.iterator();	// Iterator를 통한 메뉴(값)에 접근해보자
while(iter.hasNext())	//	다음 값이 있는지 보면서
System.out.print(iter.next());	//	다음값 있으면 출력해주도록 하지
//Output >> 라볶이냉면라면돈까스
```

분식집 메뉴라 __라볶이냉면라면돈까스__ 로 바뀌었구나

김밥 맛집이었는데..



```java
분식.clear();
```

????

아닛 ... Array List를 비워버리는 clear.

분식집이 망했다.

정말 망했니?

```java
boolean real = 분식.isEmpty();
System.out.println(real);
//Output >> true
```

그렇다.

Array List를 배우는 동안 분식집은 망해버렸다.

분식집과 함께 ArrayList를 알아보았다.

실제 코드를 짜며 학습하는 부분이 나온다면 다른 분식집을 또 찾아보도록 하겠다.