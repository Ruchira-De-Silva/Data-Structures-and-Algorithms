// Source code is decompiled from a .class file using FernFlower decompiler.
package data_structures.linked_list.doubly;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {
        LinkedList var1 = new LinkedList();
        var1.insert(1);
        var1.insert(2);
        var1.insertAtStart(3);
        var1.show();
        var1.insertAt(6, 2);
        var1.show();
        System.out.println();
        // System.out.println(var1.head.value);
    }
}
