package com.pudong.stack;
/**
 * ��ջʵ�ֶ���
 * 
 * @author liqingzhe
 *
 */

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class MyQueue<E> {
	
	private Stack<E> inStack;
	
	private Stack<E> outStack;
	
	
	public MyQueue() {
		this.inStack = new Stack<E>();
		this.outStack = new Stack<E>();
	}

	public int getSize() {
		return this.size;
	}
	//private LinkedBlockingQueue<E> queue = new LinkedBlockingQueue<E>();
 	/**
	 * ���еĳ���
	 */
	private int size;
	
	/**
	 * ���г��ȵ����ֵ
	 */
	private final int QUEUE_SIZE = 1000;
	
	/**
	 * ��� ���������׳��쳣
	 * @param e
	 */
	public void add(E e) {
		
		if (size < QUEUE_SIZE) {
			inStack.push(e);
		} else {
			throw new RuntimeException("��������");
		}
		
		size++;
	}
	/**
	 * ���ӣ�Ϊ�����׳��쳣
	 * @return
	 */
	public E remove() {
		if (!outStack.isEmpty()) {
			size--;
			return outStack.pop();
		} else if (!inStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			size--;
			return outStack.pop();
		}else {
			throw new RuntimeException("����Ϊ�գ�");
		}
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	/**
	 * ���ض���ͷ����Ԫ��
	 */
	public E element() {
		if (!outStack.isEmpty()) {
			return outStack.peek();
		} else if (!inStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			return outStack.peek();
		} else {
			throw new RuntimeException("����Ϊ�գ�");
		}
	}
	
	/**
	 * ���һ��Ԫ�أ��ɹ�����true,ʧ�ܷ���false��
	 * @param e
	 * @return
	 */
	public boolean offer(E e) {
		if (size < QUEUE_SIZE) {
			inStack.push(e);
			size++;
			return true;
		}
		return false;
	}
	
	/**
	 * ���ض���ͷ����Ԫ�أ�����Ϊ���򷵻�null
	 * @return
	 */
	public E peek() {
		if (!outStack.isEmpty()) {
			return outStack.peek();
		} else if (!inStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			return outStack.peek();
		} else {
			return null;
		}
	}

	/**
	 * �Ƴ������ض���ͷ��Ԫ�أ�����Ϊ���򷵻�null��
	 * @return
	 */
	public E poll() {
		
		if (!outStack.isEmpty()) {
			size--;
			return outStack.pop();
		} else if (!inStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			size--;
			return outStack.pop();
		} else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
