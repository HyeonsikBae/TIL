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