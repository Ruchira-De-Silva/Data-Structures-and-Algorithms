package data_structures.linked_list.singly;

public class Main {
    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();
        list.insert(1);
        list.insert(2);
        list.insertAtStart(3);
        list.show();
        System.out.println();
        System.out.println(list.head.value);
    }
}