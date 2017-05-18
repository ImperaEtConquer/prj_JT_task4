package ua.training.task4.controller;

import ua.training.task4.model.DocumentsStorage;
import ua.training.task4.model.University;

import static ua.training.task4.view.GlobalConstants.*;

public class ThreadController {

	private DocumentsStorage documentsStorage;

	public ThreadController(DocumentsStorage documentsStorage) {
		this.documentsStorage = documentsStorage;
	}

	public synchronized void process(University university) {
		university.acceptStudent(documentsStorage);

		if (university.getName().equals(KPI)) {
			try {
				Thread.sleep(KPI_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
