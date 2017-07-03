package ru.academit.list.SinglyLinkedList;

public class SinglyLinkedList<T> {
    private ListItem<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public SinglyLinkedList(T data) {
        head = new ListItem<T>(data);
    }

    public int getLength() {
        int length = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            ++length;
        }
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
            throw new IllegalArgumentException("Элемента с таким индексом нет");
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
    }

    public void insertAfterNode(ListItem<T> node, T data) {
        if (node == null) {
            insertToBegin(data);
        }
        if (node.getNext() == null) {
            ListItem<T> p = new ListItem<T>(data);
            node.setNext(p);
            return;
        }
        ListItem<T> p = new ListItem<>(data);
        p.setNext(node.getNext());
        node.setNext(p);
    }

    public T deleteHead() {
        T headData = head.getData();
        head = head.getNext();
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
        return deleteData;
    }

    public T deleteAtData(T data) {
        ListItem<T> p;
        boolean research = false;
        int i = 0;
        for (p = head; p != null; p = p.getNext(), ++i) {
            if (p.getData() == data) {
                research = true;
                break;
            }
        }
        if (!research) {
            throw new IllegalArgumentException("Элемента с таким значением нет");
        }
        return deleteAtIndex(i);
    }

    public void deleteAfterNode(ListItem<T> node) {
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Нет элемента, после указанного");
        }
        node.setNext(node.getNext().getNext());
    }

    public void reverse() {
        if (getLength() == 0) {
            throw new IllegalArgumentException("Список пуст");
        }
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