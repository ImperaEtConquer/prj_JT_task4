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

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public void acceptStudent(DocumentsStorage documentsStorage) {

		if (criteria.equals(Criteria.ONLY_BIOLOGY)) {
			while (documentsStorage.isNextDocumentValid(Faculty.BIOLOGY)) {
				documents.add(documentsStorage.getDocument());
			}
		}

		if (criteria.equals(Criteria.ONLY_MATH)) {
			while (documentsStorage.isNextDocumentValid(Faculty.MATH)) {
				documents.add(documentsStorage.getDocument());
			}
		}

		if (criteria.equals(Criteria.RANDOM)) {
			int random_amount = new Random().nextInt(RANDOM_TOP_CAP) + RANDOM_BOTTOM_CAP;
			for (int i = 0; i < random_amount; i++) {
				if (!documentsStorage.isQueueEmpty()) {
					documents.add(documentsStorage.getDocument());
				}
			}
		}
	}

}
