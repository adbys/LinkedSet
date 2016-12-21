package adt.stack;
 
import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.queue.QueueUnderflowException;
 
public class StackDoubleLinkedListImpl<T extends Comparable<T>> implements Stack<T> {
 
    protected DoubleLinkedList<T> list;
    protected int size;
 
    public StackDoubleLinkedListImpl(int size) {
        this.size = size;
        this.list = new DoubleLinkedListImpl<T>();
    }
 
    @Override
    public void push(T element) throws StackOverflowException {
        if (element == null)
            return;
         
        if (this.isFull())
            throw new StackOverflowException();
         
        this.list.insert(element);
    }
 
    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException();
         
        DoubleLinkedListImpl<T> lista = (DoubleLinkedListImpl<T>) this.list;
        T element = lista.getLast().getData();
        lista.removeLast();
        return element;
    }
 
    @Override
    public T top() {
        DoubleLinkedListImpl<T> lista = (DoubleLinkedListImpl<T>) this.list;
        return lista.getLast().getData();
    }
 
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
 
    @Override
    public boolean isFull() {
        return this.size == this.list.size();
    }
 
}