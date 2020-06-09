## List

- 데이터의 목록을 다루는 단순한 자료구조
- 데이터를 순차적으로 저장하여 선형 구조를 가지고 있다. [순서가 있는 데이터의 모임]
- C에서는 List를 지원하지 않아 직접 function을 만들거나 외부 라이브러리 include를 필요로 한다.
- Java, JavaScript, Python에서는 기본적으로 List를 제공하나, Python에선 배열은 지원하지 않는다.

### 기능

- 추가
  - List의 시작, 중간, 끝 인덱스에 데이터를 삽입
- 삭제
  - List의 시작, 중간, 끝 인덱스의 데이터를 삭제
- 접근
  - index를 통하여 데이터에 접근

### 분류

1. 구현 방식에 따른 분류

   1-1. Array List

   1-2. Linked List

1. 사용 방식에 따른 분류

   1-1. Simple List

   1-2. Doubly List

   1-3. Circular List

### Array List 구현 코드

```java
//ArrayList class
import java.util.Arrays;

public class ArrayListStudy {

    private int[] array = new int[0];

    //생성자. int형 배열 array를 매개변수로 받아 지역변수 int형 배열 array에 저장
    ArrayListStudy(int[] array){
        this.array = array;
    }

    //insert method
    //int형 매개변수 data를 List 마지막에 삽입
    public void insert(int data){
        int arraySize = array.length;
        int[] tempArray = new int[arraySize+1];
        for(int i=0;i<arraySize;i++){
            tempArray[i] = array[i];
        }
        tempArray[arraySize] = data;
        array = tempArray;
    }

    //insertIndex method
    //int형 매개변수 data를 List의 해당 index에 삽입
    public void insertIndex(int index, int data){
        int arraySize = array.length;
        int[] tempArray = new int[arraySize+1];
        for(int i=0;i<index;i++){
            tempArray[i] = array[i];
        }
        tempArray[index] = data;
        for(int i=index+1;i<arraySize+1;i++){
            tempArray[i] = array[i-1];
        }
        array = tempArray;
    }

    //delete method
    //List 마지막 data를 삭제
    public void delete(){
        int arraySize=array.length;
        int[] tempArray = new int[arraySize-1];
        for(int i=0;i<arraySize-1;i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    //delete method
    //List의 해당index 내에 있는 data를 삭제
    public void deleteIndex(int index){
        int arraySize=array.length;
        int[] tempArray = new int[arraySize-1];
        for(int i=0;i<index;i++){
            tempArray[i] = array[i];
        }
        for(int i=index;i<arraySize-1;i++){
            tempArray[i] = array[i+1];
        }
        array = tempArray;
    }

    //searchValue method
    //List에서 value값을 가지고 있는 index 출력
    public void searchValue(int value){
        int findValue = -1;
        for(int i=0;i<array.length;i++){
            if(array[i]==value){
                findValue = i;
                break;
            }
        }
        if(findValue == -1)
            System.out.println("List 내 "+value+"값은 없습니다.");
        else
            System.out.println(value+"값은 "+findValue+"번 인덱스에 있습니다.");
    }

    //searchIndex method
    //List에서 해당 Index가 가지고 있는 value 출력
    public void searchIndex(int index){
        if(index>=0 && index+1<=array.length)
            System.out.println(index+"번 인덱스의 값은 "+array[index]+"입니다.");
        else
            System.out.println(index+"번 인덱스는 존재하지 않습니다.");
    }

    //listSize method
    //List의 사이즈 출력
    public void listSize(){
        System.out.println("List Size : " + array.length);
    }

    //현재 List를 확인하기 위한 toString method Override
    @Override
    public String toString() {
        return "array=" + Arrays.toString(array);
    }
}
//main class
public class main {
    public static void main(String[] args) {

        int[] array = {1,3,4,5,6,9};
        ArrayListStudy arrayList = new ArrayListStudy(array);
        System.out.println(arrayList.toString());

        arrayList.insert(10);
        System.out.println(arrayList.toString());

        arrayList.insertIndex(2,7);
        System.out.println(arrayList.toString());

        arrayList.delete();
        System.out.println(arrayList.toString());

        arrayList.deleteIndex(3);
        System.out.println(arrayList.toString());

        arrayList.searchValue(5);
        arrayList.searchValue(11);

        arrayList.searchIndex(4);
        arrayList.searchIndex(7);

        arrayList.listSize();
    }
}
//Output
array=[1, 3, 4, 5, 6, 9]
array=[1, 3, 4, 5, 6, 9, 10]
array=[1, 3, 7, 4, 5, 6, 9, 10]
array=[1, 3, 7, 4, 5, 6, 9]
array=[1, 3, 7, 5, 6, 9]
5값은 3번 인덱스에 있습니다.
List 내 11값은 없습니다.
4번 인덱스의 값은 6입니다.
7번 인덱스는 존재하지 않습니다.
List Size : 6
```



