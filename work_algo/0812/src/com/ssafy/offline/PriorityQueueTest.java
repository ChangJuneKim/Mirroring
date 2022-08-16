package com.ssafy.offline;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
	public static void main(String[] args) {
//		Queue<Integer> queue = new PriorityQueue<>();
//		
//		queue.offer(10);
//		queue.offer(5);
//		queue.offer(11);
//		queue.offer(-1);
//		
//		for (int i = 0; i < queue.size(); i++) {
//			System.out.println(queue.poll());
//		}
		
		Queue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.getScore() - o1.getScore();
			}
		});
		
		queue.offer(new Student(5, 10));
		queue.offer(new Student(7, 60));
		queue.offer(new Student(3, 40));
		queue.offer(new Student(1, 30));
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll().getNo());
		}
	}
}
