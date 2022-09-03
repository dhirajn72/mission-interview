package ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class JavaDeque {
	public static void main(String[] args){
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(1);
		deque.add(2);
		deque.addFirst(3);
		deque.offer(4);
		System.out.println(deque);
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());

	}

}
