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
