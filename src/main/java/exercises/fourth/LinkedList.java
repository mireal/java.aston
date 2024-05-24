package exercises.fourth;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class LinkedList<E> implements Collection<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    LinkedList() {
        size = 0;
    }

    LinkedList(E e) {
        this();
        addFirst(e);
    }

    LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (E val : this) {
            if (val.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;

        for (E val : this) result[i++] = val;

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        } else if (a.length > size) {
            a[size] = null;
        }

        int i = 0;
        Object[] result = a;

        for (E val : this) {
            result[i++] = val;
        }

        return a;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(IntFunction<T[]> generator) {
        T[] result = generator.apply(size);
        int i = 0;

        for (E val: this) result[i++] = (T) val;

        return result;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean add(int i, E e) {
        checkIndexException(i);
        linkBefore(node(i), e);

        return true;
    }

    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (Node<E> curr = first; curr != null; curr = curr.next) {
            if (o.equals(curr.val)) {
                unlink(curr);
                return true;
            }
        }

        return false;
    }

    public E popFirst() {
        return unlinkFirst();
    }

    public E pop() {
        return unlinkLast();
    }

    public E pop(int i) {
        checkIndexException(i);
        return unlink(node(i));
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean removeAll(Collection<?> c) {
        HashSet<E> set = (HashSet<E>) new HashSet<>(c);
        boolean modified = false;

        for (Node<E> curr = first; curr != null; curr = curr.next) {
            if (set.contains(curr.val)) {
                unlink(curr);
                modified = true;
            }
        }

        return modified;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean retainAll(Collection<?> c) {
        HashSet<E> set = (HashSet<E>) new HashSet<>(c);
        boolean modified = false;

        for (Node<E> curr = first; curr != null; curr = curr.next) {
            if (!set.contains(curr.val)) {
                unlink(curr);
                modified = true;
            }
        }

        return modified;
    }

    public E getFirst() {
        return (first == null) ? null : first.val;
    }

    public E getLast() {
        return (last == null) ? null : last.val;
    }

    public E get(int i) {
        checkIndexException(i);

        return node(i).val;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return new ArrayList<>(this).containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }

        return true;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        for (E val : this) {
            action.accept(val);
        }
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

    private Node<E> node(int index) {
        Node<E> curr;

        if (index < size / 2) {
            curr = first;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

        } else {
            curr = last;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr;
    }

    private E unlinkFirst() {
        E val = first.val;
        first = first.next;
        size--;
        if (size == 0) last = null;
        return val;
    }

    private E unlinkLast() {
        E val = last.val;
        last = last.prev;
        size--;
        if (size == 0) first = null;
        return val;
    }

    private E unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev != null) {
            prev.next = next;
        } else {
            first = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            last = prev;
        }

        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return node.val;
    }

    private void linkFirst(E val) {
        Node<E> node = new Node<>(val);

        if (first != null) {
            node.next = first;
            first.prev = node;
        } else {
            last = node;
        }

        first = node;
        size++;
    }

    private void linkLast(E val) {
        Node<E> node = new Node<>(val);

        if (last != null) {
            node.prev = last;
            last.next = node;
        } else {
            first = node;
        }

        last = node;
        size++;
    }

    private void linkBefore(Node<E> next, E val) {
        Node<E> node = new Node<>(val);
        node.prev = next.prev;
        node.next = next;

        if (next.prev == null) {
            first = node;
        }

        size++;
    }

    private class LinkedListIterator implements Iterator<E> {
        Node<E> curr;

        LinkedListIterator() {
            curr = first;
        }

        @Override
        public E next() {
            E val = curr.val;
            curr = curr.next;
            return val;
        }

        @Override
        public boolean hasNext() {
            return (curr != null);
        }
    }

    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    private void checkIndexException(int i) {
        if ((i < 0 || i > size)) {
            throw new IndexOutOfBoundsException();
        }
    }
}
