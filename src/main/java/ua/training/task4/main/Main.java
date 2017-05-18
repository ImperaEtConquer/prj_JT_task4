package ua.training.task4.main;

import java.util.ArrayList;

import ua.training.task4.controller.Controller;
import ua.training.task4.model.Criteria;
import ua.training.task4.model.Document;
import ua.training.task4.model.DocumentsStorage;
import ua.training.task4.model.Faculty;
import ua.training.task4.model.University;
import ua.training.task4.view.View;

public class Main {

	static boolean condition = true;

	public static void main(String[] args) throws InterruptedException {
		DocumentsStorage documentsStorage = new DocumentsStorage();

		Controller controller = new Controller(documentsStorage, new View());

		ArrayList<University> universities = new ArrayList<>();
		universities.add(new University("Cambridge", Criteria.ONLY_BIO));
		universities.add(new University("KPI", Criteria.RANDOM));
		universities.add(new University("Oxford", Criteria.ONLY_MATH));

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!documentsStorage.areDocumentsEmpty()) {
					documentsStorage.refillQueue();
				}
			}
		}).start();

		for (University university : universities) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (!documentsStorage.areDocumentsEmpty() || !documentsStorage.isQueueEmpty())
						controller.process(university);
					tempMethod(universities);
				}
			}).start();
		}

	}

	private synchronized static void tempMethod(ArrayList<University> universities) {
		if (condition) {
			condition = false;

			System.out.println(tempMethod2(universities.get(0), Faculty.BIOLOGY) + " : "
					+ universities.get(0).getDocuments().size());
			System.out.println(universities.get(1).getDocuments().size());
			System.out.println(
					tempMethod2(universities.get(2), Faculty.MATH) + " : " + universities.get(2).getDocuments().size());

		}
	}

	private static boolean tempMethod2(University uni, Faculty fac) {
		for (Document doc : uni.getDocuments()) {
			if (!doc.getFaculty().equals(fac)) {
				return false;
			}
		}
		return true;
	}
}
