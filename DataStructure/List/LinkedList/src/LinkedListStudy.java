public class LinkedListStudy {

    private Node head;

    public class Node{
        Node next;
        String data;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
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
    public void insertHead(String data){
        Node headNode = new Node(data);
        headNode.next = head;
        head = headNode;
    }
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
    public void deleteHead(){
        head = head.next;
    }
    public void deleteTail(){
        Node preTemp=null;
        Node temp = head;
        while(temp.next!=null){
            preTemp = temp;
            temp = temp.next;
        }
        preTemp.next = null;
    }
    public void deleteBody(int number){

        Node tempNode = head;
        for(int i=0;i<(number-1);i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
    }
    public String search(int number){
        Node tempNode = head;
        for(int i=0;i<(number-1);i++) {
            tempNode = tempNode.next;
        }
        return tempNode.next.data;
    }
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