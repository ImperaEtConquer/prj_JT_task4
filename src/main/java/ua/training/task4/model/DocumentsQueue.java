package ua.training.task4.model;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DocumentsQueue {

	private PriorityQueue<Document> queue;

	public DocumentsQueue() {
		this.queue = new PriorityQueue<>();
	}

	public void addDocuments(ArrayList<Document> documents) {
		queue.addAll(documents);
	}

	public Document peek() {
		return queue.peek();
	}

	public Document poll() {
		return queue.poll();
	}

}
