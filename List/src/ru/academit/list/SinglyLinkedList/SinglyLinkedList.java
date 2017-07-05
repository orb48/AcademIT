package ru.academit.list.SinglyLinkedList;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int length;

    public SinglyLinkedList() {
        head = null;
        length = 0;
    }

    public SinglyLinkedList(T data) {
        head = new ListItem<T>(data);
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public T getDataAtIndex(int index) {
        return getNodeAtIndex(index).getData();
    }

    public T setDataAtIndex(int index, T data) {
        ListItem<T> p = getNodeAtIndex(index);
        T old = p.getData();
        p.setData(data);
        return old;
    }

    public ListItem<T> getNodeAtIndex(int index) {
        if (index < 0 || index >= getLength()) {
            throw new IllegalArgumentException("Индекс выходит за пределы списка");
        }
        int i = 0;
        ListItem<T> p;
        for (p = head; p != null; p = p.getNext(), ++i) {
            if (i == index) {
                break;
            }
        }
        return p;
    }

    public void insertToBegin(T data) {
        ListItem<T> p = new ListItem<>(data);
        p.setNext(head);
        head = p;
        ++length;
    }

    public void insert(int index, T data) {
        if (index == 0) {
            insertToBegin(data);
            return;
        }
        if (index < 0 || index >= getLength()) {
            throw new IllegalArgumentException("Элемента с таким индексом нет");
        }
        ListItem<T> p = getNodeAtIndex(index - 1);
        ListItem<T> q = new ListItem<>(data);
        q.setNext(p.getNext());
        p.setNext(q);
        ++length;
    }

    public void insertAfterNode(ListItem<T> node, T data) {
        if (node == null) {
            insertToBegin(data);
        } else if (node.getNext() == null) {
            ListItem<T> p = new ListItem<T>(data);
            node.setNext(p);
        } else {
            ListItem<T> p = new ListItem<>(data);
            p.setNext(node.getNext());
            node.setNext(p);
        }
        ++length;
    }

    public T deleteHead() {
        if (head == null) {
            throw new IllegalArgumentException("Список пуст");
        }
        T headData = head.getData();
        head = head.getNext();
        --length;
        return headData;
    }

    public T deleteAtIndex(int index) {
        if (index == 0) {
            return deleteHead();
        }
        if (index < 0 || index >= getLength()) {
            throw new IllegalArgumentException("Элемента с таким индексом нет");
        }
        ListItem<T> p = getNodeAtIndex(index - 1);
        T deleteData = p.getNext().getData();
        ListItem<T> q = p.getNext();
        p.setNext(q.getNext());
        --length;
        return deleteData;
    }

    public boolean delete(T data) {
        ListItem<T> p;
        boolean research = false;
        if (head.getData() == data) {
            deleteHead();
            research = true;
            return true;
        }
        for (p = head; p.getNext() != null; p = p.getNext()) {
            if (p.getNext().getData() == data) {
                p.setNext(p.getNext().getNext());
                research = true;
                return true;
            }
        }
        if (!research) {
            throw new IllegalArgumentException("Элемента с таким значением нет в списке");
        }
        --length;
        return false;

    }

    public void deleteAfterNode(ListItem<T> node) {
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Нет элемента, после указанного");
        }
        node.setNext(node.getNext().getNext());
        --length;
    }

    public void reverse() {
        if (getLength() == 1) {
            return;
        }
        ListItem<T> p, q;
        for (p = head, q = p.getNext(); q != null; ) {
            ListItem<T> nextNode = q.getNext();
            q.setNext(p);
            p = q;
            q = nextNode;
        }
        head.setNext(null);
        head = p;
    }

    public SinglyLinkedList<T> copy() {
        if (length == 0) {
            return new SinglyLinkedList<T>();
        }
        SinglyLinkedList<T> list = new SinglyLinkedList<T>();
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            list.insertToBegin(p.getData());
        }
        list.reverse();
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            sb.append(p.getData());
            if (p.getNext() != null) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}