import practico01.LinkedList;
import practico01.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> listaEnteros1 = new LinkedList<>();
        LinkedList<Integer> listaEnteros2 = new LinkedList<>();
        listaEnteros1.insertFront(4);
        listaEnteros1.insertFront(3);
        listaEnteros1.insertFront(7);
        listaEnteros1.insertFront(1);
        listaEnteros2.insertFront(3);
        listaEnteros2.insertFront(7);
        listaEnteros2.insertFront(15);
        listaEnteros2.insertFront(20);

        LinkedList<Integer> listaEnteros3 = createCommonLinkedList(listaEnteros1,listaEnteros2);
        System.out.println(listaEnteros3);
    }

    public static  <T> LinkedList createCommonLinkedList(LinkedList<T> list1, LinkedList<T> list2){
        LinkedList<T> pivotList;
        LinkedList<T> list;
        LinkedList<T> newList = new LinkedList<>();
        if (list1.size() > list2.size()){
            pivotList = list1;
            list = list2;
        }else {
            pivotList = list2;
            list = list1;
        }
        for (T i:pivotList){
            if (list.contains(i)){
                newList.insertFront(i);
            }
        }
        return newList;
    }
}
