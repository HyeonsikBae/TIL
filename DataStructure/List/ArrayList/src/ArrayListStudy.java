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