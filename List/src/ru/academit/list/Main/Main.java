package ru.academit.list.Main;

import ru.academit.list.SinglyLinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2);
        list.insertToBegin(3);
        list.insertToBegin(1);
        list.insertToBegin(11);
        list.insert(0, 1000);
        list.insert(0, 101);
        list.insert(1, 196);

        System.out.println("Удалили первый элемент: " + list.deleteHead());
        System.out.println("Удалили элемент: " + list.deleteAtIndex(2));
        System.out.println(list);
        System.out.println("Удалить узел по значению: " + list.deleteAtData(2));

        list.insertAfterNode(list.getNodeAtIndex(1), 111);
        list.deleteAfterNode(list.getNodeAtIndex(1));
        System.out.println(list);
        list.reverse();
        System.out.println(list);

        SinglyLinkedList<Integer> listCopy = new SinglyLinkedList<>();
//        System.out.println(listCopy.copy(list));
    }
}
