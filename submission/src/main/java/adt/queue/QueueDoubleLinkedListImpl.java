package adt.queue;
 
import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
 
public class QueueDoubleLinkedListImpl<T extends Comparable<T>> implements Queue<T> {
 
    protected DoubleLinkedList<T> list;
    protected int size;
     
    public QueueDoubleLinkedListImpl(int size) {
        this.size = size;
        this.list = new DoubleLinkedListImpl<T>();
    }
     
    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (element == null)
            return;
         
        if (this.isFull())
            throw new QueueOverflowException();
         
        this.list.insert(element);  
    }
 
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty())
            throw new QueueUnderflowException();
         
        DoubleLinkedListImpl<T> lista = (DoubleLinkedListImpl<T>) this.list;
        T element = lista.getHead().getData();
        lista.removeFirst();
        return element;
    }
 
    @Override
    public T head() {
        DoubleLinkedListImpl<T> lista = (DoubleLinkedListImpl<T>) this.list;
        return lista.getHead().getData();
    }
 
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
 
    @Override
    public boolean isFull() {
        return this.list.size() == this.size;
    }
 
}