package QueueTest;



import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class StudentQueueTest {

	public QueueDoubleLinkedListImpl<Integer> queue1;
	public QueueDoubleLinkedListImpl<Integer> queue2;
	public QueueDoubleLinkedListImpl<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);


	}

	private void getImplementations() {
		queue1 = new QueueDoubleLinkedListImpl(3);
		queue2 = new QueueDoubleLinkedListImpl(2);
		queue3 = new QueueDoubleLinkedListImpl(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertTrue(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue2.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			fail();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
			assertEquals(new Integer(2), queue1.dequeue());
			assertEquals(new Integer(3), queue1.dequeue());
			assertTrue(queue1.isEmpty());
		} catch (QueueUnderflowException e) {
			fail();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
}