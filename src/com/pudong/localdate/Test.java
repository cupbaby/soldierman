/**
 * 
 */
package com.pudong.localdate;

import com.pudong.stack.MyQueue;

public class Test {
	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.add(1002);
		myQueue.add(1003);
		myQueue.add(1005);
		myQueue.add(1006);
		/*for (int i = 0; i < myQueue.getSize(); i++) {
			System.out.println(myQueue);
		}*/
		System.out.println(myQueue.isEmpty());
		Integer element = myQueue.element();
		System.out.println(element);
		System.out.println(myQueue.remove());
		System.out.println(myQueue.getSize());
		System.out.println(myQueue.offer(2003));
		System.out.println(myQueue.getSize());
		System.out.println(myQueue.peek());
		System.out.println(myQueue.getSize());
		System.err.println(myQueue.poll());
		System.out.println(myQueue.getSize());
	}
}
