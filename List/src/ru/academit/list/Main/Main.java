package ru.academit.list.Main;

import ru.academit.list.SinglyLinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2);
        list.insertToBegin(3);
        list.insertToBegin(1);
        list.insertToBegin(11);
        list.insertToBegin(21);
        list.insertToBegin(19);

        System.out.println(list);
        SinglyLinkedList<Integer> listCopy = list.copy();
        System.out.println(listCopy);
        list.delete(2);
        System.out.println(list.getLength());

        SinglyLinkedList<Integer> listList = new SinglyLinkedList<>();
        listList.insertToEnd(1);
        System.out.println(listList);
/*
        list.insert(0, 1000);
        list.insert(0, 101);
        list.insert(1, 196);

        System.out.println("Удалили первый элемент: " + list.deleteHead());
        System.out.println("Удалили элемент: " + list.deleteAtIndex(2));
        System.out.println(list);
        System.out.println("Удалить узел по значению: " + list.delete(2));

        list.insertAfterNode(list.getNodeAtIndex(1), 111);
        list.deleteAfterNode(list.getNodeAtIndex(1));
        System.out.println(list);
        list.reverse();
        System.out.println(list);*/
    }
}
