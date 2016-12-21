package adt.linkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.queue.Queue;
import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class StudentQueueLinkedListTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException{
		
		getImplementations();
		
		// Fila com 3 elementos cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);
		queue2.enqueue(3);
		
		// Fila com 5 elementos cheia.
		queue3.enqueue(1);
		queue3.enqueue(2);
		queue3.enqueue(3);
		queue3.enqueue(4);
		queue3.enqueue(5);
		
	}
	
	private void getImplementations(){
		queue1 = new QueueDoubleLinkedListImpl<>(0); // Deve ter tamanho 0
		queue2 = new QueueDoubleLinkedListImpl<>(3); // Deve ter tamanho 3
		queue3 = new QueueDoubleLinkedListImpl<>(5); // Deve ter tamanho 5
	}

		
	//MÉTODOS DE TESTE
		@Test
		public void testHead() {
			assertEquals(null,queue1.head());
			assertEquals(new Integer(1),queue2.head());
			assertEquals(new Integer(1),queue3.head());
			
			try {
				queue2.dequeue();
			} catch (QueueUnderflowException e) {
				Assert.fail(); // Nao deveria ter lancado excecao.
			}
			
			assertEquals(new Integer(2), queue2.head());
		}
		
		@Test
		public void testIsEmpty() {
			assertTrue(queue1.isEmpty());
			assertFalse(queue2.isEmpty());
			assertFalse(queue3.isEmpty());
			
			try {
				queue2.dequeue();
				queue2.dequeue();
				queue2.dequeue();
			} catch (QueueUnderflowException e) {
				Assert.fail(); // Nao deveria ter lancado excecao.
			}
			
			assertTrue(queue2.isEmpty());
		}

		@Test
		public void testIsFull() {
			assertTrue(queue1.isFull());
			assertTrue(queue2.isFull());
			assertTrue(queue3.isFull());
			
			try {
				queue2.dequeue();
				queue3.dequeue();
			} catch (QueueUnderflowException e) {
				Assert.fail(); // Nao deveria ter lancado excecao.
			}
			
			assertFalse(queue2.isFull());
			assertFalse(queue3.isFull());
		}

		@Test
		public void testEnqueue() {
			try {
				queue2.enqueue(new Integer(4));
				Assert.fail(); // Nao deve chegar aqui pois deveria ter lancado excecao.
			} catch (QueueOverflowException e) {
				assertEquals("Fila cheia", e.getMessage());
			}
			
			try{
				assertTrue(queue2.isFull());
				queue2.dequeue();
				assertFalse(queue2.isFull());
				
				queue2.enqueue(3);
				assertTrue(queue2.isFull());
			}catch(QueueUnderflowException u){
				Assert.fail(); // Nao deveria ter lancado excecao.			
			}catch (QueueOverflowException o) {
				Assert.fail(); // Nao deveria ter lancado excecao.
			}
		}
		
		@Test
		public void testDequeue() {
			try {
				queue1.dequeue();
			} catch (QueueUnderflowException e) {
				assertEquals("Fila vazia", e.getMessage());
			}
			
			try{
				assertTrue(queue2.isFull());
				queue2.dequeue();
				queue2.dequeue();
				queue2.dequeue();
				assertTrue(queue2.isEmpty());
				
				queue2.dequeue();
				Assert.fail(); // Nao deve chegar aqui pois deveria ter lancado excecao.
			}catch(QueueUnderflowException u){
				assertEquals("Fila vazia", u.getMessage());
			}
		}
		
		@Test(expected=QueueOverflowException.class)
		public void testEnqueueComErro() throws QueueOverflowException {
			queue1.enqueue(new Integer(1)); // Deve lancar excecao.
		}
		
		@Test(expected=QueueUnderflowException.class)
		public void testDequeueComErro() throws QueueUnderflowException {
			queue1.dequeue(); // Deve lancar excecao.
		}
}