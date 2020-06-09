## 랜덤변수 생성

야구 게임, 트럼프카드 셔플 프로그램 등을 만들며 중복되지 않는 랜덤변수를 입력하는 기능을 다루어보았다.

기존에 사용하였던 방법보다 시간복잡도가 적은 방법을 보게 되었고 이를 정리해보려 한다.



1. 인덱스 내 수를 비교하여 랜덤변수 넣는 방법

```java
final static int NUMBER_SIZE = 10;
final static int RANDOM_SIZE = 3;

Random random = new Random();
int randomNumber[] = new int[RANDOM_SIZE];

for(int i=0;i<RANDOM_SIZE;i++){
    randomNumber[i] = random.nextInt(NUMBER_SIZE)+1;
    //int array randomNumber에 랜덤변수 삽입
    for(int j=0;j<RANDOM_SIZE;j++){
        if(randomNumber[i]==randomNumber[j] && i!=j){
            //인덱스 번호는 다르나 랜덤변수 값이 같으면,
            i--;
            //반복횟수를 늘리고 해당 인덱스에 랜덤변수를 다시 넣는다.
        }
    }
}
```



2. Boolean 을 사용하여 공통된 랜덤변수 넣는 방법

```java
final static int NUMBER_SIZE = 10;
final static int RANDOM_SIZE = 3;

Random random = new Random();
int randomNumber[] = new int[RANDOM_SIZE];
boolean check[] = new boolean[NUMBER_SIZE];

for(int i=0;i<NUMBER_SIZE;i++){
    check[i] = false;
}
//boolean array check가 모두 false가 됨. > 00000 00000

for(int i=0;i<RANDOM_SIZE;i++){
    int randomCount = random.nextInt(10);
    // 임의의 변수 randomCount에 랜덤값 입력
    // ex) 랜덤값 3
    if(check[randomCount]==false){
        // boolean array check 내 randomCount 번째 수가 false 이면
        // ex) check[3]는 4번째 수 00000 0!000
    	randomNumber[i] = random+1;
        // int array randomNumber 에 랜덤값+1 삽입
        check[randomCount]=true;
        // 해당 boolean true 삽입
	}
    else{
        i--;
        //boolean값이 true이면 중복되는 수이므로 랜덤변수를 새로 뽑는다.
    }
}

```



기존에 랜덤변수 생성을 위해 작성한 코드는 1번이다.

1번 코드는 해당 인덱스와 다른 모든 인덱스와 값을 비교하여 중복을 확인한다.

이에 비해 2번 코드는 들어갈 값이 기존에 있는 값인지를 판별한다.

비록 boolean 배열을 생성해야 하지만 시간복잡도가 확실히 높아짐을 확인할 수 있다.

아래는 이를 이용한 트럼프 카드 셔플 예제코드이다.

```java
public static final int SELECT_NUMBER = 3; // 뽑을 카드 수
public static final int CARD_NUMBER = 52; // 트럼프 카드 종류 수

Random random = new Random();
boolean check[] = new boolean[CARD_NUMBER];
//랜덤변수 체크를 위한 boolean 배열 선언
int card[] = new int[SELECT_NUMBER];
//뽑을 카드를 저장한 int 배열 선언
int cardCheck = 0;
//boolean 배열 인덱스 체크를 위해 사용할 int 변수 선언

for(int i=0;i<CARD_NUMBER;i++) {
	check[i] = false;
}//boolean 배열에 모두 false 값 입력

for(int i=0;i<card.length;i++) {
	cardCheck = random.nextInt(CARD_NUMBER);
    //cardCheck 변수에 랜덤변수 삽입. 0~51의 수.
	if(check[cardCheck]==false) {
        //boolean 배열 내 cardCheck번째 인덱스의 값 중복 유무 확인
		card[i] = cardCheck + 1;
        //card 배열에 랜덤변수 삽입. 1~52의 수.
		check[cardCheck] = true;
        //삽입한 값에 해당하는 boolean 배열의 인덱스 값을 true로 변경.
        //이는 해당 값이 이미 있다는 것을 의미하게 된다.
	}
	else {
		i--;
        //중복이 있는 경우 다시 한 번 랜덤변수를 뽑기 위해 반복을 1회 늘린다.
	}
}
for(int i=0;i<SELECT_NUMBER;i++) {
	if(card[i]<=13) {//1~13의 값.
		System.out.println("♠ " + (card[i]));
	}
	else if(card[i]<=26) {//14~26의 값.
		System.out.println("◆ " + (card[i]-13));
	}
	else if(card[i]<=39) {//27~39의 값.
		System.out.println("♥ " + (card[i]-26));
	}
	else{//39~ 의 값.
		System.out.println("♣ " + (card[i]-39));
	}
}
/*
// 아래와 같은 코드로도 랜덤변수를 트럼프 카드 형식으로 출력이 가능하다.
for(int i=0;i<card.length;i++) {
	switch(card[i]/13) {
	//13으로 나눈 값은 0 ~ 3의 값을 가지게 된다.
	//값은 모양, 나머지는 숫자로 표기.
		case 0:
			System.out.println("♠ " + (card[i]%13));
			break;
		case 1:
			System.out.println("◆ " + (card[i]%13));
			break;
		case 2:
			System.out.println("♥ " + (card[i]%13));
			break;
		case 3:
			System.out.println("♣ " + (card[i]%13));
			break;
	}
}
*/
```



