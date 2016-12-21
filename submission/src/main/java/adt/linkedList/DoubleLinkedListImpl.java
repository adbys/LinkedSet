package adt.linkedList;
 
public class DoubleLinkedListImpl<T extends Comparable<T>> extends SingleLinkedListImpl<T> implements
        DoubleLinkedList<T> {
 
    protected DoubleLinkedListNode<T> last;
     
    public DoubleLinkedListImpl() {
        super();
        this.head = new DoubleLinkedListNode<T>();
        this.last = new DoubleLinkedListNode<T>();
    }
     
    @Override
    public void insertFirst(T element) {
        DoubleLinkedListNode<T> lastHead = (DoubleLinkedListNode<T>) this.head;
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode(element, lastHead, new DoubleLinkedListNode<>());
        lastHead.setPrevious(newNode);
        if(this.size() == 1){
            this.last = lastHead;
        }
        this.head = newNode;
    }
 
    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            DoubleLinkedListNode<T> newHead = (DoubleLinkedListNode<T>) this.head.getNext();
            newHead.setPrevious(new DoubleLinkedListNode<T>());
            this.head = newHead;
        }
    }
 
    @Override
    public void removeLast() {
        if (!isEmpty()) {
            DoubleLinkedListNode<T> node = this.last.getPrevious();
            node.setNext(new DoubleLinkedListNode<T>());
            this.last = node;
            if (this.size() == 1) {
                this.head = node;
            }
        }
    }
 
    public DoubleLinkedListNode<T> getLast() {
        return last;
    }
 
    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }
     
    @Override
    public void insert(T element) {
         
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode(element, new DoubleLinkedListNode<T>(), this.last);
        this.last.setNext(newNode);
        newNode.setPrevious(this.last);
        this.last = newNode;
         
        if (isEmpty())
            this.head = newNode;
    }
 
    @Override
    public void remove(T element) {
        if (!isEmpty()) {
 
            if (this.head.getData().equals(element)) {
                DoubleLinkedListNode<T> newHead = (DoubleLinkedListNode<T>) this.head.getNext();
                newHead.setPrevious(new DoubleLinkedListNode<T>());
                this.head = newHead;
                if (this.isEmpty())
                    this.last = newHead;
                return;
            }
             
            DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
             
            while (!aux.isNIL() && !aux.getData().equals(element)) {
                aux = (DoubleLinkedListNode<T>) aux.getNext();
            }
 
            if (!aux.isNIL()){
                DoubleLinkedListNode<T> prev = (DoubleLinkedListNode<T>) aux.getPrevious();
                DoubleLinkedListNode<T> next = (DoubleLinkedListNode<T>) aux.getNext();
                next.setPrevious(prev);
                prev.setNext(next);
                 
                if (this.last.equals(aux)) {
                    this.last = prev;
                }
                 
                return;
             }
        }
    }
 
     
     
     
}