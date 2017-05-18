package ua.training.task4.controller;

import java.util.ArrayList;

import ua.training.task4.model.DocumentsStorage;
import ua.training.task4.model.University;
import ua.training.task4.view.View;

import static ua.training.task4.view.GlobalConstants.*;

public class Controller {

	private View view;
	private ArrayList<University> universities;
	private int finishedThreadsAmount;

	public Controller(ArrayList<University> universities, View view) {
		this.universities = universities;
		this.view = view;
	}

	public void processUser() {

		DocumentsStorage documentsStorage = new DocumentsStorage();
		ThreadController threadController = new ThreadController(documentsStorage);

		/*
		 * Thread for queue refresh
		 */

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!documentsStorage.areDocumentsEmpty()) {
					documentsStorage.refillQueue();
				}
			}
		}).start();

		/*
		 * Thread for each university
		 */

		for (University university : universities) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (!documentsStorage.areDocumentsEmpty() || !documentsStorage.isQueueEmpty()) {
						threadController.process(university);
					}
					threadEnd();
				}
			}).start();
		}

	}

	private synchronized void threadEnd() {
		finishedThreadsAmount++;
		if (finishedThreadsAmount == universities.size()) {
			for (University uni : universities) {
				StringBuilder sb = new StringBuilder();
				sb.append(uni.getName()).append(SCORE_SYMBOL).append(uni.getDocuments().size());
				view.printMessage(sb.toString());
			}
		}

	}

}
