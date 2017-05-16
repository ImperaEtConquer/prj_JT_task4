package ua.training.task4.model;

import java.util.ArrayList;

public class University extends Thread {
	private String uniName;
	private ArrayList<Document> documents;
	private DocumentsQueue queue;

	public University(String name, DocumentsQueue queue) {
		this.uniName = name;
		this.queue = queue;
		this.documents = new ArrayList<>();
	}

	public String getUniName() {
		return uniName;
	}

	public synchronized void acceptStudent() {
		documents.add(queue.poll());
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	@Override
	public void run() {
		while (true) {
			acceptStudent();
		}
	}
}
