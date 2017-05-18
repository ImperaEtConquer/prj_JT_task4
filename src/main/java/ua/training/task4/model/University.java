package ua.training.task4.model;

import java.util.ArrayList;
import java.util.Random;

import static ua.training.task4.view.GlobalConstants.*;

public class University {
	private String name;
	private ArrayList<Document> documents;
	private Criteria criteria;

	public University(String name, Criteria criteria) {
		this.name = name;
		this.criteria = criteria;
		this.documents = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public synchronized void acceptStudent(DocumentsStorage documentsStorage) { // TODO
																				// REDO
		if (criteria.equals(Criteria.ONLY_BIO)) {
			while (documentsStorage.checkNextDocument(Faculty.BIOLOGY)) {
				documents.add(documentsStorage.getDocument());
			}
		}
		if (criteria.equals(Criteria.ONLY_MATH)) {
			while (documentsStorage.checkNextDocument(Faculty.MATH)) {
				documents.add(documentsStorage.getDocument());
			}
		}
		if (criteria.equals(Criteria.RANDOM)) {
			int amount = new Random().nextInt(RANDOM_TOP_CAP) + RANDOM_BOTTOM_CAP;
			for (int i = 0; i < amount; i++) {
				if (!documentsStorage.isQueueEmpty()) {
					documents.add(documentsStorage.getDocument());
				}
			}
		}

		// if (criteria.equals(Criteria.ONLY_BIO)) {
		// boolean condition = true;
		// while (condition) {
		// if (!documentsStorage.isQueueEmpty()) {
		// if (documentsStorage.peek().getFaculty().equals(Faculty.BIOLOGY)) {
		// documents.add(documentsStorage.getDocument());
		// } else {
		// condition = false;
		// }
		// }
		// }
		// }
		//
		// if (criteria.equals(Criteria.ONLY_MATH)) {
		// boolean condition = true;
		// while (condition) {
		// if (!documentsStorage.isQueueEmpty()) {
		// if (documentsStorage.peek().getFaculty().equals(Faculty.MATH)) {
		// documents.add(documentsStorage.getDocument());
		// } else {
		// condition = false;
		// }
		// }
		// }
		// }
		// if (criteria.equals(Criteria.RANDOM)) {
		// int amount = new Random().nextInt(RANDOM_TOP_CAP) +
		// RANDOM_BOTTOM_CAP;
		// for (int i = 0; i < amount; i++) {
		// if (!documentsStorage.isQueueEmpty()) {
		// documents.add(documentsStorage.getDocument());
		// }
		// }
		//
		// }
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}
}
