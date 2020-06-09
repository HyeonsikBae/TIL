## try catch

다들 프로그래밍 실행 중, Exception 을 본 적이 있을 것이다.

Exception 이란 예외상황을 뜻한다.

임의의 배열에 10개의 인덱스가 있다고 가정해보자.

인덱스 번호는 0부터 9까지일 것이다.

하지만 존재하지 않는 10번 인덱스에 접근하는 것이 Exception 중 하나이다.

Exception 을 넘어가려면, 혹은 어디서 Exception 이 발생했는지 알고 싶을 때 try catch문을 사용할 수 있다.



try catch 문의 문법부터 알아보도록 하자.

```java
try{
    기본 실행문;
}catch(Exception1 e){
    Exception1 발생 시 실행문;
}catch(Exception2 e){
    Exception2 발생 시 실행문;
}catch(Exception3 e){
    Exception3 발생 시 실행문;
}finally{
    무조건!!실행되는 실행문;
}
```

try 내부의 기본 실행문을 실행 중에, Exception이 발생되면 해당 catch로 넘어간다.

