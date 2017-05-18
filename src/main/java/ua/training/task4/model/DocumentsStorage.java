package ua.training.task4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;

import static ua.training.task4.view.GlobalConstants.*;

public class DocumentsStorage {

	private ArrayList<Document> allDocuments;
	private ConcurrentLinkedQueue<Document> queue;

	public DocumentsStorage() {
		initAllDocuments();
		this.queue = new ConcurrentLinkedQueue<>();
	}

	public Document peek() {
		return queue.peek();
	}

	public boolean checkNextDocument(Faculty faculty) {
		if (!queue.isEmpty()) {
			return queue.peek().getFaculty().equals(faculty);
		} else {
			return false;
		}
	}

	public Document getDocument() {
		return queue.poll();
	}

	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	public boolean areDocumentsEmpty() {
		return allDocuments.isEmpty();
	}

	public void refillQueue() {
		if (queue.size() <= QUEUE_LOW_SIZE) {
			int difference = Math.abs(queue.size() - QUEUE_DEFAULT_SIZE); // TODO
			for (int i = 0; i < difference; i++) {
				addToQueue();
			}
		}
	}

	private void addToQueue() {
		if (!allDocuments.isEmpty()) {
			queue.add(allDocuments.get(0));
			allDocuments.remove(0);
		}
	}

	private void initAllDocuments() {
		this.allDocuments = new ArrayList<>();
		for (int i = 0; i < BIOLOGY_AMOUNT; i++) {
			allDocuments.add(new Document(Faculty.BIOLOGY));
		}
		for (int i = 0; i < MATH_AMOUNT; i++) {
			allDocuments.add(new Document(Faculty.MATH));
		}

		Collections.shuffle(allDocuments);
	}

}
