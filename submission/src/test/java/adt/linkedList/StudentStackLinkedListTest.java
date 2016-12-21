package adt.linkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.stack.Stack;
import adt.stack.StackDoubleLinkedListImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class StudentStackLinkedListTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException{

		getImplementations();
		
		// Pilha com 3 elementos cheia.
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		
	
		// Pilha com 5 elementos cheia.
		stack3.push(1);
		stack3.push(2);
		stack3.push(3);
		stack3.push(4);
		stack3.push(5);
	}
	
	private void getImplementations(){
		stack1 = new StackDoubleLinkedListImpl<>(0);
		stack2 = new StackDoubleLinkedListImpl<>(3);
		stack3 = new StackDoubleLinkedListImpl<>(5);
	}
	
	//MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(null, stack1.top());
		assertEquals(new Integer(3), stack2.top());
		assertEquals(new Integer(5), stack3.top());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack1.isEmpty());
		assertFalse(stack2.isEmpty());
		assertFalse(stack3.isEmpty());
		
		try{
			stack2.pop();
			stack2.pop();
			stack2.pop();
		}catch(StackUnderflowException s){
			Assert.fail(); // Nao deveria ter lancado excecao.
		}
		
		assertTrue(stack2.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertTrue(stack1.isFull());
		assertTrue(stack2.isFull());
		assertTrue(stack3.isFull());
		
		try{
			stack2.pop();
		}catch(StackUnderflowException s){
			Assert.fail(); // Nao deveria ter lancado excecao.
		}
		
		assertFalse(stack2.isFull());
	}

	@Test
	public void testPush() {
		try {
			stack2.push(new Integer(4));
		} catch (StackOverflowException e) {
			assertEquals("Stack is full", e.getMessage());
		}
		
		try{
			assertTrue(stack2.isFull());
			stack2.pop();
			
			assertFalse(stack2.isFull());
			stack2.push(new Integer(3));
			assertTrue(stack2.isFull());
		}catch(StackUnderflowException s){
			Assert.fail(); // Nao deveria ter lancado excecao.
		} catch (StackOverflowException e) {
			Assert.fail(); // Nao deveria ter lancado excecao.
		}
	}
	
	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack2.pop());
			assertEquals(new Integer(5), stack3.pop());
		} catch (StackUnderflowException e) {
			Assert.fail(); // Nao deveria ter lancado excecao.
		}
	}
	
	@Test(expected=StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(new Integer(1));
		stack2.push(new Integer(4));
		stack3.push(new Integer(6));
	}
	
	@Test(expected=StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(null, stack1.pop());
	}
}