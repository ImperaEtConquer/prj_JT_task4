package ua.training.task4.controller;

import ua.training.task4.model.DocumentsStorage;
import ua.training.task4.model.University;
import ua.training.task4.view.View;

public class Controller {

	private View view;
	private DocumentsStorage documentsStorage;

	public Controller(DocumentsStorage documentsStorage, View view) {
		this.view = view;
		this.documentsStorage = documentsStorage;
	}

	public synchronized void process(University university) {
		university.acceptStudent(documentsStorage);
	}

}
