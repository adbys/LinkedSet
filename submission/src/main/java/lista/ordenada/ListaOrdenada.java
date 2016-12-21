package lista.ordenada;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class ListaOrdenada<T extends Comparable<T>> {
	
	private SingleLinkedListImpl<T> lista;
	
	public ListaOrdenada() {
		this.lista = new SingleLinkedListImpl<T>();
	}
	
	public boolean isEmpty() {
		return this.lista.isEmpty();
	}
	
	public void insere(T element) {
		
		this.lista.insert(element);
		
	}
	
	public void remove(T element) {
		this.lista.remove(element);
	}
	
	public T[] print() {
		System.out.println(">>>>>>>>1");
		return this.lista.toArray();
	}

}
