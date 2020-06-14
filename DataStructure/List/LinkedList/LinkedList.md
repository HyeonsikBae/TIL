## Simple Linked List

- List Data Structure 의한 종류
- 노드의 연결로 이루어진 리스트

### Node

- 자료 구조의 일부분 하나하나.
- 데이터 지점을 의미한다.
- 데이터와 참조값(포인터)을 가진다.

### Simple Linked List 구조

![image-20200610235314642](C:\Users\gustl\AppData\Roaming\Typora\typora-user-images\image-20200610235314642.png)

### 기능

- 추가
  - List의 시작, 중간, 끝 인덱스에 데이터를 삽입
- 삭제
  - List의 시작, 중간, 끝 인덱스의 데이터를 삭제
- 접근
  - index 및 데이터를 통하여 데이터에 접근

### Linked List 구현 코드

```java
//Linked List Class
public class LinkedListStudy {

    private Node head;
    
    //Node class 생성
    //Data와 다음 Node를 가리키는 주소를 가진 클래스
    public class Node{
        Node next;
        String data;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    //리스트의 시작부분에 데이터 삽입
    public void insertHead(String data){
        Node headNode = new Node(data);
        headNode.next = head;
        head = headNode;
    }
    
    //리스트의 중간부분에 데이터 삽입
    public void insertBody(int number,String data){
        Node bodyNode = new Node(data);
        if(head==null) {System.out.println("Head Node가 없습니다.");}
        else{
            Node tempNode = head;
            for(int i=0;i<(number-1);i++) {
                tempNode = tempNode.next;
            }
            bodyNode.next = tempNode.next;
            tempNode.next = bodyNode;
        }
    }
    
    //리스트의 마지막부분에 데이터 삽입
    public void insertTail(String data){
        Node tailNode = new Node(data);
        if (head==null){
            head = tailNode;
        }
        else{
            Node tempNode = head;
            while(tempNode.next!=null){
                tempNode = tempNode.next;
            }
            tempNode.next = tailNode;
        }
    }
    
    //리스트의 시작부분 데이터 삭제
    public void deleteHead(){
        head = head.next;
    }
    
    //리스트의 중간부분 데이터 삭제
    public void deleteBody(int number){

        Node tempNode = head;
        for(int i=0;i<(number-1);i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
    }
    
    //리스트의 마지막부분 데이터 삭제
    public void deleteTail(){
        Node preTemp=null;
        Node temp = head;
        while(temp.next!=null){
            preTemp = temp;
            temp = temp.next;
        }
        preTemp.next = null;
    }
    
    //리스트 인덱스 번호로 검색
    public String search(int number){
        Node tempNode = head;
        for(int i=0;i<(number-1);i++) {
            tempNode = tempNode.next;
        }
        return tempNode.next.data;
    }
    
    //리스트 데이터로 검색
    public int searchIndex (String data){
        Node tempNode = head;
        int index = 0;

        while(!(tempNode.data.equals(data))){
            tempNode = tempNode.next;
            index++;
        }
        return index;
    }
    @Override
    public String toString() {
        if(head == null) {
            return "NULL";
        }
        else {
            Node temp = head;
            String str = "[";
            while(temp.next != null) {
                str += temp.data + ",";
                temp = temp.next; }
            if(temp.next==null){
                str+=temp.data;
            }
            return str + "]";
        }
    }
}

//main
public class main {
    public static void main(String[] args) {
        LinkedListStudy lls = new LinkedListStudy();
        lls.insertHead("c");
        System.out.println(lls.toString());
        lls.insertHead("b");
        System.out.println(lls.toString());

        lls.insertTail("e");
        System.out.println(lls.toString());

        lls.insertHead("a");
        System.out.println(lls.toString());

        lls.insertBody(3,"d");
        System.out.println(lls.toString());

        System.out.println(lls.search(1));
        System.out.println(lls.searchIndex("e"));

        lls.deleteHead();
        System.out.println(lls.toString());

        lls.deleteTail();
        System.out.println(lls.toString());

        lls.deleteBody(1);
        System.out.println(lls.toString());
    }
}

//Output
[c]
[b,c]
[b,c,e]
[a,b,c,e]
[a,b,c,d,e]
b
4
[b,c,d,e]
[b,c,d]
[b,d]
```



