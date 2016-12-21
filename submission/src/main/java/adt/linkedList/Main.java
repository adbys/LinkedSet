package adt.linkedList;

import java.util.Arrays;

import lista.ordenada.ListaOrdenada;

public class Main {
	
	public static void main(String[] args) {
		ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();
		
		System.out.println(">>>>>>>");
		
		
		lista.insere(1);
		lista.insere(9);
		lista.insere(3);
		lista.insere(15);
		lista.insere(-1);
		lista.insere(98);
		lista.insere(15);
		lista.insere(125);
		lista.insere(125);
		lista.insere(0);
		lista.insere(0);
		lista.insere(-2);
		lista.insere(-2);
		System.out.println(Arrays.toString(lista.print()));
		
		lista.remove(-1);
		lista.remove(3);
		
		System.out.println(Arrays.toString(lista.print()));
	}

}
